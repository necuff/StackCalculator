package Commands;

import java.util.HashMap;
import java.util.List;
import java.util.Stack;

public class Exp implements Command {
    @InitWorkStack
    public Stack<Double> workStack;

    @Override
    public void init(String[] parseCommand) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void execute() {
        //To change body of implemented methods use File | Settings | File Templates.
        Double exp1 = workStack.pop();
        workStack.push(Math.exp(exp1));
    }
}
