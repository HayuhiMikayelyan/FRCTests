package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkLowLevel.MotorType;

public class CatchSubsystem extends SubsystemBase {
    private final SparkMax catchMotor = new SparkMax(7, MotorType.kBrushed);

    public CatchSubsystem() {
   }

    public void setCatchSpeed(double speed) {
        catchMotor.set(speed);
    }
}