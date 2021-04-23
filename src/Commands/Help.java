package Commands;

public class Help extends AbstractCommand {
    private final String name = "help";
    private String args;

    @Override
    public void execute() {
        System.out.println( "help: gives general info about available commands\n" +
                            "exit: terminates the program\n" +
                            "shot x y r: returns whether you hit the aim\n" +
                            "history: prints the history of last 10 entered commands");
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setArgs(String arguments) {
        this.args = arguments;
    }

}
