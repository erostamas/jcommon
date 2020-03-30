package erostamas.common.test.apps;

import erostamas.common.udp_messenger.UdpMessenger;
import erostamas.common.Message;

import java.lang.Thread;
import java.util.ArrayList;

public class TestUdpMessenger {
    public static void main (String args[]) {
        if (args.length < 1) {
            System.err.println("Usage: TestUdpReceiver <listen_port>");
            System.exit(1);
        }

        int port = 0;
        try {
            port = Integer.parseInt(args[0]);
        } catch (Exception e) {
            System.err.println("Cannot convert port to integer: " + args[0]);
            System.exit(1);
        }
        UdpMessenger messenger = new UdpMessenger(port);

        while(true) {
            ArrayList<Message> messages = messenger.getIncomingMessages();
            if (messages.size() > 0) {
                for (Message message : messages) {
                    System.out.println("[TestUdpMessenger] Received message: '" + message.getMessageContent() + "' from: " + message.getEndpoint());
                    messenger.sendMessage(new Message("ACK", message.getEndpoint(), 50004));
                }
            }
            try {
                Thread.sleep(1000);
            } catch (Exception e) {

            }
        }
    }
};
