package Commands;

public abstract class AbstractCommand {
    public abstract void execute();

    public abstract String getName();

    public abstract void setArgs(String arguments);
}
