package com.assignment.client;

import com.assignment.security.AESUtil;
import com.assignment.util.ConfigLoader;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {
	
	 public static void main(String[] args) {

	        try (

	                Socket socket = new Socket(
	                        ConfigLoader.getIP(),
	                        ConfigLoader.getPort());

	                BufferedReader reader =
	                        new BufferedReader(
	                                new InputStreamReader(
	                                        socket.getInputStream()));

	                PrintWriter writer =
	                        new PrintWriter(
	                                socket.getOutputStream(), true);

	                Scanner sc = new Scanner(System.in);

	        ) {

	            System.out.println("Enter Request");

	            System.out.println("Example : SetA-Two");

	            String request = sc.nextLine();


	            String encrypted = AESUtil.encrypt(request);

	    

	            writer.println(encrypted);

	            System.out.println();

	            System.out.println("Response From Server");

	            System.out.println("------------------------");

	            String response;

	            while ((response = reader.readLine()) != null) {

	                System.out.println(AESUtil.decrypt(response));

	            }

	        }

	        catch (Exception e) {

	            e.printStackTrace();

	        }

	    }

}
