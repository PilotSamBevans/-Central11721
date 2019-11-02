package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;
//left stick moves left wheels, vice versa

@TeleOp (name = "Phebe's TeleOp")
@Disabled
public class GlitchMobProgram extends OpMode {


    //claw side is the front side
    //15.7 in is the circumference for the big wheel

    //Setting up the variables and which pieces move upon initiation

   private DcMotor leftbackMotor, rightbackMotor, leftfrontMotor, rightfrontMotor, liftMotor;
    private Servo cowplowleftServo, cowplowrightServo;


    @Override
    public void init() {
        leftbackMotor = hardwareMap.dcMotor.get("leftbackMotor");
        rightbackMotor = hardwareMap.dcMotor.get("rightbackMotor");
        leftfrontMotor = hardwareMap.dcMotor.get("leftfrontMotor");
        rightfrontMotor = hardwareMap.dcMotor.get("rightfrontMotor");

        liftMotor = hardwareMap.dcMotor.get("liftMotor");

        cowplowleftServo = hardwareMap.servo.get("cowplowleftServo");
        cowplowrightServo = hardwareMap.servo.get("cowplowrightServo");

        liftMotor.setDirection(DcMotorSimple.Direction.REVERSE);
        liftMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        rightbackMotor.setDirection(DcMotorSimple.Direction.REVERSE);
        rightfrontMotor.setDirection(DcMotorSimple.Direction.REVERSE);

     //cowplowleftServo.setPosition(.5);
        // cowplowrightServo.setPosition(.5);



    }




    @Override
          public void loop() {


        //Forward and Back
        leftbackMotor.setPower(gamepad1.left_stick_y);
        rightbackMotor.setPower(gamepad1.left_stick_y);
        leftfrontMotor.setPower(gamepad1.left_stick_y);
        rightfrontMotor.setPower(gamepad1.left_stick_y);

        //Strafe Right and Left
        leftfrontMotor.setPower(-gamepad1.right_stick_x);
        rightbackMotor.setPower(-gamepad1.right_stick_x);
        rightfrontMotor.setPower(gamepad1.right_stick_x);
        leftbackMotor.setPower(gamepad1.right_stick_x);

        //Lift
        liftMotor.setPower(gamepad2.left_stick_y);

        //Left and Right Turn
       if (gamepad1.left_bumper) leftbackMotor.setPower(1);
       if (gamepad1.left_bumper) leftfrontMotor.setPower(1);
       if (gamepad1.left_bumper) rightfrontMotor.setPower(-1);
       if (gamepad1.left_bumper) rightbackMotor.setPower(-1);

       if (gamepad1.right_bumper) leftfrontMotor.setPower(-1);
       if (gamepad1.right_bumper) leftbackMotor.setPower(-1);
       if (gamepad1.right_bumper) rightfrontMotor.setPower(1);
       if (gamepad1.right_bumper) rightbackMotor.setPower(1);

        //Making sure the trigger/button/bumper pressed
        //moves the required parts(wheels, lift, and cowplow/pusher)

       if (gamepad2.a) cowplowleftServo.setPosition(.45);
       if (gamepad2.a) cowplowrightServo.setPosition(.45);

       //if (gamepad2.b) cowplowleftServo.setPosition(0);
       //if (gamepad2.b) cowplowrightServo.setPosition(0);

       if (gamepad2.y) cowplowleftServo.setPosition(1);
       if (gamepad2.y) cowplowrightServo.setPosition(1);





        telemetry.addData("Lift Encoder", liftMotor.getCurrentPosition());
        telemetry.update();
        }
}