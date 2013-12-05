package Commands;

import java.util.HashMap;
import java.util.List;
import java.util.Stack;

public class Push implements Command {

    @InitWorkStack
    public Stack<Double> workStack;

    @InitDefineList
    public HashMap<String, Double> listOfDefine;

    String pushingParameter;

    @Override
    public void init(String[] parseCommand) {
        //To change body of implemented methods use File | Settings | File Templates.
        pushingParameter = parseCommand[1];
    }

    @Override
    public void execute() {
        //To change body of implemented methods use File | Settings | File Templates.
        Double int1 = 0d;
        if(listOfDefine.get(pushingParameter) == null){
            int1 = Double.parseDouble(pushingParameter);

        } else {
            int1 = listOfDefine.get(pushingParameter);
        }
        workStack.push(int1);
    }

    public String getPushParameter(){
        return pushingParameter;
    }
}
