package ch.m1m.zampano.be;

import org.glassfish.tyrus.client.ClientManager;

import javax.websocket.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Scanner;
import java.util.concurrent.CountDownLatch;

// https://mvnrepository.com/artifact/org.glassfish.tyrus/tyrus-client/1.17

// https://www.openshift.com/blog/how-to-build-java-websocket-applications-using-the-jsr-356-api

public class ChatClient {

    public static final String WS_URL = "ws://localhost:9000/api/v1/wsocket";

    private String nickName = "bot-1";
    private ClientManager wsClient;
    private Session wsClientSession = null;


    public static void main(String... args) {
        new ChatClient().run();
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            try {
                System.out.println("enter your chat message: ");
                String inLine = scanner.nextLine();

                sendChatMessage(inLine);

                System.out.println("your input was: " + inLine);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void sendChatMessage(String inLine) {

        if (!hasOpenSession()) {
            wsClient = ClientManager.createClient();
            try {
                //latch = new CountDownLatch(1);
                wsClientSession = wsClient.connectToServer(ClientWsEndpoint.class, new URI(WS_URL));

            } catch (DeploymentException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (URISyntaxException e) {
                e.printStackTrace();
            }
        }

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        String textMessage = "this is my hello message";
        try {
            wsClientSession.getBasicRemote().sendText(textMessage);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private String getNickName() {
        return nickName;
    }

    private boolean hasOpenSession() {
        if (wsClientSession == null) return false;
        return wsClientSession.isOpen();
    }
}

@ClientEndpoint
class ClientWsEndpoint {

    @OnError
    public void onError(Session session, Throwable t) {
        System.out.println("onError session " + t.toString());
    }

    @OnOpen
    public void onOpen(Session session) {
        System.out.println("new session opened");

        /*
        session.addMessageHandler(new MessageHandler.Whole<String>() {
            @Override
            public void onMessage(String message) {
                System.out.println("Received message: " + message);
            }
        });
        */
    }

    @OnMessage
    public void onMessage(String message, Session session) {
        System.out.println(String.format("onMessage: %s", message));
    }

    @OnClose
    public void onClose(Session session, CloseReason closeReason) {
        System.out.println(String.format("Session %s close because of %s", session.getId(), closeReason));
    }

}
