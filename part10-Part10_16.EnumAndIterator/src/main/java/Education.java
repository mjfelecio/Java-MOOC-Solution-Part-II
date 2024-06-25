public enum Education {
    PHD ("Doctoral degree"),
    MA ("Masters degree"),
    BA ("Bachelors degree"),
    HS ("High School diploma");

    private String code;

    Education(String code) {
        this.code = code;
    }

    public String getCode() {
        return this.code;
    }
}