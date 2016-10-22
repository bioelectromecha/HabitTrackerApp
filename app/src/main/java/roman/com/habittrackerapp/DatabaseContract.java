package roman.com.habittrackerapp;


/**
 * this class defines the database schema for the sqlite database
 */
public final class DatabaseContract {

    public static final  int    DATABASE_VERSION   = 1;
    public static final  String DATABASE_NAME      = "habit_tracker_database";
    private static final String TEXT_TYPE          = " TEXT";
    private static final String INT_TYPE          = " INTEGER";
    private static final String COMMA_SEP          = ",";

    // To prevent someone from accidentally instantiating the contract class,
    // give it an empty constructor.
    private DatabaseContract() {}

    /**
     * this class is a template for other classes to represent a database table
     */
    public static abstract class Tables{

        public static String TABLE_NAME;
        public static String COLUMN_ID;
        public static String CREATE_TABLE;
        public static String DELETE_TABLE;
    }

    /**
     * Table habits.
     */
    public static class TableHabits extends Tables{

        public static final String TABLE_NAME = "habits";

        public static final String COLUMN_ID = "id";
        public static final String COLUMN_NAME = "name";
        public static final String COLUMN_TIME_SPENT = "time_spent";
        public static final String COLUMN_TIMES_REPEATED = "times_repeated";

        public static final String CREATE_TABLE = "CREATE TABLE IF NOT EXISTS " +
                TABLE_NAME + " (" +
                COLUMN_ID + INT_TYPE + " PRIMARY KEY" + COMMA_SEP +
                COLUMN_NAME + TEXT_TYPE + COMMA_SEP +
                COLUMN_TIMES_REPEATED + INT_TYPE + COMMA_SEP +
                COLUMN_TIME_SPENT + INT_TYPE + " )";

        public static final String DELETE_TABLE = "DROP TABLE IF EXISTS " + TABLE_NAME;

    }

}
