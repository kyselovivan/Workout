package ua.kyselov.android.workout;


import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class StopwatchFragment extends Fragment {

    private int seconds;
    private boolean running;
    private boolean wasRunning;

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        if(savedInstanceState!=null){
            seconds = savedInstanceState.getInt("seconds");
            running = savedInstanceState.getBoolean("running");
            wasRunning = savedInstanceState.getBoolean("wasRunning");
            if(wasRunning){
                running = true;
            }
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View layout = inflater.inflate(R.layout.fragment_stopwatch, container, false);
        runTimer(layout);
        return layout;
    }

    @Override
    public void onPause(){
        super.onPause();
        wasRunning = running;
        running = false;
    }

    @Override
    public void onResume(){
        super.onResume();
        if(wasRunning) {
            running = true;
        }
    }

    public void onClickStart(View view){
        running = true;
    }
    public void onClickStop(View view){
        running = false;
    }
    public void onClickReset(){
        running = false;
        seconds = 0;
    }

    private void runTimer(View view){
        final TextView timeView = (TextView)view.findViewById(R.id.time_view);
        final Handler handler = new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {
                int hours = seconds / 3600;
                int minute = (seconds%3600)/60;
                int secs = seconds % 60;
                String time = String.format("%d:%02d:%02d", hours,minute,secs);
                timeView.setText(time);
                if(running){
                    seconds++;
                }
                handler.postDelayed(this,1000);
            }
        });
    }

}
