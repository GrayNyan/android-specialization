package mooc.vandy.java4android.birthday.logic;

import java.util.Random;

import mooc.vandy.java4android.birthday.ui.OutputInterface;

/**
 * This is where the logic of this App is centralized for this assignment.
 * <p>
 * The assignments are designed this way to simplify your early Android interactions.
 * Designing the assignments this way allows you to first learn key 'Java' features without
 * having to beforehand learn the complexities of Android.
 */
public class Logic
        implements LogicInterface {
    /**
     * This is a String to be used in Logging (if/when you decide you
     * need it for debugging).
     */
    public static final String TAG = Logic.class.getName();

    /**
     * This is the variable that stores our OutputInterface instance.
     * <p>
     * This is how we will interact with the User Interface
     * [MainActivity.java].
     * <p>
     * It is called 'mOut' because it is where we 'out-put' our
     * results. (It is also the 'in-put' from where we get values
     * from, but it only needs 1 name, and 'mOut' is good enough).
     */
    OutputInterface mOut;

    /**
     * This is the constructor of this class.
     * <p>
     * It assigns the passed in [MainActivity] instance
     * (which implements [OutputInterface]) to 'out'
     */
    public Logic(OutputInterface out) {
        mOut = out;
    }

    /**
     * This is the method that will (eventually) get called when the
     * on-screen button labelled 'Process' is pressed.
     */
    public void process() {
        int groupSize = mOut.getSize();
        int simulationCount = mOut.getCount();

        if (groupSize < 2 || groupSize > 365) {
            mOut.println("Error: Group Size must be in the range 2-365.");
            return;
        }
        if (!(simulationCount >= 1 && simulationCount <= 100000)) {
            mOut.println("Error: Simulation Count must be in the range 1-100000.");
            return;
        }

        double percent = calculate(groupSize, simulationCount);

        // report results
        mOut.println("For a group of " + groupSize + " people, the percentage "
                + " of times that two people share the same birthday is "
                + String.format("%.2f%% of the time.", percent));

    }

    /**
     * This is the method that actually does the calculations.
     * <p>
     * We provide you this method that way we can test it with unit testing.
     */
    public double calculate(int size, int count) {
        double success = 0; //number of times where 2 people have the same birthday
        for (int i = 0; i < count; i++)  //runs the simulation "count" number of times
        {
            int[] list = new int[size];
            Random birthday = new Random(i + 1);
            int j = 0;
            do
            {
                list[j] = birthday.nextInt(365);  //gives each person a random birthday
                if (compare(list, j))
                {
                    success++;  //if someone in the list has the same birthday as the one that was just generated, it's a success
                    break;
                }
                j++;
            }
            while (j < list.length);
        }
        return success / count * 100;  //returns the percentage of the result
    }

    public static boolean compare(int[] list, int index)  //compare the newly generated birthday with the rest of the list starting from the beginning
    {
        for (int i = 0; i < index; i++)
        {
            if (list[index] == list[i])
            {
                return true;
            }
        }
        return false;
    }
}
