package Commands;

import java.util.Stack;

public class History extends AbstractCommand{
    private final String name = "history";
    private String args;
    private Stack<String> history = new Stack<>();
    private int counter = 0;

    public void addToHistory(String line){
        counter++;
        history.push(Integer.toString(counter) + " - " + line);
    }

    @Override
    public void execute() {
        history.forEach(System.out::println);
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
