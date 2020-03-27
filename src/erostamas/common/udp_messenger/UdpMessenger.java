package erostamas.common.udp_messenger;

import erostamas.common.interfaces.IMessenger;

public class UdpMessenger implements IMessenger{

    UdpMessenger(String IpAddress, int port) {

    }

    @Override
    public String[] getIncomingMessages() {
        return _receiver.getIncomingMessages();
    }

    @Override
	public boolean sendMessage(String message) {
        return _sender.sendMessage(message);
    }

    private UdpSender _sender;
    private UdpReceiver _receiver;
}
