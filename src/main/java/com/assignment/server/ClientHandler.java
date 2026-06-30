package com.assignment.server;
import com.assignment.security.AESUtil;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;

public class ClientHandler extends Thread {
	private final Socket socket;

    public ClientHandler(Socket socket) {

        this.socket = socket;

    }

    @Override
    public void run() {

        try (

                BufferedReader reader = new BufferedReader(
                        new InputStreamReader(socket.getInputStream()));

                PrintWriter writer = new PrintWriter(
                        socket.getOutputStream(), true);

        ) {

            String encryptedRequest = reader.readLine();

            if (encryptedRequest == null) {
                return;
            }

            String request = AESUtil.decrypt(encryptedRequest);

            System.out.println("Received : " + request);

            String[] input = request.split("-");

            if (input.length != 2) {

                writer.println(AESUtil.encrypt("EMPTY"));

                return;

            }

            String setName = input[0].trim();

            String key = input[1].trim();

            Map<String, Integer> map = DataStore.getData().get(setName);

            if (map == null) {

                writer.println(AESUtil.encrypt("EMPTY"));

                return;

            }

            Integer count = map.get(key);

            if (count == null) {

                writer.println(AESUtil.encrypt("EMPTY"));

                return;

            }

            DateTimeFormatter formatter =
                    DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

            for (int i = 0; i < count; i++) {

                String currentTime =
                        LocalDateTime.now().format(formatter);

                writer.println(AESUtil.encrypt(currentTime));

                Thread.sleep(1000);

            }

        }

        catch (Exception e) {

            e.printStackTrace();

        }

        finally {

            try {

                socket.close();

            }

            catch (Exception ignored) {

            }

        }

    }
	
}
