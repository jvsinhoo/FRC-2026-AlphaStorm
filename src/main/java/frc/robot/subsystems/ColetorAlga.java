// package frc.robot.subsystems;

// import com.revrobotics.spark.SparkLowLevel.MotorType;

// import java.util.logging.Level;

// import com.revrobotics.spark.SparkMax;

// import edu.wpi.first.math.controller.ElevatorFeedforward;
// import edu.wpi.first.math.controller.ProfiledPIDController;
// import edu.wpi.first.math.trajectory.TrapezoidProfile;
// import edu.wpi.first.wpilibj.Encoder;
// import edu.wpi.first.wpilibj.Joystick;
// import edu.wpi.first.wpilibj.TimedRobot;
// import edu.wpi.first.wpilibj.motorcontrol.PWMSparkMax;
// import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
// import edu.wpi.first.wpilibj2.command.Command;
// import edu.wpi.first.wpilibj2.command.Commands;
// import edu.wpi.first.wpilibj2.command.SubsystemBase;


// import com.revrobotics.spark.SparkLowLevel.MotorType;
// import com.revrobotics.spark.SparkMax;

// import edu.wpi.first.wpilibj.XboxController;
// import edu.wpi.first.wpilibj2.command.SubsystemBase;

// import com.revrobotics.RelativeEncoder;
// import com.revrobotics.spark.SparkFlex;


// public class ColetorAlga extends SubsystemBase {

   
//     private final SparkMax AlturaColetor = new SparkMax(10, MotorType.kBrushed);
//     private final SparkMax ColetarAlga = new SparkMax(9, MotorType.kBrushed);
//     private final RelativeEncoder EncoderColetorAlga;
        
    


// public ColetorAlga() {

//     EncoderColetorAlga = AlturaColetor.getEncoder();

// }

// public double getEncoderAlga() {
//     return EncoderColetorAlga.getPosition();
// }


// public void setZero() {
//     EncoderColetorAlga.setPosition(0);
// }

// @Override
// public void periodic() {

//     SmartDashboard.putNumber("Encoder Elevator Get", getEncoderAlga());


// }

// //SUBIR OU DESCER COLETOR DA ALGA

// public void setAlturaAlga(double speed) {
//     AlturaColetor.set(speed);
// }

// public Command runAlturaAlga(double speed) {
//     return Commands.runOnce(() -> setAlturaAlga(speed));
// }

// public Command stopAlturaAlga() {
//     return Commands.runOnce(() -> AlturaColetor.stopMotor());
// }


// //COLETAR ALGA

// public void setColetarAlga(double speed) {
//     ColetarAlga.set(speed);
// }

// public Command runColetarAlga(double speed) {
//     return Commands.runOnce(() -> setColetarAlga(speed));
// }

// public Command stopColetarAlga() {
//     return Commands.runOnce(() -> ColetarAlga.stopMotor());
// }

//  }



