package Commands;

import java.util.HashMap;
import java.util.List;
import java.util.Stack;

public class Add implements Command {
    @InitWorkStack
    public Stack<Double> workStack;


    @Override
    public void init(String[] parseCommand) {}

    @Override
    public void execute() {
        //To change body of implemented methods use File | Settings | File Templates.
        Double add1 = this.workStack.pop();
        Double add2 = this.workStack.pop();
        this.workStack.push(add1 + add2);
    }
}
