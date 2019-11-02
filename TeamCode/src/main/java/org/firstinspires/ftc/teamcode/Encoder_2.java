// autonomous program that drives bot forward a set distance, stops then
// backs up to the starting point using encoders to measure the distance.
// This example assumes there is one encoder, attached to the left motor.

package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;
@Disabled
@Autonomous (name = "Encoder_2")
public class Encoder_2 extends LinearOpMode {
    private DcMotor leftbackMotor, rightbackMotor, leftfrontMotor, rightfrontMotor;
    private Servo clawleftServo, clawrightServo;

    @Override
    public void runOpMode() throws InterruptedException {
        leftbackMotor = hardwareMap.dcMotor.get("leftbackMotor");
        rightbackMotor = hardwareMap.dcMotor.get("rightbackMotor");
        leftfrontMotor = hardwareMap.dcMotor.get("leftfrontMotor");
        rightfrontMotor = hardwareMap.dcMotor.get("rightfrontMotor");

        clawleftServo = hardwareMap.servo.get("clawleftServo");
        clawrightServo = hardwareMap.servo.get("clawrightServo");


        leftfrontMotor.setDirection(DcMotorSimple.Direction.REVERSE);
        leftbackMotor.setDirection(DcMotorSimple.Direction.REVERSE);

        clawleftServo.setPosition(1);//1
        clawrightServo.setPosition(0);//0


        // reset encoder count kept by left motor.
        leftbackMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        // set left motor to run to target encoder position and stop with brakes on.
        leftbackMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        // set right motor to run without regard to an encoder.
        rightbackMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        rightfrontMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        leftfrontMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        telemetry.addData("Mode", "waiting");
        telemetry.update();


        waitForStart();

        telemetry.addData("Mode", "running");
        telemetry.update();


        //TO DEPOT

        leftbackMotor.setTargetPosition(2900);

        leftbackMotor.setPower(1);
        leftfrontMotor.setPower(1);
        rightbackMotor.setPower(0.78);
        rightfrontMotor.setPower(0.78);

        // wait while opmode is active and left motor is busy running to position.

        while (opModeIsActive() && leftbackMotor.isBusy()) {
            telemetry.addData("encoder-fwd", leftbackMotor.getCurrentPosition() + "  busy=" + leftbackMotor.isBusy());
            telemetry.update();
            idle();
        }

        // set motor power to zero to turn off motors. The motors stop on their own but
        // power is still applied so we turn off the power.

        leftbackMotor.setPower(0.0);
        leftfrontMotor.setPower(0.0);
        rightbackMotor.setPower(0.0);
        rightfrontMotor.setPower(0.0);

        // wait 5 sec to you can observe the final encoder position.

        resetStartTime();

        while (opModeIsActive() && getRuntime() < 1) {
            telemetry.addData("encoder-fwd-end", leftbackMotor.getCurrentPosition() + "  busy=" + leftbackMotor.isBusy());
            telemetry.update();
            idle();

            clawleftServo.setPosition(0);
            clawrightServo.setPosition(1);

            sleep(1500);
            //BACKWARDS

            leftbackMotor.setTargetPosition(1700);


            leftbackMotor.setPower(-1);
            leftfrontMotor.setPower(-1);
            rightbackMotor.setPower(-0.78);
            rightfrontMotor.setPower(-0.78);

            // wait while opmode is active and left motor is busy running to position.

            while (opModeIsActive() && leftbackMotor.isBusy()) {
                telemetry.addData("encoder-fwd", leftbackMotor.getCurrentPosition() + "  busy=" + leftbackMotor.isBusy());
                telemetry.update();
                idle();
            }


            leftbackMotor.setPower(0.0);
            leftfrontMotor.setPower(0.0);
            rightbackMotor.setPower(0.0);
            rightfrontMotor.setPower(0.0);

            // wait 5 sec to you can observe the final encoder position.

            resetStartTime();

            while (opModeIsActive() && getRuntime() < 1) {
                telemetry.addData("encoder-fwd-end", leftbackMotor.getCurrentPosition() + "  busy=" + leftbackMotor.isBusy());
                telemetry.update();
                idle();

                sleep(500);

                //TURN LEFT

                leftbackMotor.setTargetPosition(500);

                // set both motors to 25% power. Movement will start.

                leftbackMotor.setPower(-0.5);
                leftfrontMotor.setPower(-0.5);
                rightbackMotor.setPower(0.39);
                rightfrontMotor.setPower(0.39);

                // wait while opmode is active and left motor is busy running to position.

                while (opModeIsActive() && leftbackMotor.isBusy()) {
                    telemetry.addData("encoder-fwd", leftbackMotor.getCurrentPosition() + "  busy=" + leftbackMotor.isBusy());
                    telemetry.update();
                    idle();
                }

                // set motor power to zero to turn off motors. The motors stop on their own but
                // power is still applied so we turn off the power.

                leftbackMotor.setPower(0.0);
                leftfrontMotor.setPower(0.0);
                rightbackMotor.setPower(0.0);
                rightfrontMotor.setPower(0.0);

                // wait 5 sec to you can observe the final encoder position.

                resetStartTime();

                while (opModeIsActive() && getRuntime() < 1) {
                    telemetry.addData("encoder-fwd-end", leftbackMotor.getCurrentPosition() + "  busy=" + leftbackMotor.isBusy());
                    telemetry.update();
                    idle();

                    //TO CRATER

                    leftbackMotor.setTargetPosition(5000);


                    leftbackMotor.setPower(1);
                    leftfrontMotor.setPower(1);
                    rightbackMotor.setPower(0.78);
                    rightfrontMotor.setPower(0.78);


                    while (opModeIsActive() && leftbackMotor.isBusy()) {
                        telemetry.addData("encoder-fwd", leftbackMotor.getCurrentPosition() + "  busy=" + leftbackMotor.isBusy());
                        telemetry.update();
                        idle();
                    }


                    leftbackMotor.setPower(0.0);
                    leftfrontMotor.setPower(0.0);
                    rightbackMotor.setPower(0.0);
                    rightfrontMotor.setPower(0.0);

                    // wait 5 sec to you can observe the final encoder position.

                    resetStartTime();

                    while (opModeIsActive() && getRuntime() < 1) {
                        telemetry.addData("encoder-fwd-end", leftbackMotor.getCurrentPosition() + "  busy=" + leftbackMotor.isBusy());
                        telemetry.update();
                        idle();

                    }
                }
            }
        }
    }
}