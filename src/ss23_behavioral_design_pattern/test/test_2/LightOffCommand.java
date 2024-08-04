package ss23_behavioral_design_pattern.test.test_2;

public class LightOffCommand implements Command {
    //reference to the light
    Light light;

    public LightOffCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.switchOff();
    }
}
