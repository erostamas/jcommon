package erostamas.common.test.apps;

import java.net.InetAddress;

import erostamas.common.udp_messenger.UdpSender;
import erostamas.common.Message;

import java.lang.Thread;

public class TestUdpSender {
    public static void main (String args[]) {
        if (args.length < 2) {
            System.err.println("Usage: TestUdpSender <target_ip_address> <target_port>");
            System.exit(1);
        }

        int port = 0;
        try {
            InetAddress address = InetAddress.getByName(args[0]);
            port = Integer.parseInt(args[1]);
            UdpSender udpSender = new UdpSender();
            while(true) {
                udpSender.sendMessage(new Message(Long.toString(System.currentTimeMillis()/1000), address, port));
                try {
                    Thread.sleep(1000);
                } catch (Exception e) {

                }
            }
        } catch (Exception e) {
            System.err.println("Cannot parse address: " + args[0] + " or convert port to integer: " + args[1]);
            System.exit(1);
        }
    }
};
