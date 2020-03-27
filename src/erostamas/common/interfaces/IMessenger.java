package erostamas.common.interfaces;

public interface IMessenger {
	public String[] getIncomingMessages();
	public boolean sendMessage(String message);
}
