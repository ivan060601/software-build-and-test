package Commands;

public class Shot extends AbstractCommand{
    private final String name = "shot";
    private String args;
    private String[] splitedArgs;

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
            }else if((x >= 0) && (x <= r/2) && (y >= 0) && (y <= r)){
                System.out.println("HIT");
            }else if((x >= 0) && (y <= 0) && (y >= x-r) ){
                System.out.println("HIT");
            }else if((x <= 0) && (y >= 0) && (y*y <= (r*r - x*x) ) ){
                System.out.println("HIT");
            }else {
                System.out.println("MISS");
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
