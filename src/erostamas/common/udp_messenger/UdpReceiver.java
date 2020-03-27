package erostamas.common.udp_messenger;

import erostamas.common.interfaces.IMessageReceiver;

public class UdpReceiver implements IMessageReceiver {
    @Override
    public String[] getIncomingMessages() {
        String[] ret = new String[2];
        return ret;
    }
};