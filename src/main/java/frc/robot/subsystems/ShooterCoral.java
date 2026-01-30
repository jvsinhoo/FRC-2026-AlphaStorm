package frc.robot.subsystems;

import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.config.SparkMaxConfig;
import com.revrobotics.spark.SparkBase.ResetMode;
import com.revrobotics.spark.SparkBase.PersistMode;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;

public class ShooterCoral extends SubsystemBase {

    private final SparkMax ShooterHorario = new SparkMax(14, MotorType.kBrushless);
    private final SparkMax ShooterAntiHorario = new SparkMax(15, MotorType.kBrushless);

    public ShooterCoral() {
        // Configuração do motor seguidor
        SparkMaxConfig config = new SparkMaxConfig();
        config.follow(14, true); // O motor 15 seguirá o motor 14 com inversão de direção
        ShooterAntiHorario.configure(config, ResetMode.kResetSafeParameters, PersistMode.kNoPersistParameters);
    }

    // CONFIGURAR O SHUTTER PARA RODAR NO SENTIDO HORÁRIO

    public void setShooterHorario(double speed) {
        ShooterHorario.set(speed);
    }
    
    public Command runShooterHorario(double speed) {
        return Commands.runOnce(() -> setShooterHorario(speed));
    }
    
    public Command stopShooterHorario() {
        return Commands.runOnce(() -> ShooterHorario.stopMotor());
    }
    
    
    //CONFIGURAR O SHUTTER PARA RODAR NO SENTIDO Anti HORÁRIO
    
    public void setShooterAntiHorario(double speed) {
        ShooterAntiHorario.set(speed);
    }
    
    public Command runShooterAntiHorario(double speed) {
        return Commands.runOnce(() -> runShooterAntiHorario(speed));
    }
    
    public Command stopShooterAntiHorario() {
        return Commands.runOnce(() -> ShooterAntiHorario.stopMotor());
    }
    
}
