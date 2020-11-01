package ch.m1m.zampano.be;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import javax.enterprise.context.ApplicationScoped;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.server.ServerEndpoint;
import javax.websocket.Session;

@ServerEndpoint("/api/v1/wsocket")
@ApplicationScoped
public class ChatServer {

    private static final Logger LOG = LoggerFactory.getLogger(ChatServer.class);

    //Map<String, Session> sessions = new ConcurrentHashMap<>();

    Set<Session> sessions = new HashSet<>();

    @OnOpen
    public void onOpen(Session session) {
        sessions.add(session);
        LOG.info("new websocket conn added");
        //broadcast("User " + username + " joined");
    }

    @OnClose
    public void onClose(Session session) {
        sessions.remove(session);
        LOG.info("websocket conn closed");
        //broadcast("User " + username + " left");
    }

    @OnError
    public void onError(Session session, Throwable throwable) {
        sessions.remove(session);
        LOG.info("websocket conn error", throwable);
        //broadcast("User " + username + " left on error: " + throwable);
    }

    @OnMessage
    public void onMessage(Session session, String message) throws IOException {

        LOG.info("websocket new message: {}", message);

        if (message.contains("zPing")) {
            session.getAsyncRemote().sendText(message);
            return;
        }

        broadcast(session, message);
    }

    private void broadcast(Session originSession, String message) {
        sessions.stream().forEach(s -> {
            if (originSession != s) {
                s.getAsyncRemote().sendText(message);
            }
        });
    }
}

/*

message format: {"id":0,"me":true,"name":"markus","message":["from markus to all"]}

 */
