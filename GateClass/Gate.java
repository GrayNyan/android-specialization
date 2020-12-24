package mooc.vandy.java4android.gate.logic;

/**
 * This file defines the Gate class.
 */
public class Gate {
    public static final int IN = 1;  //initialize and declare vairables
    public static final int OUT = -1;
    public static final int CLOSED = 0;
    private int mSwing;

    public Gate()  //default constructor which sets the gate to CLOSED
    {
        mSwing = CLOSED;
    }

    public boolean setSwing(int direction)
    {  //if the user inputs a valid value, it will change the direction
        if (direction == -1 || direction == 1)
        {
            mSwing = direction;
            return true;
        }
        return false;
    }

    public boolean open(int direction)
    {
        return setSwing(direction);
    }

    public void close()
    {
        mSwing = CLOSED;
    }

    public int getSwingDirection()
    {
        return mSwing;
    }

    public int thru(int count)
    {  //returns the change in number of snails based on the direction
        switch (mSwing)
        {
            case 1:
                return count;
            case -1:
                return -count;
        }
        return 0;
    }

    public String toString()
    {  //output based on the state of the gate
        switch (mSwing)
        {
            case 1:
                return "This gate is open and swings to enter the pen only";
            case -1:
                return "This gate is open and swings to exit the pen only";
            case 0:
                return "This gate is closed";
            default:
                return "This gate has an invalid swing direction";
        }
    }
}
