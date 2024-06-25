package dictionary;

public class Main{
    public static void main(String[] args) {


        SaveableDictionary dictionary = new SaveableDictionary("words.txt");

        dictionary.add("Sheesh", "Lmao");
        dictionary.add("Damn", "lol");
        dictionary.add("asd", "Lmadsao");

        dictionary.save();





    }
}
