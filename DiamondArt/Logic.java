package mooc.vandy.java4android.diamonds.logic;

import mooc.vandy.java4android.diamonds.ui.OutputInterface;

/**
 * This is where the logic of this App is centralized for this assignment.
 * <p>
 * The assignments are designed this way to simplify your early
 * Android interactions.  Designing the assignments this way allows
 * you to first learn key 'Java' features without having to beforehand
 * learn the complexities of Android.
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
     * This is how we will interact with the User Interface [MainActivity.java].
     * <p>
     * It is called 'out' because it is where we 'out-put' our
     * results. (It is also the 'in-put' from where we get values
     * from, but it only needs 1 name, and 'out' is good enough).
     */
    private OutputInterface mOut;

    /**
     * This is the constructor of this class.
     * <p>
     * It assigns the passed in [MainActivity] instance (which
     * implements [OutputInterface]) to 'out'.
     */
    public Logic(OutputInterface out){
        mOut = out;
    }

    /**
     * This is the method that will (eventually) get called when the
     * on-screen button labeled 'Process...' is pressed.
     */
    public void process(int size) {
        mOut.print("+"); //top left corner of the picture frame
        for (int i = 0; i < size * 2; i++) //top of the picture frame
        {
            mOut.print("-");
        }
        mOut.println("+"); //top right corner of the picture frame

        for (int i = 0; i < size - 1; i++)  //top half of the diamond
        {
            mOut.print("|");  //left side of the picture frame
            for (int j = 0; j < size - i - 1 ; j++)  //empty spaces on the left side
            {
                mOut.print(" ");
            }
            mOut.print("/"); //upper left side of the diamond
            if (i % 2 == 0)  //if it's an even row print equal signs
            {
                for (int j = 0; j < 2 * i; j++)
                {
                    mOut.print("=");
                }
            }
            else //if it's an odd row print dashes
            {
                for (int j = 0; j < 2 * i; j++)
                {
                    mOut.print("-");
                }
            }
            mOut.print("\\"); //upper right side of the diamond
            for (int j = 0; j < size - i - 1 ; j++)  //empty spaces on the right side
            {
                mOut.print(" ");
            }
            mOut.println("|"); //right side of the picture frame
        }

        mOut.print("|");  //left side of the picture frame
        mOut.print("<"); //left center corner
        if ((size + 1) % 2 == 0)  //if the center is an even row print equal signs
        {
            for (int j = 0; j < 2 * size - 2; j++)
            {
                mOut.print("=");
            }
        }
        else //if the center is an odd row print dashes
        {
            for (int j = 0; j < 2 * size - 2; j++)
            {
                mOut.print("-");
            }
        }
        mOut.print(">"); //right center corner
        mOut.println("|"); //right side of the picture frame

        for (int i = 0; i < size - 1; i++)  //lower half of the diamond
        {
            mOut.print("|");  //left side of the picture frame
            for (int j = 0; j < i + 1; j++)  //empty spaces on the left side
            {
                mOut.print(" ");
            }
            mOut.print("\\"); //lower left side of the diamond
            if ((size + i) % 2 == 0)  //if it's an even row print equal signs
            {
                for (int j = 0; j < 2 * (size - i - 2); j++)
                {
                    mOut.print("=");
                }
            }
            else //if it's an odd row print dashes
            {
                for (int j = 0; j < 2 * (size - i - 2); j++)
                {
                    mOut.print("-");
                }
            }
            mOut.print("/"); //lower right side of the diamond
            for (int j = 0; j < i + 1; j++)  //empty spaces on the right side
            {
                mOut.print(" ");
            }
            mOut.println("|"); //right side of the picture frame
        }

        mOut.print("+"); //bottom left corner of the picture frame
        for (int i = 0; i < size * 2; i++) //bottom of the picture frame
        {
            mOut.print("-");
        }
        mOut.print("+"); //bottom right corner of the picture frame
    }
}
