// // package frc.robot.commands;

// // import edu.wpi.first.math.MathUtil;
// // import edu.wpi.first.math.controller.PIDController;
// // import edu.wpi.first.wpilibj2.command.Command;
// // import frc.robot.subsystems.Elevator;

// // public class ElevatorMove extends Command {
// //     Elevator elevator;
// //     double setpoint;
// //     PIDController pid = new PIDController(0.5, 0.0, 0.0);

// //     public ElevatorMove(Elevator elevator, double setpoint) {
// //         this.elevator = elevator;
// //         this.setpoint = setpoint;

// //         pid.setTolerance(30);
// //     }

// //     @Override
// //     public void execute() {
// //         double output = pid.calculate(elevator.getEncoder(), setpoint);
// //         output = MathUtil.clamp(output, -.1, .1); 

// //         elevator.setSpeed(output);

// //         // elevator.setSpeed(setpoint);
// //     }

// //     @Override
// //     public void end(boolean interrupted) {
// //         elevator.setSpeed(0);
// //     }

// //     @Override
// //     public boolean isFinished() {
// //         return pid.atSetpoint();
// //     }
// // }


// package frc.robot.commands;

// import edu.wpi.first.math.MathUtil;
// import edu.wpi.first.math.controller.PIDController;
// import edu.wpi.first.wpilibj2.command.Command;
// import frc.robot.subsystems.Elevator;

// public class ElevatorMove extends Command {
//     Elevator elevator;
//     double setpoint;
//     PIDController pid = new PIDController(0.2, 0.0, 0.0);

//     public ElevatorMove(Elevator elevator, double setpoint) {
//         this.elevator = elevator;
//         this.setpoint = setpoint;

//         // pid.setTolerance(2);
//     }

//     @Override
//     public void execute() {
//         double output = pid.calculate(elevator.getEncoder(), setpoint);
//         output = MathUtil.clamp(output, -0.3, 0.3); 

//         elevator.setSpeed(output);
//     }

//     @Override
//     public void end(boolean interrupted) {
//         elevator.setSpeed(0);
//     }

//     @Override
//     public boolean isFinished() {
//         return pid.atSetpoint();
//     }
// }
