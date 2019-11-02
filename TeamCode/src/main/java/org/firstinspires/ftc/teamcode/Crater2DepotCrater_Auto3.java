package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;

@Autonomous (name = "Crater Depot Crater for Phebe")
@Disabled
public class Crater2DepotCrater_Auto3 extends LinearOpMode {
    private DcMotor leftbackMotor, rightbackMotor, leftfrontMotor, rightfrontMotor, liftMotor;
    private Servo dumperleftServo, dumperrightServo;

    @Override
    public void runOpMode() throws InterruptedException {
        leftbackMotor = hardwareMap.dcMotor.get("leftbackMotor");
        rightbackMotor = hardwareMap.dcMotor.get("rightbackMotor");
        leftfrontMotor = hardwareMap.dcMotor.get("leftfrontMotor");
        rightfrontMotor = hardwareMap.dcMotor.get("rightfrontMotor");

        liftMotor = hardwareMap.dcMotor.get("liftMotor");

        leftfrontMotor.setDirection(DcMotorSimple.Direction.REVERSE);
        leftbackMotor.setDirection(DcMotorSimple.Direction.REVERSE);


        // reset encoder count kept by left motor.
        leftbackMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        rightbackMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        // set left motor to run to target encoder position and stop with brakes on.
        leftbackMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        rightbackMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        // set right motor to run without regard to an encoder.
        rightfrontMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        leftfrontMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        telemetry.addData("Mode", "waiting");
        telemetry.update();

        waitForStart();

        telemetry.addData("Mode", "running");
        telemetry.update();


        //TO DEPOT

        leftbackMotor.setTargetPosition(1200);
        rightbackMotor.setTargetPosition(1200);

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


            sleep(1500);
            //TO DEPOT(pt2)
            //TURNING LEFT

            leftbackMotor.setTargetPosition(-565);
            rightbackMotor.setTargetPosition(565);

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

                //TO DEPOT(pt3)
                //FORWARD

                leftbackMotor.setTargetPosition(2000);
                rightbackMotor.setTargetPosition(2000);
                // set both motors to 25% power. Movement will start.

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
                    sleep(1000);
                    //TO DEPOT(pt4)
                    //TURNING LEFT

                    //TO DEPOT(pt2)
                    //TURNING LEFT

                    leftbackMotor.setTargetPosition(-1500);
                    rightbackMotor.setTargetPosition(1500);

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

                        //TO DEPOT(pt5)
                        //FORWARD

                        leftbackMotor.setTargetPosition(2500);
                        rightbackMotor.setTargetPosition(2500);

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


                            sleep(1000);

                            //TO CRATER
                            //TURNING AROUND

                            leftbackMotor.setTargetPosition(-1400);
                            rightbackMotor.setTargetPosition(1400);

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



                                //TO CRATER(pt2)
                                //FORWARD

                                leftbackMotor.setTargetPosition(5600);
                                rightbackMotor.setTargetPosition(5600);

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
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}