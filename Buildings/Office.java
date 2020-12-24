package mooc.vandy.java4android.buildings.logic;

/**
 * This is the office class file, it is a subclass of Building.
 */
public class Office
       extends Building {
    private String mBusinessName;
    private int mParkingSpaces;
    private static int sTotalOffices = 0;

    public Office(int length, int width, int lotLength, int lotWidth)
    {
        super(length, width, lotLength, lotWidth);
        mBusinessName = null;
        mParkingSpaces = 0;
        sTotalOffices++;
    }

    public Office(int length, int width, int lotLength, int lotWidth, String businessName)
    {
        super(length, width, lotLength, lotWidth);
        mBusinessName = businessName;
        mParkingSpaces = 0;
        sTotalOffices++;
    }

    public Office(int length, int width, int lotLength, int lotWidth, String businessName, int parkingSpaces)
    {
        super(length, width, lotLength, lotWidth);
        mBusinessName = businessName;
        mParkingSpaces = parkingSpaces;
        sTotalOffices++;
    }

    public String getBusinessName()
    {
        return mBusinessName;
    }

    public int getParkingSpaces()
    {
        return mParkingSpaces;
    }

    public static int getTotalOffices()
    {
        return sTotalOffices;
    }

    public void setBusinessName(String name)
    {
        mBusinessName = name;
    }

    public void setParkingSpaces(int number)
    {
        mParkingSpaces = number;
    }

    public String toString()
    {
        if (mBusinessName == null)
        {
            return "Business: unoccupied" + " (total offices: " + sTotalOffices + ")";
        }
        return "Business: " + mBusinessName + " (total offices: " + sTotalOffices + ")";
    }

    public boolean equals(Office office)
    {
        if(this.calcBuildingArea() == office.calcBuildingArea() &&
        this.mParkingSpaces == office.mParkingSpaces)
        {
            return true;
        }
        return false;
    }
}

