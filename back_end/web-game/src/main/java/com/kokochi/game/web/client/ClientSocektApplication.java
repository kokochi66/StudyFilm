package com.kokochi.game.web.client;

import java.util.Scanner;

public class ClientSocektApplication {

    public static void main(String[] args) {
        String host = "127.0.0.1";
        int port = 9999;
        try {
            System.out.println("Enter message length: ");
            Scanner sc = new Scanner(System.in);
            int messageLength = Integer.parseInt(sc.nextLine());

            NonSslSocket socket = new NonSslSocket(host, port);
            socket.run(messageLength);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
