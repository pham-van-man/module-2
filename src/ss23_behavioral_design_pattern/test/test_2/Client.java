package ss23_behavioral_design_pattern.test.test_2;

public class Client {
    public static void main(String[] args) {
        //create a remote control
        RemoteControl control = new RemoteControl();
        //create a light
        Light light = new Light();
        //Create 2 command
        Command lightsOn = new LightOnCommand(light);
        Command lightsOff = new LightOffCommand(light);
        //switch on
        control.setCommand(lightsOn);
        control.pressButton();
        //switch off
        control.setCommand(lightsOff);
        control.pressButton();
    }
}
