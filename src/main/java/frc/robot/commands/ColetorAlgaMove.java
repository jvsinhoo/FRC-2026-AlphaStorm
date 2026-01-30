// package frc.robot.commands;

// import edu.wpi.first.math.MathUtil;
// import edu.wpi.first.math.controller.PIDController;
// import edu.wpi.first.wpilibj2.command.Command;
// import frc.robot.subsystems.ColetorAlga;

// public class ColetorAlgaMove extends Command {
//     private final ColetorAlga coletorAlga;
//     private final double setpoint;
//     private final PIDController pid = new PIDController(0.5, 0.0, 0.0);

//     private static final double ALTURA_MAXIMA = 100;   // Defina um valor apropriado
//     private static final double ALTURA_MINIMA  = 100;  // Posição mais baixa permitida

//     public ColetorAlgaMove(ColetorAlga coletorAlga, double setpoint) {
//         this.coletorAlga = coletorAlga;

//         // Garante que o setpoint esteja dentro dos limites permitidos
//         this.setpoint = MathUtil.clamp(setpoint, ALTURA_MINIMA, ALTURA_MAXIMA);

//         pid.setTolerance(5); // Reduzi a tolerância para mais precisão
//     }

//     @Override
//     public void execute() {
//         double output = pid.calculate(coletorAlga.getEncoderAlga(), setpoint);
//         output = MathUtil.clamp(output, -0.3, 0.3); // Ajuste fino na velocidade

//         coletorAlga.setAlturaAlga(output);
//     }

//     @Override
//     public void end(boolean interrupted) {
//         coletorAlga.setAlturaAlga(0); // Para o motor ao finalizar o comando
//     }

//     @Override
//     public boolean isFinished() {
//         return pid.atSetpoint();
//     }
// }
