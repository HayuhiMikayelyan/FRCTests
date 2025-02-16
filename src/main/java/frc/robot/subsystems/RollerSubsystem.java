package frc.robot.subsystems;

import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkLowLevel.MotorType;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class RollerSubsystem extends SubsystemBase {
    private final SparkMax rollerMotor = new SparkMax(5, MotorType.kBrushed);
    
    public RollerSubsystem() {}
    
    public void setRollerSpeed(double speed) {
        rollerMotor.set(speed);
    }
}
