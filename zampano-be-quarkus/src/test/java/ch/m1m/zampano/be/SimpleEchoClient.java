package ch.m1m.zampano.be;

import org.eclipse.jetty.websocket.client.ClientUpgradeRequest;
import org.eclipse.jetty.websocket.client.WebSocketClient;

import java.net.URI;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

// https://www.eclipse.org/jetty/documentation/current/jetty-websocket-client-api.html

/**
 * Example of a simple Echo Client.
 */
public class SimpleEchoClient {

    public static void main(String[] args) {
        int index = -1;
        String destUri = "ws://localhost:9000/api/v1/wsocket";
        String nickName = "bot-1";

        if (args.length > 0) {
            destUri = args[0];
        }

        WebSocketClient client = new WebSocketClient();
        SimpleEchoSocket socket = new SimpleEchoSocket();

        try {
            client.start();

            //Thread.sleep(1000);

            URI echoUri = new URI(destUri);
            ClientUpgradeRequest request = new ClientUpgradeRequest();
            System.out.printf("Connecting to : %s%n", echoUri);

            client.connect(socket, echoUri, request);
            socket.awaitConnected(2, TimeUnit.SECONDS);

            Scanner scanner = new Scanner(System.in);

            while (true) {
                try {
                    System.out.println("enter your chat message: ");
                    String inLine = scanner.nextLine();

                    String msg = formatChatMessage(++index, nickName, inLine);
                    socket.sendTextMessage(msg);

                    System.out.println("your input was: " + inLine);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            // wait for closed socket connection.
            //socket.awaitClose(5, TimeUnit.SECONDS);

        } catch (Throwable t) {
            t.printStackTrace();
        } finally {
            try {
                client.stop();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    // {"id":0,"me":true,"name":"markus","message":["hello all"]}
    //
    public static String formatChatMessage(int index, String nickName, String messaage) {
        String resp = String.format("{\"id\":%d,\"me\":true,\"name\":\"%s\",\"message\":[\"%s\"]}",
                index, nickName, messaage);
        return resp;
    }
}

