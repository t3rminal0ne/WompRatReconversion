/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.DoubleSolenoid;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;
/*import ctr-e libraries*/
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {
  /**
   * This function is run when the robot is first started up and should be used
   * for any initialization code.
   */

  // Initializing DIFFERENTIAL DRIVE and JOYSTICKS
  public DifferentialDrive twoMotorDrive;
  public Joystick leftStick;
  public Joystick rightStick;

  // Initializing FOUR MOTORS
  public WPI_TalonFX rightMain = new WPI_TalonFX(1);
  public WPI_TalonFX rightFollow = new WPI_TalonFX(2);
  public WPI_TalonFX leftMain = new WPI_TalonFX(3);
  public WPI_TalonFX leftFollow = new WPI_TalonFX(4);

   // Initializing a COMPRESSOR
  Compressor compressor = new Compressor(0);


  @Override
  public void robotInit() {
    // Setting up twoMotorDrive
    twoMotorDrive = new DifferentialDrive(rightMain, leftMain);

    // Factory default setup (whatever that is)
    rightMain.configFactoryDefault();
    rightFollow.configFactoryDefault();
    leftMain.configFactoryDefault();
    leftFollow.configFactoryDefault();

    // Set up followers
    rightFollow.follow(rightMain);
    leftFollow.follow(leftMain);

    // Start the compressor
    compressor.start();

    /*
    NOTE:
    The code above is all of the necessary code needed to run a basic differential
    drive (plus a compressor).
    This next bit of code is all of the other stuff happening to the motors
    during Begin.vi. If the code does not work on Womp Rat, start by commenting out
    these lines
    */

    // Setting B/C mode (whatever that is)
    rightMain.setNeutralMode(NeutralMode.Brake);
    leftMain.setNeutralMode(NeutralMode.Brake);

    // Setting the contorl mode to percent output
    rightMain.set(ControlMode.PercentOutput, 0);
    leftMain.set(ControlMode.PercentOutput, 0);

    // Setting dead band (whatever that is)
    rightMain.configNeutralDeadband(.1);
    leftMain.configNeutralDeadband(.1);

    // Setting sensor position
    rightMain.setSelectedSensorPosition(0);
    leftMain.setSelectedSensorPosition(0);

    // I have no clue how to setup the pidf like it says in labview

  }

  @Override
  public void autonomousInit() {
  }

  @Override
  public void autonomousPeriodic() {
  }

  @Override
  public void teleopInit() {
  }

  @Override
  public void teleopPeriodic() {
    twoMotorDrive.tankDrive(leftStick.getY(), rightStick.getY());
  }

  @Override
  public void testInit() {
  }

  @Override
  public void testPeriodic() {
  }

}
