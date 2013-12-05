import Commands.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

public class Calculator {
    List<Command> commandsList = new LinkedList<Command>();
    HashMap<String, Double> listOfDefine = new HashMap<String, Double>();
    Stack<Double> workStack = new Stack<Double>();

    /**
     * Калькулятор либо читает файл построчно, либо принимает реалтайм команды
     * После прочтения команды вызывается парсер, который вытаскивает из команды первое слово
     * Если такая команда существует, вызывается фабрика, которая создает экземпляр класса команда
     * Созданная команда помещается в список команд
     * <p/>
     * После того, как чтение команд закончено, вызывается класс Invoker
     * Он читает список имеющихся команд и вызывает у них метод execute
     * Property перенести в Factory
     */

    public void run() throws Exception {
        System.out.println("Запускаем калькулятор");

        //Properties p = new Properties();
        //p.load(new FileInputStream(new File("src/properties.txt")));

        //Создаем фабрику
        Factory f = new Factory(commandsList, listOfDefine, workStack);
        //Создаем исполнялку
        Invoker invoker = new Invoker();
        Scanner s = null;

        try {
            //Читаем файл с командами
            s = new Scanner(new File("src/commands.txt"));
            while (s.hasNext()) {
                //Текст команды записывается в command
                String command = s.nextLine();
                if (command.charAt(0) != '#') {     //Проверка на закомментированную строку
                    String[] parseCommand = command.split(" ");     //Разбиваем строку на слова
                    //Достаем команду из фабрики
                    Command c = f.getCommand(parseCommand[0], command);
                    //Инициализируем команду параметрами
                    c.init(parseCommand);
                    //Добавляем команду в лист команд
                    this.commandsList.add(c);
                }
            }
        } finally {
            s.close();
        }
        //Запускаем список команд на исполнение
        invoker.executeCommands(listOfDefine, commandsList, workStack);


    }
}
