package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkLowLevel.MotorType;
/*for wrist "Dastak" =) */
public class ArmUDSubsystem extends SubsystemBase {
    private final SparkMax upAndDownMotor = new SparkMax(9, MotorType.kBrushed);
    private final DigitalInput limitLowSwitch = new DigitalInput(3); // Change 0 to the correct port

    public ArmUDSubsystem() {
    }

    public boolean isAtLowLimit() {
        return !limitLowSwitch.get();
    }

    public void setUDSpeed(double speed) {
        upAndDownMotor.set(speed);
    }
}

/*And ofc cat ears
 *     ^-^
 */