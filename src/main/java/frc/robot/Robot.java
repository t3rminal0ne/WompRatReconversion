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
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

import com.ctre.phoenix.motorcontrol.Faults;
/*import ctr-e libraries*/
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

import com.playingwithfusion.TimeOfFlight;
import com.playingwithfusion.TimeOfFlight.RangingMode;

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

   // Initializing FOUR MOTORS
  public WPI_TalonFX rightMain = new WPI_TalonFX(1);
  public WPI_TalonFX rightFollow = new WPI_TalonFX(2);
  public WPI_TalonFX leftMain = new WPI_TalonFX(3);
  public WPI_TalonFX leftFollow = new WPI_TalonFX(4);

  // Initializing DIFFERENTIAL DRIVE and JOYSTICKS
  public DifferentialDrive twoMotorDrive = new DifferentialDrive(rightMain, leftMain);

  public Joystick leftStick;
  public Joystick rightStick;

  // Initializing FAULTS:
  Faults faultsL = new Faults();
  Faults faultsR = new Faults();

  // Initializing OTHER MOTORS
  // PHASE 4
  // public WPI_TalonFX climberTalon = new WPI_TalonFX(11);
  // public WPI_TalonFX climberTalonFollow = new WPI_TalonFX(12);

   // Initializing a COMPRESSOR

  // Initializing a SOLENOID
  // PHASE 4
  // public Solenoid climberPiston = new Solenoid(0,0); // Sus line, this should initialize a solenoid with "Solenoid 0" channel like it says in labview

  // Initializing all of the JOYSTICK BUTTONS in a confusing manner until we learn how to 
  // do it in a non-confusing manner

  // PHASE 2
  // boolean leftTrigger = leftStick.getRawButton(0);
  // boolean leftThumbMain = leftStick.getRawButton(1);
  // boolean leftThumbLeft = leftStick.getRawButton(2);
  // boolean leftThumbRight = leftStick.getRawButton(3);
  // boolean leftRightArrayTR = leftStick.getRawButton(4);
  // boolean leftRightArrayTM = leftStick.getRawButton(5);
  // boolean leftRightArrayTL = leftStick.getRawButton(6);
  // boolean leftRightArrayBL = leftStick.getRawButton(7);
  // boolean leftRightArrayBM = leftStick.getRawButton(8);
  // boolean leftRightArrayBR = leftStick.getRawButton(9);
  // boolean leftLeftArrayTL = leftStick.getRawButton(10);
  // boolean leftLeftArrayTM = leftStick.getRawButton(11);
  // boolean leftLeftArrayTR = leftStick.getRawButton(12);
  // boolean leftLeftArrayBR = leftStick.getRawButton(13);
  // boolean leftLeftArrayBM = leftStick.getRawButton(14);
  // boolean leftLeftArrayBL = leftStick.getRawButton(15);

  // //Right joystick buttons:
  // boolean rightTrigger = rightStick.getRawButton(0);
  // boolean rightThumbMain = rightStick.getRawButton(1);
  // boolean rightThumbLeft = rightStick.getRawButton(2);
  // boolean rightThumbRight = rightStick.getRawButton(3);
  // boolean rightLeftArrayTL = rightStick.getRawButton(4);
  // boolean rightLeftArrayTM = rightStick.getRawButton(5);
  // boolean rightLeftArrayTR = rightStick.getRawButton(6);
  // boolean rightLeftArrayBR = rightStick.getRawButton(7);
  // boolean rightLeftArrayBM = rightStick.getRawButton(8);
  // boolean rightLeftArrayBL = rightStick.getRawButton(9);
  // boolean rightRightArrayTR = rightStick.getRawButton(10);
  // boolean rightRightArrayTM = rightStick.getRawButton(11);
  // boolean rightRightArrayTL = rightStick.getRawButton(12);
  // boolean rightRightArrayBL = rightStick.getRawButton(13);
  // boolean rightRightArrayBM = rightStick.getRawButton(14);
  // boolean rightRightArrayBR = rightStick.getRawButton(15);

  // Declaring GLOBAL VARS as each one comes into play
  // PHASE 3
  // boolean shooterSideIsForward = false;

  // Declaring TOGGLES
  // PHASE 4
  // boolean rightThumbMainToggle = false;

  // PHASE 5
  TimeOfFlight ToF1 = new TimeOfFlight(1);
  TimeOfFlight ToF2 = new TimeOfFlight(2);
  TimeOfFlight ToF3 = new TimeOfFlight(3);
  TimeOfFlight ToF4 = new TimeOfFlight(4);


  @Override
  public void teleopPeriodic() {
    twoMotorDrive.tankDrive(leftStick.getY(), rightStick.getY());

    // PHASE 2 CODE TO TEST:

    // if (rightRightArrayBM) {
    //   // (Limelight code)
    // } else {
    //   // (Network table stuff)

    //   if (leftThumbMain) {
    //     // Aim with limelight
    //   } else {
    //     // (Network table stuff)

    //     // this determines which way the robot is oriented
    //     if (shooterSideIsForward) {
    //       twoMotorDrive.tankDrive(rightStick.getY(), -leftStick.getY());
    //     } else {
    //       twoMotorDrive.tankDrive(-rightStick.getY(), leftStick.getY());
    //     }
    //   }
    // }

    // PHASE 3 CODE TO TEST:

    //   if (rightThumbLeft) {
    //     shooterSideIsForward = false;
    //   } else {
    //     if (rightThumbRight) {
    //       shooterSideIsForward = true;
    //     } else {

    //     }
    //   }
    // }

    // PHASE 4 CODE TO TEST:

    // if (rightThumbMain) {
    //   // Toggle functionality
    //   if (rightThumbMainToggle) {
    //       rightThumbMainToggle = false;
    //   } else {
    //       rightThumbMainToggle = true;
    //     }
    // }

    // if (rightThumbMainToggle) {
    //   climberPiston.set(true);
    // } else {
    //   climberPiston.set(false);
    // }

    // if (rightRightArrayTL) {
    //   climberTalon.set(.7);
    // } else {
    //   climberTalon.set(0);
    // }
  }
  
  @Override
  public void robotInit() {

    LiveWindow.disableAllTelemetry();

    // Factory default setup (whatever that is)
    rightMain.configFactoryDefault();
    rightFollow.configFactoryDefault();
    leftMain.configFactoryDefault();
    leftFollow.configFactoryDefault();

    // PHASE 4: Set up any inverted motors
    // climberTalonFollow.setInverted(true);

    // Set up followers
    rightFollow.follow(rightMain);
    leftFollow.follow(leftMain);

    // climberTalonFollow.follow(climberTalon);

    // Start the compressor

    /*
    NOTE:
    The code above is all of the necessary code needed to run a basic differential
    drive (plus a compressor).
    This next bit of code is all of the other stuff happening to the motors
    during Begin.vi. If the code does not work on Womp Rat, start by commenting out
    these lines
    */

    // Setting B/C mode (whatever that is)
    // rightMain.setNeutralMode(NeutralMode.Brake);
    // leftMain.setNeutralMode(NeutralMode.Brake);

    // // Setting the contorl mode to percent output
    // rightMain.set(ControlMode.PercentOutput, 0);
    // leftMain.set(ControlMode.PercentOutput, 0);

    // // Setting dead band (whatever that is)
    // rightMain.configNeutralDeadband(.1);
    // leftMain.configNeutralDeadband(.1);

    // // Setting sensor position
    // rightMain.setSelectedSensorPosition(0);
    // leftMain.setSelectedSensorPosition(0);

    // I have no clue how to setup the pidf like it says in labview

    // CLIMBER TALON SETUP
    // PHASE 4
    // climberTalon.enableVoltageCompensation(true);
    // climberTalon.configVoltageCompSaturation(12);

    // PHASE 5
    // Time of flight setup
    Tof1.setRangingMode

  }
}