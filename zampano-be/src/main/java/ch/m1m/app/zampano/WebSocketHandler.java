package ch.m1m.app.zampano;

import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

@Component
public class WebSocketHandler extends TextWebSocketHandler {

    private static final Logger log = LoggerFactory.getLogger(WebSocketHandler.class);

    List<WebSocketSession> sessions = new CopyOnWriteArrayList<>();

    @Override
    public void handleTextMessage(WebSocketSession session, TextMessage message)
            throws InterruptedException, IOException {

        String messageText = message.getPayload();

        log.info("ws message received: {}", messageText);
        if (messageText.contains("zPing")) {
            session.sendMessage(message);
            return;
        }

        for (WebSocketSession webSocketSession : sessions) {
            //Map value = new Gson().fromJson(message.getPayload(), Map.class);
            //webSocketSession.sendMessage(new TextMessage("Hello " + value.get("name") + " !"));
            if (webSocketSession != session) {
                webSocketSession.sendMessage(message);
            }
        }
    }

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        log.info("ws connection established");
        sessions.add(session);
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        log.info("ws connection closed");
        sessions.remove(session);
    }
}
