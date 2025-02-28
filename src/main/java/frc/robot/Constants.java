package frc.robot;

import edu.wpi.first.wpilibj.Timer;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
  public static class OperatorConstants {
    public static final int kDriverControllerPort = 0;
    public static final int kArmControllerPort = 1;

    public static final float robotSpeed = 100f; //cm/sec
    // public static final float dcFromReefToStartLine = 156f;
    public static final float dcFromReefToStartLine = 200f;

    public static final float dcFrom1To2 = 425f;

    public static final float dcFrom2To3 = 395f;



    // Make the timer static so it can be used globally
    public static final Timer timer = new Timer();

   
  }
}
