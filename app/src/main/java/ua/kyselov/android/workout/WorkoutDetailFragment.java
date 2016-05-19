package ua.kyselov.android.workout;


import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class WorkoutDetailFragment extends Fragment {

    private long workoutId;
    private TextView title;
    private TextView description;

    public void setWorkout(long id){
        this.workoutId = id;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_workout_detail, container, false);
    }

    public void onStart(){
        super.onStart();
        View view = getView();
        if(view != null){
            title = (TextView)view.findViewById(R.id.textTitle);
            description = (TextView)view.findViewById(R.id.textDescription);
            Workout workout = Workout.workouts[(int)workoutId];
            title.setText(workout.getName());
            description.setText(workout.getDescription());
        }
    }


//    public WorkoutDetailFragment() {
//        // Required empty public constructor
//    }
}