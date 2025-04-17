package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.config.ClosedLoopConfig.FeedbackSensor;
import com.revrobotics.spark.config.SparkMaxConfig;
import com.revrobotics.spark.SparkBase.ControlType;
import com.revrobotics.spark.SparkBase.PersistMode;
import com.revrobotics.spark.SparkBase.ResetMode;
import com.revrobotics.spark.SparkClosedLoopController;
import com.revrobotics.spark.SparkLowLevel.MotorType;

/*for wrist "Dastak" =) */
public class ArmUDSubsystem extends SubsystemBase {
    private final SparkMax upAndDownMotor = new SparkMax(9, MotorType.kBrushless);
    private final DigitalInput limitLowSwitch = new DigitalInput(3); // Change 0 to the correct port

    SparkClosedLoopController pidController = upAndDownMotor.getClosedLoopController();

    public ArmUDSubsystem() {
        SparkMaxConfig config = new SparkMaxConfig();
        config.inverted(false) // Set according to your setup
                .idleMode(SparkMaxConfig.IdleMode.kBrake).encoder
                .positionConversionFactor(1.0) // Adjust as needed
                .velocityConversionFactor(1.0); // Adjust as needed
        config.closedLoop
                .feedbackSensor(FeedbackSensor.kPrimaryEncoder)
                .pid(0.07, 0.0, 0.005); // Initial PID values; tune as necessary

        // Apply the configuration to the motor
        upAndDownMotor.configure(config, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);

        // Retrieve the PID controller after configuration
        pidController = upAndDownMotor.getClosedLoopController();

    }

    // public void moveToPosition(double targetRotations, boolean isUp) {
    //     if (isUp && isAtHighLimit() || !isUp && isAtLowLimit()) {
    //         setUDSpeed(targetRotations);
    //     }else {
    //         pidController.setReference(targetRotations, ControlType.kPosition);
    //     }
    // }



    public boolean isAtLowLimit() {
        return !limitLowSwitch.get();
    }

    public void setUDSpeed(double speed) {
        upAndDownMotor.set(speed);
    }
}

/*
 * And ofc cat ears
 * ^-^
 */