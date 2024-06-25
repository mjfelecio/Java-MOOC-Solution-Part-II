import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Hand implements Comparable<Hand> {
    private List<Card> cardsInHand;

    public Hand() {
        this.cardsInHand = new ArrayList<>();
    }

    public void add(Card card) {
        this.cardsInHand.add(card);
    }

    public void print() {
        this.cardsInHand.forEach(System.out::println);
    }

    public void sort() {
        this.cardsInHand.sort(Card::compareTo);
    }

    public List<Card> getCardsInHand() {
        return this.cardsInHand;
    }

    @Override
    public int compareTo(Hand o) {
        int thisHand = this.cardsInHand.stream()
                .map(Card::getValue)
                .reduce(0, Integer::sum);
        int comparedHand = o.getCardsInHand().stream()
                .map(Card::getValue)
                .reduce(0, Integer::sum);

        return thisHand - comparedHand;
    }

    public void sortBySuit() {
        Collections.sort(this.cardsInHand, new BySuitInValueOrder());
    }


}