package com.assignment.server;


import com.assignment.util.ConfigLoader;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	
	public static void main(String[] args) {

        try {

            int port = ConfigLoader.getPort();

            ServerSocket serverSocket = new ServerSocket(port);

            System.out.println("==================================");
            System.out.println(" Server Started");
            System.out.println(" Listening on Port : " + port);
            System.out.println("==================================");

            while (true) {
            	
            	    System.out.println("Waiting for client...");

                Socket socket = serverSocket.accept();

                System.out.println("Client Connected : "
                        + socket.getInetAddress());

                ClientHandler handler = new ClientHandler(socket);

                handler.start();

            }

        } catch (Exception e) {

            e.printStackTrace();

        }

    }
}
