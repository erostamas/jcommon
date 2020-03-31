package erostamas.common;

import java.net.InetAddress;

public class Message {
    private String _messageContent;
    private InetAddress _endpoint;
    private int _port;

    public Message(String messageContent, InetAddress endpoint, int port) {
        _messageContent = messageContent.trim();
        _endpoint = endpoint;
        _port = port;
    }
    
    public String getMessageContent() {
        return _messageContent;
    }

    public InetAddress getEndpoint() {
        return _endpoint;
    }

    public int getPort() {
        return _port;
    }
}
