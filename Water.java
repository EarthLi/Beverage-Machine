public class Water extends Beverage {
    private boolean isWithIce;

    public Water(String size, String count, boolean isWithIce) {
        super(size, count);
        this.isWithIce = isWithIce;
    }

    @Override
    public int getPrice() {
        int price = getOptionsPrice()+2;
        if(isWithIce){
            price++;
        }
        return price;
    }

    @Override
    public String toString() {
        String s =  " water ";
        if (isWithIce) {
            s += " wih ice";
        }
        return s;
    }
}
