package mooc.vandy.java4android.buildings.logic;

/**
 * This is the cottage class file.  It is a subclass of House.
 */
public class Cottage
       extends House {
    private boolean mSecondFloor;

    public Cottage(int dimension, int lotLength, int lotWidth)
    {
        super(dimension, dimension, lotLength, lotWidth);
    }

    public Cottage(int dimension, int lotLength, int lotWidth, String owner, boolean SecondFloor)
    {
        super(dimension, dimension, lotLength, lotWidth);
        setOwner(owner);
        mSecondFloor = SecondFloor;
    }

    public boolean hasSecondFloor()
    {
        return mSecondFloor;
    }

    public String toString()
    {
        if (mSecondFloor)
        {
            return super.toString() + "; is a two story cottage";
        }
        return super.toString() + "is a cottage";
    }
}

