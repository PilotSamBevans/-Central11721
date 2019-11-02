package org.firstinspires.ftc.teamcode;

import android.graphics.Color;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;


@Autonomous (name = "Color_Sensor_Experiment")
@Disabled
public class Color_Sensor_Experiment extends LinearOpMode {
    private DcMotor leftbackMotor, rightbackMotor, leftfrontMotor, rightfrontMotor;
    private Servo clawleftServo, clawrightServo;
    public ColorSensor color_sensor;

    @Override
    public void runOpMode() throws InterruptedException {
        color_sensor = hardwareMap.colorSensor.get("color_sensor");
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

        // hsvValues is an array that will hold the hue, saturation, and value information.
        float hsvValues[] = {0F, 0F, 0F};

        // values is a reference to the hsvValues array.
        //final float values[] = hsvValues;

        telemetry.addData("Mode", "waiting");
        telemetry.update();

        waitForStart();
        while (opModeIsActive()) {
            Color.RGBToHSV(color_sensor.red() * 8, color_sensor.green() * 8, color_sensor.blue() * 8, hsvValues);
            telemetry.addData("red ", color_sensor.red());
            telemetry.addData("green ", color_sensor.green());
            telemetry.addData("blue ", color_sensor.blue());
            telemetry.update();
        }
    }
}
