package erostamas.common;

import java.util.ArrayList;
import erostamas.common.Message;

public interface IMessenger {
	public ArrayList<Message> getIncomingMessages();
	public boolean sendMessage(Message Message);
}
