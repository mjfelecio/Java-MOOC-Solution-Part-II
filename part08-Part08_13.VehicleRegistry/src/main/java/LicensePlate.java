
import java.util.Objects;

public class LicensePlate {
    // don't modify existing parts of this class

    // these instance variables have been defined as final, meaning
    // that once set, their value can't be changed
    private final String liNumber;
    private final String country;

    public LicensePlate(String country, String liNumber) {
        this.liNumber = liNumber;
        this.country = country;
    }

    public boolean equals(Object compared) {
        if (this == compared) {
            return true;
        }

        if (!(compared instanceof LicensePlate)) {
            return false;
        }

        LicensePlate comparedLicense = (LicensePlate) compared;

        return this.liNumber.equals(comparedLicense.liNumber) &&
                this.country.equals(comparedLicense.country);
    }

    public int hashCode() {
        if (this.country == null) {
            return this.liNumber.hashCode();
        }

        return country.hashCode() + liNumber.hashCode();
    }

    @Override
    public String toString() {
        return country + " " + liNumber;
    }

}
