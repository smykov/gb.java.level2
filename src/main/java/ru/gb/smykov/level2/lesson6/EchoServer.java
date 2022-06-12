package ru.gb.smykov.level2.lesson6;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
//TODO: добавить ввод сообщения с сервера и вывод у клиента
public class EchoServer {
    public static void main(String[] args) {
        /*
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(8189);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (serverSocket != null){
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

         */

        //try-with-resources // автоматически закрывает ресурс объявленный в скобках
        try (ServerSocket serverSocket = new ServerSocket(8189)) {
            System.out.println("Ждем подключение клиента...");
            Socket socket = serverSocket.accept();
            System.out.println("Клиент подключился.");
            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            while (true) { // poison pill
                String message = in.readUTF();
                if ("/end".equalsIgnoreCase(message)) {
                    out.writeUTF(message);
                    break;
                }
                System.out.println("Сообщение от клиента: " + message);
                out.writeUTF("[echo] " + message);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
