package erostamas.common.udp_messenger;

import erostamas.common.interfaces.IMessageSender;
import java.net.InetAddress;
import java.net.DatagramSocket;
import java.net.DatagramPacket;

public class UdpSender implements IMessageSender {

    private DatagramSocket _socket;
    private InetAddress _address;
    private int _port;

    public UdpSender(String ipAddress, int port) {
        try {
            _address = InetAddress.getByName(ipAddress);
            _port = port;
            _socket = new DatagramSocket();
        } catch (Exception e) {
            System.err.println("[UdpSender] error during init: " + e.getMessage());
        }
    }

    public boolean sendMessage(String message) {
        DatagramPacket packet = new DatagramPacket(message.getBytes(), message.getBytes().length, this._address, this._port);
        try {
            this._socket.send(packet);
        } catch (Exception e) {
            System.err.println("[UdpSender] error during send: " + e.getMessage());
            return false;
        }
        return true;
    }
};