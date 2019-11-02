package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;

import static com.qualcomm.robotcore.hardware.DcMotor.RunMode.RUN_WITHOUT_ENCODER;

@Autonomous(name = "Donut Program")
@Disabled
public class donut_program extends LinearOpMode {
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

        leftfrontMotor.setMode(RUN_WITHOUT_ENCODER);
        rightfrontMotor.setMode(RUN_WITHOUT_ENCODER);



        leftbackMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        rightbackMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        liftMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        //Declaring Variables and Setting Up Encoders

        leftbackMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        rightbackMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        liftMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        leftfrontMotor.setMode(RUN_WITHOUT_ENCODER);
        rightfrontMotor.setMode(RUN_WITHOUT_ENCODER);
        telemetry.addData("Mode", "waiting");
            telemetry.update();

            leftfrontMotor.setDirection(DcMotorSimple.Direction.REVERSE);
            rightbackMotor.setDirection(DcMotorSimple.Direction.REVERSE);


            //Autonomous

            waitForStart();

            liftMotor.setTargetPosition(400);
            liftMotor.setPower(.5);
            while (opModeIsActive() && liftMotor.isBusy()) {
                idle();
            }
            liftMotor.setPower(0);}}

