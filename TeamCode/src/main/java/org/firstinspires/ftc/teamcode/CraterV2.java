package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;
@Autonomous (name = "CraterV2")
@Disabled
public class CraterV2 extends LinearOpMode {
    private DcMotor leftbackMotor, rightbackMotor, leftfrontMotor, rightfrontMotor, liftMotor;
    private Servo cowplowleftServo, cowplowrightServo;

    @Override
    public void runOpMode() throws InterruptedException {
        leftbackMotor = hardwareMap.dcMotor.get("leftbackMotor");
        rightbackMotor = hardwareMap.dcMotor.get("rightbackMotor");
        leftfrontMotor = hardwareMap.dcMotor.get("leftfrontMotor");
        rightfrontMotor = hardwareMap.dcMotor.get("rightfrontMotor");

        liftMotor = hardwareMap.dcMotor.get("liftMotor");

        cowplowleftServo = hardwareMap.servo.get("cowplowleftServo");
        cowplowrightServo = hardwareMap.servo.get("cowplowrightServo");

        rightbackMotor.setDirection(DcMotorSimple.Direction.REVERSE);
        leftbackMotor.setDirection(DcMotorSimple.Direction.REVERSE);
        liftMotor.setDirection(DcMotorSimple.Direction.REVERSE);

        leftbackMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        rightbackMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        liftMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        while (liftMotor.getCurrentPosition() != 0) {
            idle();
        }

        //Declaring Variables and Setting Up Encoders

        leftbackMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        rightbackMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        liftMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        leftfrontMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        rightfrontMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);


        telemetry.addData("Mode", "waiting");
        telemetry.update();

        leftfrontMotor.setDirection(DcMotorSimple.Direction.REVERSE);
        rightbackMotor.setDirection(DcMotorSimple.Direction.REVERSE);


        //Autonomous

        waitForStart();

        liftMotor.setTargetPosition(-5800);
        liftMotor.setPower(.5);
        while (opModeIsActive() && liftMotor.isBusy()) {
            idle();
        }
        liftMotor.setPower(0);


        leftbackMotor.setTargetPosition(5);
        rightbackMotor.setTargetPosition(5);

        leftbackMotor.setPower(.5);
        rightbackMotor.setPower(-.5);//reversed but weird
        leftfrontMotor.setPower(.5);
        rightfrontMotor.setPower(.5);

        while (opModeIsActive() && leftbackMotor.isBusy()) {
            idle();
        }
        leftbackMotor.setPower(0);
        leftfrontMotor.setPower(0);
        rightbackMotor.setPower(0);
        rightfrontMotor.setPower(0);// emily is the greatest human





        leftbackMotor.setTargetPosition(50);
        rightbackMotor.setTargetPosition(50);

        leftbackMotor.setPower(.5);
        rightbackMotor.setPower(.5);//reversed but weird
        leftfrontMotor.setPower(-.5);
        rightfrontMotor.setPower(.5);

        while (opModeIsActive() && leftbackMotor.isBusy()) {
            idle();
        }
        leftbackMotor.setPower(0);
        leftfrontMotor.setPower(0);
        rightbackMotor.setPower(0);
        rightfrontMotor.setPower(0);



        //Back To Crater
        leftbackMotor.setTargetPosition(-2570);
        rightbackMotor.setTargetPosition(2570);

        leftbackMotor.setPower(-1);
        rightbackMotor.setPower(1);
        leftfrontMotor.setPower(-1);
        rightfrontMotor.setPower(-1);

        while (opModeIsActive() && leftbackMotor.isBusy()) {
            idle();
        }
        }


    }

