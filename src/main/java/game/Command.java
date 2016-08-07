package game;

import org.springframework.stereotype.Component;

@Component
public class Command {
    String command;

    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
    }
}
