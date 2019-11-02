package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

@Autonomous (name = "goldfish program")
@Disabled
public class goldfish_program extends LinearOpMode {
    private DcMotor leftbackMotor, rightbackMotor, leftfrontMotor, rightfrontMotor, liftMotor;
    private Servo cowplowleftServo, cowplowrightServo;
    private HardwareMap hardwareMap;

    @Override
    public void runOpMode() throws InterruptedException {
        leftbackMotor = hardwareMap.dcMotor.get("leftrear");
        rightbackMotor = hardwareMap.dcMotor.get("rightrear");
        leftfrontMotor = hardwareMap.dcMotor.get("leftfront");
        rightfrontMotor = hardwareMap.dcMotor.get("rightfront");

        liftMotor = hardwareMap.dcMotor.get("liftMotor");

        cowplowleftServo = hardwareMap.servo.get("cowplowleftServo");
        cowplowrightServo = hardwareMap.servo.get("cowplowrightServo");

        rightbackMotor.setDirection(DcMotorSimple.Direction.REVERSE);
        leftbackMotor.setDirection(DcMotorSimple.Direction.REVERSE);
        liftMotor.setDirection(DcMotorSimple.Direction.REVERSE);

        leftbackMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        rightbackMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        liftMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        //Declaring Variables and Setting Up Encoders

//        leftrear.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        rightbackMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        liftMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        leftfrontMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        rightfrontMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        telemetry.addData("Mode", "waiting");
        telemetry.update();

        leftfrontMotor.setDirection(DcMotorSimple.Direction.REVERSE);
        rightbackMotor.setDirection(DcMotorSimple.Direction.REVERSE);

        waitForStart();

        leftbackMotor.setTargetPosition(1440);
        rightbackMotor.setTargetPosition(-1440);

        leftbackMotor.setPower(1);
        rightbackMotor.setPower(-1);
        leftfrontMotor.setPower(1);
        rightfrontMotor.setPower(1);

        while (opModeIsActive() && leftbackMotor.isBusy())
        {
            telemetry.addData("encoder-fwd", leftbackMotor.getCurrentPosition() + "  busy=" + leftbackMotor.isBusy());
            telemetry.update();
            idle();
        }

        

    }}