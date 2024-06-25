package FlightControl.domain;

public class Airplane {
    private final String airplaneID;
    private final int capacity;

    public Airplane(String airplaneID, int capacity) {
        this.airplaneID = airplaneID;
        this.capacity = capacity;
    }

    public String getAirplaneID() {
        return this.airplaneID;
    }

    public int getCapacity() {
        return this.capacity;
    }

    @Override
    public String toString() {
        return this.airplaneID + " (" + this.capacity + " capacity)";
    }
}
