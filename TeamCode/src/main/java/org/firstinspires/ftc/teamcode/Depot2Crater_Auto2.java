package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;

@Autonomous (name = "Depot2Crater_Auto2")
@Disabled
public class Depot2Crater_Auto2 extends LinearOpMode {
    private DcMotor leftbackMotor, rightbackMotor, leftfrontMotor, rightfrontMotor, liftMotor;
    private Servo dumperleftServo, dumperrightServo;

    @Override
    public void runOpMode() throws InterruptedException {
        leftbackMotor = hardwareMap.dcMotor.get("leftbackMotor");
        rightbackMotor = hardwareMap.dcMotor.get("rightbackMotor");
        leftfrontMotor = hardwareMap.dcMotor.get("leftfrontMotor");
        rightfrontMotor = hardwareMap.dcMotor.get("rightfrontMotor");

        leftbackMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        rightbackMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        leftfrontMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        rightfrontMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);


        leftfrontMotor.setDirection(DcMotorSimple.Direction.REVERSE);
        leftbackMotor.setDirection(DcMotorSimple.Direction.REVERSE);
        liftMotor.setDirection(DcMotorSimple.Direction.REVERSE);


        // reset encoder count kept by left motor.
        leftbackMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        rightbackMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        // set left motor to run to target encoder position and stop with brakes on.
        leftbackMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        rightbackMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        // set right motor to run without regard to an encoder.
        //rightbackMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        rightfrontMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        leftfrontMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        telemetry.addData("Mode", "waiting");
        telemetry.update();


        waitForStart();

        //liftMotor.setTargetPosition();

        //sampling
        //(sampling is for a later date)

        telemetry.addData("Mode", "running");
        telemetry.update();

        //TO DEPOT

        leftbackMotor.setTargetPosition(2900);
        rightbackMotor.setTargetPosition(-2900);

        leftbackMotor.setPower(1);
        leftfrontMotor.setPower(1);
        rightbackMotor.setPower(-0.78);
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


            sleep(1500);


            //claiming
            // drivePower(1.5);
            // sleep(1610);
            // drivePower(0);
            // sleep(500);


            //clawleftServo.setPosition(0);
            //clawrightServo.setPosition(1);
            //clawleftServo.setPosition(0);
            // clawrightServo.setPosition(1);
            //sleep(1500);


            //BACK FROM DEPOT

            //leftbackMotor.setTargetPosition(1700);//*1700


            //leftbackMotor.setPower(-1);
            //leftfrontMotor.setPower(-1);
            //rightbackMotor.setPower(-0.78);
            //rightfrontMotor.setPower(-0.78);

            // wait while opmode is active and left motor is busy running to position.

            //while (opModeIsActive() && leftbackMotor.isBusy()) {
              //  telemetry.addData("encoder-fwd", leftbackMotor.getCurrentPosition() + "  busy=" + leftbackMotor.isBusy());
                //telemetry.update();
                //idle();
            //}


            //leftbackMotor.setPower(0.0);
            //leftfrontMotor.setPower(0.0);
            //rightbackMotor.setPower(0.0);
            //rightfrontMotor.setPower(0.0);

            // wait 5 sec to you can observe the final encoder position.

            //resetStartTime();

            //while (opModeIsActive() && getRuntime() < 1) {
              //  telemetry.addData("encoder-fwd-end", leftbackMotor.getCurrentPosition() + "  busy=" + leftbackMotor.isBusy());
                //telemetry.update();
                //idle();

                //sleep(500);

                //leftbackMotor.setPower(-0.33);
                //leftfrontMotor.setPower(-0.33);
                //rightfrontMotor.setPower(0.33);
                //rightbackMotor.setPower(0.33);

                //sleep(1000);

                //go in the crater


                //TURN LEFT

                leftbackMotor.setTargetPosition(-620);//*-600 = Turns too much
                rightbackMotor.setTargetPosition(-620);


                leftbackMotor.setPower(-0.5);
                leftfrontMotor.setPower(-0.5);
                rightbackMotor.setPower(-0.39);
                rightfrontMotor.setPower(0.39);


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

                    //TO CRATER

                    leftbackMotor.setTargetPosition(5700);
                    rightbackMotor.setTargetPosition(5700);

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
                        stop();

                        //drivePower(0);
                        //sleep(500);
                        //drivePower(2.8);
                        //sleep(2050);
                        //drivePower(0);


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


                    }
                }
            }
        }
    }