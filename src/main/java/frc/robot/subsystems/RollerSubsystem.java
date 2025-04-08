package frc.robot.subsystems;

import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.config.ClosedLoopConfig.FeedbackSensor;
import com.revrobotics.spark.config.SparkBaseConfig.IdleMode;
import com.revrobotics.spark.config.SparkMaxConfig;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.spark.SparkBase.ControlType;
import com.revrobotics.spark.SparkBase.PersistMode;
import com.revrobotics.spark.SparkBase.ResetMode;
import com.revrobotics.spark.SparkClosedLoopController;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class RollerSubsystem extends SubsystemBase {
    private final SparkMax rollerMotor = new SparkMax(5, MotorType.kBrushless);
    private final RelativeEncoder encoder = rollerMotor.getEncoder();

    SparkClosedLoopController pidController = rollerMotor.getClosedLoopController();

    private final DigitalInput limitLowSwitch = new DigitalInput(0); // Change 0 to the correct port
    private final DigitalInput limitHighSwitch = new DigitalInput(1); // Change 0 to the correct port

    public int level_0 = 0;
    public int level_1 = 20;
    public int level_2 = 60;
    public int level_3 = 100;
    public int level_4 = 140;

    public RollerSubsystem() {
        SparkMaxConfig config = new SparkMaxConfig();
        config.inverted(false) // Set according to your setup
                .idleMode(SparkMaxConfig.IdleMode.kBrake).encoder
                .positionConversionFactor(1.0) // Adjust as needed
                .velocityConversionFactor(1.0); // Adjust as needed
        config.closedLoop
                .feedbackSensor(FeedbackSensor.kPrimaryEncoder)
                .pid(0.07, 0.0, 0.005); // Initial PID values; tune as necessary

        // Apply the configuration to the motor
        rollerMotor.configure(config, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);

        // Retrieve the PID controller after configuration
        pidController = rollerMotor.getClosedLoopController();

        encoder.setPosition(0);
    }

    public void moveToPosition(double targetRotations, boolean isUp) {
        if (isUp && isAtHighLimit() || !isUp && isAtLowLimit()) {
            setRollerSpeed(0);
        }else {
            pidController.setReference(targetRotations, ControlType.kPosition);
        }
    }

    public void setRollerSpeed(double speed) {
        rollerMotor.set(speed);
    }

    public void setRollerPositiveSpeed(double speed) {
        if (isAtHighLimit()) {
            setRollerSpeed(0);
        } else {
            setRollerSpeed(speed);
        }
    }

    public void setRollerNegativeSpeed(double speed) {
        if (isAtLowLimit()) {
            setRollerSpeed(0);
        } else {
            setRollerSpeed(speed);
        }
    }

    public boolean isAtLowLimit() {
        return !limitLowSwitch.get();
    }

    public boolean isAtHighLimit() {
        return !limitHighSwitch.get();
    }

    public double getRotations() {
        return encoder.getPosition(); // Returns rotations
    }

    public void resetEncoder() {
        encoder.setPosition(0);
    }

    public void stop() {
        rollerMotor.set(0);
    }

}
