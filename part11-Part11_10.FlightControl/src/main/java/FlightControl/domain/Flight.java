package FlightControl.domain;

public class Flight {
    private Airplane airplane;
    private Place departureAirport;
    private Place destinationAirport;

    public Flight(Airplane airplane, Place departureAirport, Place destinationAirport) {
        this.airplane = airplane;
        this.departureAirport = departureAirport;
        this.destinationAirport = destinationAirport;
    }

    public Airplane getAirplane() {
        return this.airplane;
    }

    public Place getDepartureAirport() {
        return this.departureAirport;
    }

    public Place getDestinationAirport() {
        return this.destinationAirport;
    }

    public String toString() {
        return this.airplane.toString() + " (" + this.departureAirport + "-" + this.destinationAirport + ")";
    }
}

