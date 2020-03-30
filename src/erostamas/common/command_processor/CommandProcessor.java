package erostamas.common.command_processor;

import erostamas.common.ICommandAdapter;
import erostamas.common.ICommand;

import java.util.ArrayList;

public class CommandProcessor {
    private ArrayList<ICommandAdapter> _commandAdapters;

    void processCommands() {
        for (ICommandAdapter commandAdapter : _commandAdapters) {
            for (ICommand command : commandAdapter.getCommands()) {
                command.execute();
            }
        }
    }

    void registerCommandAdapter(ICommandAdapter commandAdapter) {
        _commandAdapters.add(commandAdapter);
    }


};