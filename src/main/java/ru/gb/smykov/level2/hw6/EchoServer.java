package ru.gb.smykov.level2.hw6;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class EchoServer {
    private Socket socket;
    private DataInputStream in;
    private DataOutputStream out;

    public static void main(String[] args) {
        new EchoServer().start();
    }

    private void start() {
        openConnection();
        startReadingThread();
        startWritingThread();
    }

    private void openConnection() {
        try (ServerSocket serverSocket = new ServerSocket(8189)) {
            System.out.println("Ждем подключение клиента...");
            socket = serverSocket.accept();
            System.out.println("Клиент подключился.");

            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void startReadingThread() {
        Thread threadReading = new Thread(() -> {
            try {
                while (true) {
                    String message = in.readUTF();
                    if ("/end".equalsIgnoreCase(message)) {
                        break;
                    }
                    System.out.println("Сообщение от клиента: " + message);
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                closeConnection();
            }

        });
        threadReading.start();
    }

    private void startWritingThread() {
        Thread threadWriting = new Thread(() -> {
            Scanner scanner = new Scanner(System.in);
            while (true) {
                String answer = scanner.nextLine();
                sendMessage(answer);
                if ("/end".equalsIgnoreCase(answer)) {
                    break;
                }
            }
        });
        threadWriting.setDaemon(true);
        threadWriting.start();
    }

    private void closeConnection() {
        if (in != null) {
            try {
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        if (out != null) {
            try {
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        if (socket != null) {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }


    private void sendMessage(String message) {
        try {
            out.writeUTF(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
