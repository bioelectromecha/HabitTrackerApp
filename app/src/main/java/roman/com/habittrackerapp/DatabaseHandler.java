package roman.com.habittrackerapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * this class is responsible for performing CRUD operations with the sqlite database
 */
public class DatabaseHandler extends SQLiteOpenHelper {

    /**
     * main constructor
     *
     * @param context
     */
    public DatabaseHandler(Context context) {
        super(context, DatabaseContract.DATABASE_NAME, null, DatabaseContract.DATABASE_VERSION);
    }

    /**
     * initialize database on first use of app
     *
     * @param db
     */
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(DatabaseContract.TableHabits.CREATE_TABLE);
    }

    /**
     * on database upgrade - drop all tables and re-create the database
     *
     * @param db
     * @param oldVersion
     * @param newVersion
     */
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL(DatabaseContract.TableHabits.DELETE_TABLE);

        // Create tables again
        onCreate(db);
    }

    /**
     * this method adds a habit to the database
     *
     * @param habit
     */
    public void addHabit(Habit habit) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(DatabaseContract.TableHabits.COLUMN_NAME, habit.getName());
        values.put(DatabaseContract.TableHabits.COLUMN_TIME_SPENT, habit.getTimesRepeated());
        values.put(DatabaseContract.TableHabits.COLUMN_TIMES_REPEATED, habit.getTimeSpent());

        // Insert Row
        long rowId = db.insert(DatabaseContract.TableHabits.TABLE_NAME, null, values);

        //close the connection
        db.close();
    }

    /**
     * this method retrieves a habit from the database
     *
     * @param name the name of the habit to retrieve
     * @return a Habit object, or null if it doesn't exist in the db
     */
    public Habit getHabit(String name) {

        SQLiteDatabase db = this.getReadableDatabase();

        String[] tableColumns = {DatabaseContract.TableHabits.COLUMN_NAME, DatabaseContract.TableHabits.COLUMN_TIMES_REPEATED, DatabaseContract.TableHabits.COLUMN_TIME_SPENT};
        String whereClause = "name = ?";
        String[] whereArgs = { name };

        Cursor cursor = db.query(DatabaseContract.TableHabits.TABLE_NAME,
                tableColumns,
                whereClause,
                whereArgs, null, null, null);

        //if cursor is not empty
        if (cursor.moveToFirst()) {
            int nameIndex = cursor.getColumnIndex(DatabaseContract.TableHabits.COLUMN_NAME);
            int timesRepeatedIndex = cursor.getColumnIndex(DatabaseContract.TableHabits.COLUMN_TIMES_REPEATED);
            int timeSpentIndex = cursor.getColumnIndex(DatabaseContract.TableHabits.COLUMN_TIME_SPENT);

            return new Habit(cursor.getString(nameIndex), cursor.getInt(timesRepeatedIndex), cursor.getInt(timeSpentIndex));
        }else{
            //if cursor is empty
            return null;
        }

    }
}
