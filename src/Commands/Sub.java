package Commands;

import java.util.HashMap;
import java.util.List;
import java.util.Stack;

public class Sub implements Command {
    @InitWorkStack
    public Stack<Double> workStack;

    @Override
    public void init(String[] parseCommand) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void execute() {
        //To change body of implemented methods use File | Settings | File Templates.
        Double sub1 = workStack.pop();
        Double sub2 = workStack.pop();
        workStack.push(sub1-sub2);
    }
}
