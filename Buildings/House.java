package mooc.vandy.java4android.buildings.logic;

/**
 * This is the House class file that extends Building.
 */
public class House
       extends Building {
    private String mOwner;
    private boolean mPool;

    public House(int length, int width, int lotLength, int lotWidth)
    {
        super(length, width, lotLength, lotWidth);
        mOwner = null;
        mPool = false;
    }

    public House(int length, int width, int lotLength, int lotWidth, String owner)
    {
        super(length, width, lotLength, lotWidth);
        mOwner = owner;
        mPool = false;
    }

    public House(int length, int width, int lotLength, int lotWidth, String owner, boolean pool)
    {
        super(length, width, lotLength, lotWidth);
        mOwner = owner;
        mPool = pool;
    }

    public String getOwner()
    {
        return mOwner;
    }

    public boolean hasPool()
    {
        return mPool;
    }

    public void setOwner(String owner)
    {
        mOwner = owner;
    }

    public void setPool(boolean pool)
    {
        mPool = pool;
    }

    public String toString()
    {
        String string = "";
        if (mPool)
        {
            string += "; has a pool";
        }
        if (calcLotArea() > calcBuildingArea())
        {
            string += "; has a big open space";
        }
        return "Owner: " + mOwner + string;
    }

    public boolean equals(House house)
    {
        if(this.getLength() == house.getLength() &&
        this.mPool == house.mPool)
        {
            return true;
        }
        return false;
    }
}
