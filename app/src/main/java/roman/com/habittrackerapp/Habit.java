package roman.com.habittrackerapp;

/**
 *  a dataobject encapsulating a single habit
 */
public class Habit {
    private String mName;
    private int mTimesRepeated;
    private int mTimesSpent;

    public Habit(String name, int timesRepeated, int timesSpent) {
        mName = name;
        mTimesRepeated = timesRepeated;
        mTimesSpent = timesSpent;
    }

    public String getName() {
        return mName;
    }

    public int getTimesRepeated() {
        return mTimesRepeated;
    }

    public int getTimeSpent() {
        return mTimesSpent;
    }

    /**
     * returnes a string representation of the object
     * @return
     */
    @Override
    public String toString() {
        return ">>> Habit{" +
                "mName='" + mName + '\'' +
                ", mTimesRepeated=" + mTimesRepeated +
                ", mTimesSpent=" + mTimesSpent +
                '}';
    }
}
