package frc.robot;

import edu.wpi.first.wpilibj.Timer;
/*idk whats the purpose of this file tbh*/


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

    // Make the timer static so it can be used globally
    public static final Timer timer = new Timer();

    public static boolean isButtonPressedLevel_0 = false;
   
  }
}
