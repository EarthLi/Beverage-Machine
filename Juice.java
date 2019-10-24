public class Juice extends Beverage {
    private String juiceType;

    public Juice(String size, String count, String juiceType) {
        super(size, count);
        this.juiceType = juiceType;
    }

    @Override
    public int getPrice() {
        int price = getOptionsPrice();
        //"Apple", "Orange", "Pineapple"
        if (juiceType.equals("Apple")) {
            price += 5;
        } else if (juiceType.equals("Orange")) {
            price += 6;
        } else if (juiceType.equals("Pineapple")) {
            price += 7;
        }
        return price;
    }

    @Override
    public String toString() {
        return juiceType.toLowerCase() + " juice";
    }
}
