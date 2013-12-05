import Commands.Command;
import Commands.InitCommandList;
import Commands.InitDefineList;
import Commands.InitWorkStack;

import java.io.File;
import java.io.FileInputStream;
import java.lang.reflect.Field;
import java.util.*;

public class Factory {
    Properties p;

    List<Command> commandsList;
    HashMap<String, Double> listOfDefine;
    Stack<Double> workStack;

    public Factory(List<Command> commandsList, HashMap<String, Double> listOfDefine, Stack<Double> workStack) throws Exception{
        p = new Properties();
        p.load(new FileInputStream(new File("src/properties.txt")));
        this.commandsList = commandsList;
        this.listOfDefine = listOfDefine;
        this.workStack = workStack;
    }

    private Map<String,Command> commands = new HashMap<String, Command>();

    public Command getCommand(String commandName, String commandParameters) throws Exception {
        Command command = null;

        String toFactory = p.getProperty(commandName.toLowerCase());

        Class c = Class.forName(toFactory);
        command = (Command) c.newInstance();

        // Взять все поля созданного класса
        // Перебрать их и найти поле с отметкой InitWorkStack
        // Проинициализировать это поле стеком


        Field[] fields = c.getDeclaredFields();
        for(Field f: fields){
            if(f.isAnnotationPresent(InitWorkStack.class)){
                f.set(command, workStack);
            }

            if(f.isAnnotationPresent(InitDefineList.class)){
                f.set(command,listOfDefine);
            }

            if(f.isAnnotationPresent(InitCommandList.class)){
                f.set(command,commandsList);
            }
        }

        return command;
    }

    public void registerCommand(String commandName, Command command){
        commands.put(commandName,command);
    }

}
