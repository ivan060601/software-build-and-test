package Communication;

import Commands.*;

import java.util.Scanner;

public class CommandReader {
    private Scanner scanner = new Scanner(System.in);
    private AbstractCommand[] abstractCommands = new AbstractCommand[]{new Exit(), new Help(), new History(), new Shot()};
    History history = (History) abstractCommands[2];

    public AbstractCommand getCommand(){
        String line = null;
        try {
            line = scanner.nextLine().trim().toLowerCase();
        } catch (Exception e) {
            System.out.println("Forced termination");
            System.exit(0);
        }

        history.addToHistory(line);
        String[] splittedCommand = line.split(" ", 2);
        String commandName = splittedCommand[0];
        String arguments = null;
        if (splittedCommand.length > 1){
            arguments = splittedCommand[1];
        }
        for (int i = 0; i < abstractCommands.length; i++) {
            if (commandName.equals(abstractCommands[i].getName())){
                abstractCommands[i].setArgs(arguments);
                return abstractCommands[i];
            }
        }
        return null;
    }
}
