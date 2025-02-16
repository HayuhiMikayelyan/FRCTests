package frc.robot.subsystems;

import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkLowLevel.MotorType;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class HangSubsystem extends SubsystemBase {
    private final SparkMax hangMotor = new SparkMax(3, MotorType.kBrushed);
    
    public HangSubsystem() {}
    
    public void setHangSpeed(double speed) {
        hangMotor.set(speed);
    }
}
