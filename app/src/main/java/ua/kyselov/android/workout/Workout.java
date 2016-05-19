package ua.kyselov.android.workout;

/**
 * Created by Ivan on 5/19/2016.
 */
public class Workout {
    private String name;
    private String description;

    public static final Workout[] workouts = {
            new Workout("The Limb Loosener"," 5 Handstand push-ups,\n 1 -legged squats\n"),
            new Workout("Core Agony","100 pull-ups,\n 100 push-ups,\n 100 squats"),
            new Workout("Strength and Length","500 meter run,\n 21 * 1,5 pood kettlball swing\n")
    };

    public Workout(String name, String description){
        this.name = name;
        this.description = description;
    }

    public String getName(){
        return name;
    }

    public String getDescription(){
        return description;
    }

    public String toString(){
        return name;
    }
}
