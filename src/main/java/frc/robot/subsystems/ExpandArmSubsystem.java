package frc.robot.subsystems;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkLowLevel.MotorType;
/*just salyaska */
public class ExpandArmSubsystem extends SubsystemBase {
    private final SparkMax expandMotor = new SparkMax(8, MotorType.kBrushed);

    public ExpandArmSubsystem() {

   }

    public void setExpandSpeed(double speed) {
        expandMotor.set(speed);
    }
}
