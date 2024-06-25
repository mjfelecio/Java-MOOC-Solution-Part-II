public class Literacy {
    private String theme;
    private String ageGroup;
    private String gender;
    private String country;
    private int year;
    private double literacyPercent;

    public Literacy(String theme, String ageGroup, String gender, String country, int year, double literacyPercent) {
        this.theme = theme;
        this.ageGroup = ageGroup;
        this.gender = gender;
        this.country = country;
        this.year = year;
        this.literacyPercent = literacyPercent;
    }


    public String getTheme() {
        return theme;
    }

    public String getAgeGroup() {
        return ageGroup;
    }

    public String getGender() {
        return gender;
    }

    public String getCountry() {
        return country;
    }

    public int getYear() {
        return year;
    }

    public double getLiteracyPercent() {
        return literacyPercent;
    }
}