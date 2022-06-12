package ru.gb.smykov.level2.hw6;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

//TODO: добавить ввод сообщения с сервера и вывод у клиента
public class EchoServer {
    public static void main(String[] args) {

        try (ServerSocket serverSocket = new ServerSocket(8189)) {
            System.out.println("Ждем подключение клиента...");
            Socket socket = serverSocket.accept();
            System.out.println("Клиент подключился.");
            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            while (true) {
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
