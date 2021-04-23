package Communication;

import Commands.*;

public class Terminal {
    private static CommandReader reader = new CommandReader();
    static Help help = new Help();

    public static void main(String[] args) {
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
