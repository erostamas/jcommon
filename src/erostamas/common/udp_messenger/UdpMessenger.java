package erostamas.common.udp_messenger;

import erostamas.common.IMessenger;
import erostamas.common.Message;

import java.util.ArrayList;

public class UdpMessenger implements IMessenger{

    public UdpMessenger(int listenPort) {
        _sender = new UdpSender();
        _receiver = new UdpReceiver(listenPort);
        _receiver.start();
    }

    @Override
    public ArrayList<Message> getIncomingMessages() {
        return _receiver.getIncomingMessages();
    }

    @Override
	public boolean sendMessage(Message message) {
        return _sender.sendMessage(message);
    }

    private UdpSender _sender;
    private UdpReceiver _receiver;
}
