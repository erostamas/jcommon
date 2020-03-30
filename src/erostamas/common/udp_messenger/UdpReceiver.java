package erostamas.common.udp_messenger;

import erostamas.common.IMessageReceiver;
import erostamas.common.Message;

import java.net.DatagramSocket;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.util.concurrent.Semaphore;
import java.util.ArrayList;

public class UdpReceiver extends Thread implements IMessageReceiver {

    private DatagramSocket _socket;
    private byte[] _buf = new byte[256];
    private Semaphore _incomingMessagesMutex = new Semaphore(1);
    private ArrayList<Message> _incomingMessages = new ArrayList<Message>();

    public UdpReceiver(int port) {
        try {
            _socket = new DatagramSocket(port);
            System.out.println("[UdpReceiver] Receiver listening on port " + Integer.toString(port));
        } catch (Exception e) {
            System.err.println("[UdpReceiver] Failed to open socket");
        }
    }

    public void run() {
 
        while (true) {
            DatagramPacket packet = new DatagramPacket(_buf, _buf.length);
            try  {
                _socket.receive(packet);
            } catch (Exception e) {
                System.err.println("[UdpReceiver] Failed to receive packet");
            }
             
            InetAddress address = packet.getAddress();
            int port = packet.getPort();
            packet = new DatagramPacket(_buf, _buf.length, address, port);
            Message received = new Message(new String(packet.getData(), 0, packet.getLength()), address, port);
            try {
                _incomingMessagesMutex.acquire();
                _incomingMessages.add(received);
            } catch (InterruptedException e) {
                System.err.println("[UdpReceiver] Lock interrupted");
            } finally {
                _incomingMessagesMutex.release();
            }
        }
    }

    @Override
    public ArrayList<Message> getIncomingMessages() {
        ArrayList<Message> ret = new ArrayList<Message>();
        try {
            _incomingMessagesMutex.acquire();
            ret = new ArrayList<Message>(_incomingMessages);
            _incomingMessages.clear();
        } catch (InterruptedException e) {

        } finally {
            _incomingMessagesMutex.release();
        }
        return ret;
    }
};
