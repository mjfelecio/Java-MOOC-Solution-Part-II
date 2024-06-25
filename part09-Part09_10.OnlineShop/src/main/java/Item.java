public class Item {
    private String productName;
    private int itemQuantity;
    private int unitPrice;

    public Item(String product, int qty, int unitPrice) {
        this.productName = product;
        this.itemQuantity = qty;
        this.unitPrice = unitPrice;
    }

    public int price() {
        return this.unitPrice * this.itemQuantity;
    }

    public void increaseQuantity() {
        this.itemQuantity ++;
    }

    public String toString() {
        return this.productName + ": " + this.itemQuantity;
    }
}