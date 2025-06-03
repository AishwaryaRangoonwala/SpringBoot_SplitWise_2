package com.aishwarya.SpringBoot_SplitWise_2.Commands;

import java.util.List;

public interface Command {
    public boolean matches(String input);
    public void execute(String input);
    public default List<String> getCommandSubStr(String input) {
        return List.of(input.split(" "));
    }
}
