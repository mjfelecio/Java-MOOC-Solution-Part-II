public class Book implements Comparable<Book> {
    private String name;
    private int ageRecommendation;

    public Book (String name, int ageRec) {
        this.name = name;
        this.ageRecommendation = ageRec;
    }

    public String getName() {
        return this.name;
    }

    public int getAgeRecommendation() {
        return this.ageRecommendation;
    }

    @Override
    public int compareTo(Book o) {
        return this.ageRecommendation - o.ageRecommendation;
    }

    public String toString() {
        return this.name + " (recommended for " + this.ageRecommendation + " year-olds or older)";
    }
}