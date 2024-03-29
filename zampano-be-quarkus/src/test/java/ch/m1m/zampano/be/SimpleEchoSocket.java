package ch.m1m.zampano.be;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import org.eclipse.jetty.websocket.api.Session;
import org.eclipse.jetty.websocket.api.StatusCode;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketClose;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketConnect;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketError;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketMessage;
import org.eclipse.jetty.websocket.api.annotations.WebSocket;

/**
 * Basic Echo Client Socket
 */
@WebSocket(maxTextMessageSize = 64 * 1024)
public class SimpleEchoSocket {
    private final CountDownLatch connectLatch;
    private final CountDownLatch closeLatch;

    private Session session;

    public SimpleEchoSocket() {
        this.connectLatch = new CountDownLatch(1);
        this.closeLatch = new CountDownLatch(1);
    }

    public boolean awaitConnected(int duration, TimeUnit unit) throws InterruptedException {
        return this.connectLatch.await(duration, unit);
    }

    public boolean awaitClose(int duration, TimeUnit unit) throws InterruptedException {
        return this.closeLatch.await(duration, unit);
    }

    public void sendTextMessage(String message) {
        if (session != null) {
            try {
                Future<Void> fut;
                fut = session.getRemote().sendStringByFuture(message);
                fut.get(2, TimeUnit.SECONDS);
            } catch (Throwable t) {
                t.printStackTrace();
            }
        } else {
            System.out.println("not connected session=null");
        }
    }

    @OnWebSocketConnect
    public void onConnect(Session session) {
        System.out.printf("onConnect: Got connect: %s%n", session);
        this.session = session;
        connectLatch.countDown();
    }

    @OnWebSocketMessage
    public void onMessage(String msg) {
        System.out.printf("onMessage: Got msg: %s%n", msg);
        if (msg.contains("Thanks")) {
            session.close(StatusCode.NORMAL, "I'm done");
        }
    }

    @OnWebSocketError
    public void onError(Throwable cause) {
        System.out.print("onError: WebSocket Error: ");
        cause.printStackTrace(System.out);
    }

    @OnWebSocketClose
    public void onClose(int statusCode, String reason) {
        System.out.printf("onClose: Connection closed: %d - %s%n", statusCode, reason);
        this.session = null;
        this.closeLatch.countDown(); // trigger latch
    }
}

