package Commands;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Define implements Command {
    @InitDefineList
    public HashMap<String, Double> listOfDefine;

    String defineName;
    Double defineValue;

    @Override
    public void init(String[] parseCommand) {
        //To change body of implemented methods use File | Settings | File Templates.
        defineName = parseCommand[1].toString();
        defineValue = Double.parseDouble(parseCommand[2].toString());
    }

    @Override
    public void execute() {
        this.listOfDefine = listOfDefine;
        this.listOfDefine.put(defineName,defineValue);
    }
}
