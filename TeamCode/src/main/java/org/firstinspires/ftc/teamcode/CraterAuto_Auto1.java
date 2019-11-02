package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;
@Autonomous (name = "Crater Auto Phebe")
@Disabled
public class CraterAuto_Auto1 extends LinearOpMode {
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

        //Raise Lift
        //liftMotor.setTargetPosition(2);
        //liftMotor.setPower(.25);
        //liftMotor.wait(2000);
        //liftMotor.setPower(0);

        //if (liftMotor.isBusy())
        //{leftbackMotor.setPower(0);
            //rightbackMotor.setPower(0);
            //leftfrontMotor.setPower(0);
            //rightfrontMotor.setPower(0);}

            //leftbackMotor.wait(2000);
            //leftfrontMotor.wait(2000);
            //rightfrontMotor.wait(2000);
          //  rightbackMotor.wait(2000);

        //Turn left slightly
        //leftbackMotor.setTargetPosition(-290);
        //rightbackMotor.setTargetPosition(290);

        //leftbackMotor.setPower(-.5);
        //rightbackMotor.setPower(.5);
        //leftfrontMotor.setPower(-.5);
        //rightfrontMotor.setPower(.5);

        //Lower Lift
        //liftMotor.setTargetPosition(-200);

        //liftMotor.setPower(-.5);

        //Back To Wall
        //leftbackMotor.setTargetPosition(-3600);
        //rightbackMotor.setTargetPosition(-3600);

        //leftbackMotor.setPower(-.5);
        //rightbackMotor.setPower(-.5);
        //leftfrontMotor.setPower(-.5);
        //rightfrontMotor.setPower(-.5);

        //Continue Turning Left
        //leftbackMotor.setTargetPosition(-360);
        //rightbackMotor.setTargetPosition(360);

        //leftbackMotor.setPower(-1);
        //rightbackMotor.setPower(1);
        //leftfrontMotor.setPower(-1);
        //rightfrontMotor.setPower(1);

        //Forward To Crater
        leftbackMotor.setTargetPosition(2320);
        rightbackMotor.setTargetPosition(-2320);

        leftbackMotor.setPower(1);
        rightbackMotor.setPower(-1);
        leftfrontMotor.setPower(1);
        rightfrontMotor.setPower(1);

        //crater
        //telemetry.addData("Mode", "running");
        //telemetry.update();


        //leftbackMotor.setTargetPosition(4000);
        //rightbackMotor.setTargetPosition(4000);


        //leftbackMotor.setPower(1);
        //rightbackMotor.setPower(1);
        //leftfrontMotor.setPower(1);
        //rightfrontMotor.setPower(1);



        while (opModeIsActive() && leftbackMotor.isBusy())
        {
            telemetry.addData("encoder-fwd", leftbackMotor.getCurrentPosition() + "  busy=" + leftbackMotor.isBusy());
            telemetry.update();
            idle();
        }



        leftbackMotor.setPower(0.0);
        rightbackMotor.setPower(0.0);
        rightfrontMotor.setPower(0.0);
        leftfrontMotor.setPower(0.0);



        resetStartTime();

        while (opModeIsActive() && getRuntime() < 1)
        {
            telemetry.addData("encoder-fwd-end", leftbackMotor.getCurrentPosition() + "  busy=" + leftbackMotor.isBusy());
            telemetry.update();
            idle();
        }




        resetStartTime();

        while (opModeIsActive() && getRuntime() < 1)
        {
            telemetry.addData("encoder-back-end", leftbackMotor.getCurrentPosition());
            telemetry.update();
            idle();
        }
    }


        //claiming
        //drivePower(1);
        //sleep(1610);
        //drivePower(0);
        //sleep(500);


        // TODO - drive with encoders
        //double wantedDistance = 47; // Distance in inches
        //double wheelCircumference = 16.1875; // Circumference in inches
        //double encodersPerRevolution = leftfrontMotor.getMotorType().getTicksPerRev();
        //double neededRevolutions = 1.5;
        //double neededEncoders = 630;
        // TODO - while motor.getCurrentPosition is less than needed





        //16.1875in = wheel circumference
        //about 47in = distance from landing space to claiming space
        //about 1.5(?) wheel rotations to the claiming space

        // Drive forwards
        //drivePower(0.75);
        //sleep(3000);
        //drivePower(0);

        //sleep(500);

        // Drive backwards
        //drivePower(-0.75);
        //sleep(100);
        //drivePower(0);


    private void drivePower(double power) {
        leftbackMotor.setPower(power);
        rightbackMotor.setPower(power);
        leftfrontMotor.setPower(power);
        rightfrontMotor.setPower(power);
    }
}
