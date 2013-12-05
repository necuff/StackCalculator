package Commands;

import java.util.HashMap;
import java.util.List;
import java.util.Stack;

public interface Command {
    public void init(String[] parseCommand);
    public void execute();
}
