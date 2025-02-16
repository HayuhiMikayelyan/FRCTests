package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkLowLevel.MotorType;

public class ArmUDSubsystem extends SubsystemBase {
    private final SparkMax upAndDownMotor = new SparkMax(9, MotorType.kBrushed);

    public ArmUDSubsystem() {
   }

    public void setUDSpeed(double speed) {
        upAndDownMotor.set(speed);
    }
}