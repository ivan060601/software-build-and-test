package Beans;

public class Percentage implements PercentageMBean {
    private static Percentage instance = null;
    private float missses;
    private float hits;

    private Percentage(){
        missses = 0;
        hits = 0;
    }

    public static Percentage getInstance(){
        if (instance == null){
            instance = new Percentage();
        }
        return instance;
    }

    public void increaseMiss(){
        missses++;
    }

    public void increaseHits(){
        hits++;
    }

    @Override
    public float countPercentage() {
        return hits/(hits + missses);
    }
}
