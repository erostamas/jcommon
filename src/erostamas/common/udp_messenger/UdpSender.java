package erostamas.common.udp_messenger;

import erostamas.common.IMessageSender;
import erostamas.common.Message;

import java.net.DatagramSocket;
import java.net.DatagramPacket;

public class UdpSender implements IMessageSender {

    private DatagramSocket _socket;

    public UdpSender() {
        try {
            _socket = new DatagramSocket();
        } catch (Exception e) {
            System.err.println("[UdpSender] error during init: " + e.getMessage());
        }
    }

    public boolean sendMessage(Message message) {
        DatagramPacket packet = new DatagramPacket(message.getMessageContent().getBytes(), message.getMessageContent().getBytes().length, message.getEndpoint(), message.getPort());
        try {
            this._socket.send(packet);
        } catch (Exception e) {
            System.err.println("[UdpSender] error during send: " + e.getMessage());
            return false;
        }
        return true;
    }
};