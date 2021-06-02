package Communication;

import Beans.Counter;
import Beans.Percentage;
import Commands.*;

import javax.management.*;
import java.lang.management.ManagementFactory;

public class Terminal {
    private static CommandReader reader = new CommandReader();
    static Help help = new Help();

    public static void main(String[] args) throws MalformedObjectNameException, NotCompliantMBeanException, InstanceAlreadyExistsException, MBeanRegistrationException {

        MBeanServer mbs = ManagementFactory.getPlatformMBeanServer();
        ObjectName percentageName = new ObjectName("Commands:type=Percentage");
        Percentage percentage = Percentage.getInstance();
        ObjectName counterName = new ObjectName("Commands:type=Counter");
        Counter counter = Counter.getInstance();
        mbs.registerMBean(counter,counterName);
        mbs.registerMBean(percentage,percentageName);

        AbstractCommand currentCommand;
        while(true){
            currentCommand = reader.getCommand();
            try {
                currentCommand.execute();
            } catch (Exception e) {
                System.out.println("Unknown command");
            }
        }
    }
}
