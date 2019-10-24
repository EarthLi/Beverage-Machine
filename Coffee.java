public class Coffee extends Beverage {
    private boolean withMilk;

    public Coffee(String size, String count, boolean withMilk) {
        super(size, count);
        this.withMilk = withMilk;
    }

    @Override
    public int getPrice() {
        int price = getOptionsPrice()+4;
        if (withMilk) {
            price+=3;
        }
        return price;
    }

    @Override
    public String toString() {
        String s =  " coffee ";
        if (withMilk) {
            s += " wih milk";
        }
        return s;
    }
}
