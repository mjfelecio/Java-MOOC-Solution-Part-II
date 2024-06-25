package application;

import java.util.ArrayList;
import java.util.List;

public class AverageSensor implements Sensor{
    private List<Sensor> sensor;
    private List<Integer> readNumbers;

    public AverageSensor() {
        this.sensor = new ArrayList<>();
        this.readNumbers = new ArrayList<>();
    }

    public void addSensor(Sensor toAdd) {
        this.sensor.add(toAdd);
    }

    @Override
    public boolean isOn() {

        return this.sensor.stream().allMatch(Sensor::isOn);
    }

    @Override
    public void setOn() {
        for (Sensor s: this.sensor) {
            s.setOn();
        }
    }

    @Override
    public void setOff() {
        for (Sensor s: this.sensor) {
            s.setOff();
        }
    }

    @Override
    public int read() {
        if (isOn() || !this.sensor.isEmpty()) {
            int numberRead = (int) this.sensor.stream().map(Sensor::read).mapToInt(i -> i).average().getAsDouble();

            this.readNumbers.add(numberRead);

            return numberRead;
        } else {
            throw new IllegalStateException();
        }
    }

    public List<Integer> readings() {
        return readNumbers;
    }
}
