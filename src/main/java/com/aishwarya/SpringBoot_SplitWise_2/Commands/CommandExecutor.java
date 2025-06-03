package com.aishwarya.SpringBoot_SplitWise_2.Commands;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CommandExecutor {
    private List<Command> commandList;

    public CommandExecutor() {
        commandList = new ArrayList<>();
    }

    public void register(Command command) {
        commandList.add(command);
    }

    public void execute(String input) {
        for (Command command : commandList) {
            if (command.matches(input)) {
                command.execute(input);
                return;
            }
        }
        if (input.equalsIgnoreCase("quit")) return;
        System.out.println("Invalid command");
    }
}
