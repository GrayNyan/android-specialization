package mooc.vandy.java4android.buildings.logic;

/**
 * This is the Building class file.
 */
public class Building {
    private int mLength;
    private int mWidth;
    private int mLotLength;
    private int mLotWidth;

    public Building(int length, int width, int lotLength, int lotWidth)
    {
        mLength = length;
        mWidth = width;
        mLotLength = lotLength;
        mLotWidth = lotWidth;
    }

    public int getLength()
    {
        return mLength;
    }

    public int getWidth()
    {
        return mWidth;
    }

    public int getLotLength()
    {
        return mLotLength;
    }

    public int getLotWidth()
    {
        return mLotWidth;
    }

    public void setLength(int Length)
    {
        mLength = Length;
    }

    public void setWidth(int Width)
    {
        mWidth = Width;
    }

    public void setLotLength(int LotLength)
    {
        mLotLength = LotLength;
    }

    public void setLotWidth(int LotWdith)
    {
        mLotWidth = LotWdith;
    }

    public int calcBuildingArea()
    {
        return mLength * mWidth;
    }

    public int calcLotArea()
    {
        return mLotLength * mLotWidth;
    }

    public String toString()
    {
        return "a " + mLength + "x" + mWidth + " building";
    }
}
