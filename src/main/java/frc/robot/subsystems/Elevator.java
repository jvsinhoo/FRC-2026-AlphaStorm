// package frc.robot.subsystems;

// import java.io.ObjectInputFilter.Config;

// import com.revrobotics.RelativeEncoder;
// import com.revrobotics.servohub.ServoHub.ResetMode;
// import com.revrobotics.spark.SparkFlex;
// import com.revrobotics.spark.SparkBase.PersistMode;
// import com.revrobotics.spark.SparkLowLevel.MotorType;
// import com.revrobotics.spark.config.SparkFlexConfig;
// import com.revrobotics.spark.config.SparkBaseConfig.IdleMode;

// import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
// import edu.wpi.first.wpilibj2.command.SubsystemBase;

// public class Elevator extends SubsystemBase {
//     SparkFlex elevatorRight, elevatorLeft;
//     RelativeEncoder encoderElevador, encoderElevatorLeft;
//     SparkFlexConfig elevatorRightConfig, elevatorLeftConfig, configElevator;

//     public Elevator() {
//         elevatorRight = new SparkFlex(11, MotorType.kBrushless);
//         elevatorLeft = new SparkFlex(12, MotorType.kBrushless);
//         configElevator = new SparkFlexConfig();

//         // configElevator.follow(12, true);

//         elevatorRightConfig = new SparkFlexConfig();
//         elevatorRightConfig.idleMode(IdleMode.kBrake);
//         elevatorRightConfig.inverted(false);

//         elevatorLeftConfig = new SparkFlexConfig();
//         elevatorLeftConfig.idleMode(IdleMode.kBrake);
//         elevatorLeftConfig.inverted(true);

//         encoderElevador = elevatorRight.getEncoder();
//         encoderElevatorLeft = elevatorLeft.getEncoder();
//     }

//     public double getEncoder() {
//         return encoderElevador.getPosition();
//     }

//     public double getEncoderLeft() {
//         return encoderElevatorLeft.getPosition();
//     }

//     public void setSpeed(double speed) {
//         elevatorRight.set(speed);
//         elevatorLeft.set(-speed);
//     }

//     public void setZero() {
//         encoderElevador.setPosition(0);
//         encoderElevatorLeft.setPosition(0);
//     }

//     @Override
//     public void periodic() {
//         SmartDashboard.putNumber("Encoder Right", getEncoder());
//         SmartDashboard.putNumber("Encoder Left", getEncoderLeft());
//     }
// }

// // CODIGO TESTEEEEEEEEEEEEEEEE

// // package frc.robot.subsystems;

// // import com.revrobotics.spark.SparkMax;
// // import com.revrobotics.spark.SparkLowLevel.MotorType;
// // import com.revrobotics.spark.config.SparkMaxConfig;
// // import com.revrobotics.spark.config.SparkBaseConfig.IdleMode;

// // import edu.wpi.first.wpilibj.Encoder;
// // import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
// // import edu.wpi.first.wpilibj2.command.SubsystemBase;

// // public class Elevator extends SubsystemBase {
// // private final SparkMax elevatorRight, elevatorLeft;
// // private final SparkMaxConfig elevatorRightConfig, elevatorLeftConfig;
// // private final Encoder encoderElevator;

// // public Elevator() {
// // // Motores CIM controlados por Spark MAX
// // elevatorRight = new SparkMax(11, MotorType.kBrushed);
// // elevatorRightConfig = new SparkMaxConfig();
// // elevatorRightConfig.idleMode(IdleMode.kBrake);
// // elevatorRightConfig.inverted(false);

// // // elevatorRight.apply(elevatorRightConfig); // Aplicando a configuração

// // elevatorLeft = new SparkMax(12, MotorType.kBrushed);
// // elevatorLeftConfig = new SparkMaxConfig();
// // elevatorLeftConfig.idleMode(IdleMode.kBrake);
// // elevatorLeftConfig.inverted(false);

// // // elevatorLeft.apply(elevatorLeftConfig); // Aplicando a configuração

// // // Encoder Through Bore conectado às portas DIO 0 e 1
// // encoderElevator = new Encoder(0, 1);
// // }

// // public double getEncoder() {
// // return encoderElevator.get(); // Retorna a posição do encoder
// // }

// // public void setSpeed(double speed) {
// // elevatorRight.set(speed);
// // elevatorLeft.set(speed); // Ambos os motores recebem a mesma velocidade
// // }

// // public void setZero() {
// // encoderElevator.reset(); // Reset correto para encoder de quadratura
// // }

// // @Override
// // public void periodic() {
// // SmartDashboard.putNumber("Encoder Elevator Get", getEncoder());
// // }
// // }
