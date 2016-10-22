package roman.com.habittrackerapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

/**
 * the main and only activity
 */
public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*
        // test the thing is working
        Habit habit = new Habit("brushing teeth", 999, 999);
        DatabaseHandler databaseHandler = new DatabaseHandler(this);
        databaseHandler.addHabit(habit);
        Habit returnedHabit = databaseHandler.getHabit("brushing teeth");
        if(returnedHabit != null){
            System.out.println(">>>" + returnedHabit.toString());
        }else{
            System.out.println(">>> no habit returned");
        }
        */
    }
}
