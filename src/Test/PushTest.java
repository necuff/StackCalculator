package Test;

import Commands.Push;
import junit.framework.Assert;
import org.junit.Test;

import java.util.LinkedHashMap;
import java.util.Stack;


public class PushTest {
    @Test
    public void testInit() throws Exception {
        String[] parseCommand = {"push", "10"};
        Push push = new Push();
        push.workStack = new Stack<Double>();
        push.listOfDefine = new LinkedHashMap<String, Double>();
        push.init(parseCommand);
        String parameter = push.getPushParameter();
        Assert.assertEquals("10", parameter);
    }

    @Test
    public void testExecute() throws Exception {
        String[] parseCommand = {"push", "10"};
        Push push = new Push();
        push.workStack = new Stack<Double>();
        push.listOfDefine = new LinkedHashMap<String, Double>();
        push.init(parseCommand);
        String parameter = push.getPushParameter();

        push.execute();
        Assert.assertEquals(10., push.workStack.pop());
    }
}
