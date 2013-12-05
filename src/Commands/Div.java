package Commands;

import java.util.HashMap;
import java.util.List;
import java.util.Stack;

public class Div implements Command {
    @InitWorkStack
    public Stack<Double> workStack;


    @Override
    public void init(String[] parseCommand) {
    }

    @Override
    public void execute() {
        //To change body of implemented methods use File | Settings | File Templates.
        Double div1 = workStack.pop();
        Double div2 = workStack.pop();
        workStack.push(div1/div2);
    }
}
