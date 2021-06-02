package Commands;

import Beans.Counter;
import Beans.Percentage;
import Beans.PercentageMBean;

public class Shot extends AbstractCommand {
    private final String name = "shot";
    private String args;
    private String[] splitedArgs;
    private Percentage percentage = Percentage.getInstance();
    private Counter counter = Counter.getInstance();

    @Override
    public void execute() {
        float x = 0, y = 0, r = 0;
        try {
            splitedArgs = args.split(" ", 3);
            x = Float.parseFloat(splitedArgs[0]);
            y = Float.parseFloat(splitedArgs[1]);
            r = Float.parseFloat(splitedArgs[2]);

            if (((x < 0) && (y < 0)) || (r == 0)){
                System.out.println("MISS");
                percentage.increaseMiss();
                counter.increaseMiss();
            }else if((x >= 0) && (x <= r/2) && (y >= 0) && (y <= r)){
                System.out.println("HIT");
                percentage.increaseHits();
                counter.increaseHits();
            }else if((x >= 0) && (y <= 0) && (y >= x-r) ){
                System.out.println("HIT");
                percentage.increaseHits();
                counter.increaseHits();
            }else if((x <= 0) && (y >= 0) && (y*y <= (r*r - x*x) ) ){
                System.out.println("HIT");
                percentage.increaseHits();
                counter.increaseHits();
            }else {
                System.out.println("MISS");
                percentage.increaseMiss();
                counter.increaseMiss();
            }
        } catch (Exception e) {
            System.out.println("Wrong usage of shot command. Use help for details");
        }
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
