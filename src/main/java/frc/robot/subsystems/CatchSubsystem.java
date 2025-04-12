package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkLowLevel.MotorType;
/*its "թաթիկ" or juts paw*/
public class CatchSubsystem extends SubsystemBase {
    private final SparkMax catchMotor = new SparkMax(7, MotorType.kBrushed);
    private final DigitalInput limitOpenSwitch = new DigitalInput(2); // Change 0 to the correct port
    
    public CatchSubsystem() {
    }

    public boolean isAtOpenLimit() {
        return !limitOpenSwitch.get();
    }

    public void setCatchSpeed(double speed) {
        catchMotor.set(speed);
    }
}