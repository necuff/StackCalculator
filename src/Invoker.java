import Commands.Command;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;


public class Invoker {

    public void executeCommands(HashMap<String,Double> listOfDefine, List<Command> commandsList, Stack<Double> workStack){
        for(Command c : commandsList){
            c.execute();
        }
    }
}
