package Beans;

import javax.management.AttributeChangeNotification;
import javax.management.MBeanNotificationInfo;
import javax.management.Notification;
import javax.management.NotificationBroadcasterSupport;

public class Counter extends NotificationBroadcasterSupport implements CounterMBean {
    private static Counter instance = null;
    private int misses;
    private int hits;
    private int missesInRow;
    private int sequenceNumber = 0;

    private Counter(){
        misses = 0;
        hits = 0;
        missesInRow = 0;
    }

    public static Counter getInstance(){
        if (instance == null){
            instance = new Counter();
        }
        return instance;
    }

    public void increaseMiss(){
        misses++;
        missesInRow++;
        if (missesInRow == 2){
            Notification n = new AttributeChangeNotification(this,
                    sequenceNumber++, System.currentTimeMillis(),
                    "2 misses in a row", "missesInRow", "int",
                    missesInRow, this.missesInRow);
            sendNotification(n);
            missesInRow = 0;
        }
    }

    public void increaseHits(){
        hits++;
        missesInRow = 0;
    }

    @Override
    public int getTotalPoints() {
        return misses + hits;
    }

    @Override
    public int getHitPoints() {
        return hits;
    }

    @Override
    public MBeanNotificationInfo[] getNotificationInfo() {
        String[] types = new String[]{
                AttributeChangeNotification.ATTRIBUTE_CHANGE
        };
        String name = AttributeChangeNotification.class.getSimpleName();
        String description = "Two misses";
        MBeanNotificationInfo info =
                new MBeanNotificationInfo(types, name, description);
        return new MBeanNotificationInfo[]{info};
    }
}
