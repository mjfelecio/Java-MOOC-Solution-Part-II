public class Person {
    private String name;
    private Education edu;

    public Person(String name, Education education) {
        this.name = name;
        this.edu = education;
    }

    public Education getEducation() {
        return this.edu;
    }

    @Override
    public String toString() {
        return this.name + ", " + this.edu;
    }
}
