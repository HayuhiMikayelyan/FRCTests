package frc.robot.subsystems;

import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkLowLevel.MotorType;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class RollerSubsystem extends SubsystemBase {
    private final SparkMax rollerMotor = new SparkMax(5, MotorType.kBrushed);
    private final DigitalInput limitSwitch = new DigitalInput(0); // Change 0 to the correct port


    public RollerSubsystem() {}
    
    public void setRollerSpeed(double speed) {
        rollerMotor.set(speed);
    }

    public boolean isAtLimit() {
        return !limitSwitch.get(); // Returns true when switch is pressed
    }
}
