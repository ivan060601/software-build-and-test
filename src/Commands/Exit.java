package Commands;

public class Exit extends AbstractCommand {
    private final String name = "exit";
    private String args;

    public Exit() {

    }

    @Override
    public void execute() {
        System.out.println("Bye");
        System.exit(0);
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
