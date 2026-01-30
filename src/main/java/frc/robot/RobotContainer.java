// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import frc.robot.Constants.Controle;
// import frc.robot.commands.ElevatorMove;
// import frc.robot.subsystems.ColetorAlga;
// import frc.robot.subsystems.ColetorAlga;
// import frc.robot.subsystems.Elevator;
// import frc.robot.subsystems.ShooterCoral;
import frc.robot.subsystems.SwerveSubsystem;
import swervelib.SwerveInputStream;

import java.io.File;

import com.pathplanner.lib.auto.AutoBuilder;
import com.pathplanner.lib.auto.NamedCommands;

import edu.wpi.first.math.MathUtil;
import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Filesystem;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.PrintCommand;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;

public class RobotContainer {
    // Aqui iniciamos o swerve

    // Criar os subsystems

//     public final Elevator ElevatorSubsystem = new Elevator();

//     public final ColetorAlga ColetorSybsystem = new ColetorAlga();

//     public final ShooterCoral ShooterSubsystem = new ShooterCoral();

    private SwerveSubsystem swerve = new SwerveSubsystem(new File(Filesystem.getDeployDirectory(), "swerve"));

    // É criado o escolhedor de autônomo
    private final SendableChooser<Command> autoChooser;

    // Controle de Xbox, troque para o qual sua equipe estará utilizando

    private CommandXboxController xboxMovimentacao = new CommandXboxController(Controle.xboxControle);

    private CommandXboxController xboxSubSystems = new CommandXboxController(Controle.xboxAlga);

    SwerveInputStream driveAngularVelocity = SwerveInputStream.of(swerve.getSwerveDrive(),
            () -> xboxMovimentacao.getLeftY() * 1,
            () -> xboxMovimentacao.getLeftX() * 1)
            .withControllerRotationAxis(() -> xboxMovimentacao.getRightX() * -1)
            .deadband(Constants.Controle.DEADBAND)
            .scaleTranslation(0.8)
            .allianceRelativeControl(true);

    // SwerveInputStream driveDirectAngle = driveAngularVelocity.copy()
    // .withControllerHeadingAxis(() -> xboxMovimentacao.getRightX() * 1,
    // () -> xboxMovimentacao.getRightY() * -1)
    // .headingWhile(true);

    public RobotContainer() {

        // NamedCommands.registerCommand("Intake", new PrintCommand("Intake"));

        autoChooser = AutoBuilder.buildAutoChooser();
        SmartDashboard.putData("Auto Chooser", autoChooser);

        // Configure the trigger bindings
        configureBindings();
    }

    // Função onde os eventos (triggers) são configurados
    private void configureBindings() {

        Command driveFieldOrientedAngularVelocity = swerve.driveFieldOriented(driveAngularVelocity);
        swerve.setDefaultCommand(driveFieldOrientedAngularVelocity);

        xboxMovimentacao.a().onTrue(Commands.runOnce(swerve::zeroGyro, swerve));

        // xboxMovimentacao.rightBumper().whileTrue(swerve.alignInDegress(
        // () -> MathUtil.applyDeadband(xboxMovimentacao.getLeftY(),
        // Constants.Controle.DEADBAND),
        // () -> MathUtil.applyDeadband(xboxMovimentacao.getLeftX(),
        // Constants.Controle.DEADBAND),
        // 45));

        // xboxMovimentacao.leftBumper().whileTrue(swerve.alignInDegress(
        // () -> MathUtil.applyDeadband(xboxMovimentacao.getLeftY(),
        // Constants.Controle.DEADBAND),
        // () -> MathUtil.applyDeadband(xboxMovimentacao.getLeftX(),
        // Constants.Controle.DEADBAND),
        // -45));

        // if (!Robot.isReal()) {
        // xboxMovimentacao.start()
        // .onTrue(Commands.runOnce(() -> swerve.resetOdometry(new Pose2d(3, 3, new
        // Rotation2d()))));
        // }

        /*---------- PARTE DO COLETOR DA ALGA ----------*/

        // AJUSTAR ALTURA DO COLETOR DA ALGA

        // xboxSubSystems.y().whileTrue((ColetorSybsystem.runAlturaAlga(-1)))
        //         .onFalse(ColetorSybsystem.stopAlturaAlga());

        // xboxSubSystems.a().whileTrue((ColetorSybsystem.runAlturaAlga(1)))
        //         .onFalse(ColetorSybsystem.stopAlturaAlga());

        // COLETAR OU EJETAR ALGA

        // xboxSubSystems.b().whileTrue((ColetorSybsystem.runColetarAlga(0.8)))
        //         .onFalse(ColetorSybsystem.stopColetarAlga());

        // xboxSubSystems.x().whileTrue((ColetorSybsystem.runColetarAlga(-.8)))
        //         .onFalse(ColetorSybsystem.stopColetarAlga());

        /*---------- PARTE DO Shooter DO CORAL ----------*/

        // xboxSubSystems.rightTrigger().whileTrue((ShooterSubsystem.runShooterHorario(-.7))) // LIGAR O Shooter NA
        //                                                                                    // VELOCIDADE ALTA
        //         .onFalse(ShooterSubsystem.stopShooterHorario());

        // xboxSubSystems.rightBumper().whileTrue((ShooterSubsystem.runShooterHorario(-.3))) // LIGAR O Shooter NA
        //                                                                                   // VELOCIDADE BAIXA
        //         .whileFalse(ShooterSubsystem.stopShooterHorario());

        // xboxSubSystems.leftBumper().whileTrue((ShooterSubsystem.runShooterHorario(.3))) // LIGAR Os Shooters AO
        //                                                                                 // CONTRÁRIO
        //         .whileFalse(ShooterSubsystem.stopShooterHorario());

        /*---------- PARTE DO ELEVADOR ----------*/

        // MOVER MANUALMENTE

        // xboxSubSystems.povUp().whileTrue(new ElevatorMove(ElevatorSubsystem, 10))
        // .whileFalse(Commands.runOnce(() -> ElevatorSubsystem.setSpeed(0),
        // ElevatorSubsystem));
        // xboxSubSystems.povDown().whileTrue(new ElevatorMove(ElevatorSubsystem, -0.2))
        // .whileFalse(Commands.runOnce(() -> ElevatorSubsystem.setSpeed(0),
        // ElevatorSubsystem));

        // xboxSubSystems.start().onTrue(Commands.runOnce(() -> ElevatorSubsystem.setZero(), ElevatorSubsystem)); // definir 0

        // // SETPOINS DO ELEVADOR

        // xboxSubSystems.povUp().onTrue(new ElevatorMove(ElevatorSubsystem, 25));

        // xboxSubSystems.povLeft().onTrue(new ElevatorMove(ElevatorSubsystem, 50));

        // xboxSubSystems.povDown().onTrue(new ElevatorMove(ElevatorSubsystem, 75));

        // xboxSubSystems.povRight().onTrue(new ElevatorMove(ElevatorSubsystem, 100));
 
        // xboxSubSystems.back().onTrue(new ElevatorMove(ElevatorSubsystem, 2));
    }

    // Função que retorna o autônomo
    public Command getAutonomousCommand() {
        // Aqui retornamos o comando que está no selecionador
        return autoChooser.getSelected();
    }

    // Define os motores como coast ou brake
    public void setMotorBrake(boolean brake) {
        swerve.setMotorBrake(brake);
    }

    public void setHeadingCorrection(boolean heading) {
        swerve.setHeadingCorrection(heading);
    }
}
