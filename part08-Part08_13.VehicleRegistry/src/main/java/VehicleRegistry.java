import java.util.ArrayList;
import java.util.HashMap;

public class VehicleRegistry {
    private final HashMap<LicensePlate, String> licenseOfOwner;

    public VehicleRegistry() {
        this.licenseOfOwner = new HashMap<>();
    }

    public boolean add(LicensePlate licensePlate, String ownerName) {
        if (!this.licenseOfOwner.containsKey(licensePlate)) {
            this.licenseOfOwner.put(licensePlate, ownerName);
            return true;
        } else {
            return false;
        }
    }

    public String get(LicensePlate licensePlate) {
        return this.licenseOfOwner.get(licensePlate);
    }

    public boolean remove(LicensePlate licensePlate) {
        if (this.licenseOfOwner.containsKey(licensePlate)) {
            this.licenseOfOwner.remove(licensePlate);
            return true;
        } else {
            return false;
        }
    }

    public void printLicensePlates() {
        for (LicensePlate license : this.licenseOfOwner.keySet()) {
            System.out.println(license);
        }
    }

    public void printOwners() {
        ArrayList<String> printedOwners = new ArrayList<>();

        for (String owner : this.licenseOfOwner.values()) {
            if (!(printedOwners.contains(owner))) {
                System.out.println(owner);

                printedOwners.add(owner);
            }
        }
    }
}
