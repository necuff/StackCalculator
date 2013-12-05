package Commands;

import java.util.HashMap;
import java.util.List;
import java.util.Stack;

public class Print implements Command {

    @InitWorkStack
    public Stack<Double> workStack;

    String text;
    @Override
    public void execute() {
        //To change body of implemented methods use File | Settings | File Templates.
        if(!text.equals("")){
            System.out.println(text);
        } else {
            System.out.println(workStack.peek());
        }
    }

    @Override
    public void init(String[] parseCommand) {
        //To change body of implemented methods use File | Settings | File Templates.
        if(parseCommand.length > 0){
            StringBuilder sb = new StringBuilder();
            for(int i=1; i<parseCommand.length; i++){
                sb.append(parseCommand[i] + " ");
            }
            text = sb.toString();
        }
    }
}
