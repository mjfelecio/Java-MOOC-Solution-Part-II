package application;

public class StandardSensor implements Sensor{
    private final int value;

    public StandardSensor(int sensorValue) {
        this.value = sensorValue;
    }


    @Override
    public boolean isOn() {
        return true;
    }

    @Override
    public void setOn() {

    }

    @Override
    public void setOff() {

    }

    @Override
    public int read() {
        return this.value;
    }
}