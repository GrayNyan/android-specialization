package mooc.vandy.java4android.gate.logic;

import java.util.Random;

import mooc.vandy.java4android.gate.ui.OutputInterface;

/**
 * This class uses your Gate class to manage a herd of snails.  We
 * have supplied you will the code necessary to execute as an app.
 * You must fill in the missing logic below.
 */
public class HerdManager {
    /**
     * Reference to the output.
     */
    private OutputInterface mOut;

    /**
     * The input Gate object.
     */
    private Gate mWestGate;

    /**
     * The output Gate object.
     */
    private Gate mEastGate;

    /**
     * Maximum number of iterations to run the simulation.
     */
    private static final int MAX_ITERATIONS = 10;

    /**
     * Constructor initializes the fields.
     */
    public HerdManager(OutputInterface out,
                       Gate gate1,
                       Gate gate2) {
        mOut = out;

        mWestGate = gate1;
        mEastGate = gate2;
        mWestGate.open(Gate.IN);
        mEastGate.open(Gate.OUT);
    }

    public static final int HERD = 24;

    public void simulateHerd(Random rand)
    {  //initial value in the pen
        int count = HERD;
        mOut.println("There are currently " + count + " snails in the pen and "
                + (HERD - count) + " snails in the pasture");
        for (int i = 0; i < 10; i++)
        {
            switch (count)
            {  //if the number of snails match any of the cases or none, it will add or subtract a random amount
                case HERD:
                    count -= (rand.nextInt(count) + 1);
                    break;
                case 0:
                    count += (rand.nextInt(HERD + 1) + 1);
                    break;
                default:
                    count += (rand.nextBoolean()
                            ? -(rand.nextInt(count) + 1)
                            : rand.nextInt(HERD - count) + 1);
            }
            mOut.println("There are currently " + count + " snails in the pen and "
                    + (HERD - count) + " snails in the pasture");
        }
    }
}
