package erostamas.common;

import java.util.ArrayList;

public abstract class ICommandAdapter {
    private ArrayList<IMessageReceiver> _messageReceivers;

    public ArrayList<ICommand> getCommands() {
        ArrayList<ICommand> ret = new ArrayList<ICommand>();
        for (IMessageReceiver receiver : _messageReceivers) {
            for (Message message : receiver.getIncomingMessages()) {
                ret.add(convertMessage(message.getMessageContent()));
            }
        }
        return ret;
    }

    public void registerMessageReceiver(IMessageReceiver messageReceiver) {
        _messageReceivers.add(messageReceiver);
    }

    abstract ICommand convertMessage(String message);
};
