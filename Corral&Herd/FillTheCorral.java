package mooc.vandy.java4android.gate.logic;

import java.util.Random;

import mooc.vandy.java4android.gate.ui.OutputInterface;

/**
 * This class uses your Gate class to fill the corral with snails.  We
 * have supplied you will the code necessary to execute as an app.
 * You must fill in the missing logic below.
 */
public class FillTheCorral {
    /**
     * Reference to the OutputInterface.
     */
    private OutputInterface mOut;

    /**
     * Constructor initializes the field.
     */
    FillTheCorral(OutputInterface out) {
        mOut = out;
    }

    public void setCorralGates(Gate[] gate, Random rand)
    {
        for (int i = 0; i < gate.length; i++)
        {
            gate[i].setSwing(rand.nextInt(3) - 1);
            mOut.println("Gate " + i + ":" + gate[i]);
        }
    }

    public boolean anyCorralAvailable(Gate[] corral)
    {
        for (Gate gate : corral)
        {
            if (gate.getSwingDirection() == Gate.IN)
            {
                return true;
            }
        }
        return false;
    }

    public int corralSnails(Gate[] corral, Random rand)
    {
        int count = 0;
        int snails = 5;
        while (snails > 0)
        {
            int G = rand.nextInt(corral.length);
            int S = rand.nextInt(snails) + 1;
            switch (corral[G].getSwingDirection())
            {
                case Gate.IN:
                    snails -= S;
                    mOut.println(S + " are trying to move through corral " + G);
                    break;

                case Gate.OUT:
                    snails += S;
                    mOut.println(S + " are trying to move through corral " + G);
                    break;

                case Gate.CLOSED:
                    mOut.println(S + " are trying to move through corral " + G);
            }
            count++;
        }
        mOut.println("It took " + count + " attempts to corral all of the snails.");
        return count;
    }
}
