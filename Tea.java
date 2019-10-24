public class Tea extends Beverage{
    private boolean isWithSugar;

    public Tea(String size, String count, boolean isWithSugar) {
        super(size, count);
        this.isWithSugar = isWithSugar;
    }
    @Override
    public int getPrice() {
        int price = getOptionsPrice()+3;
        if(isWithSugar){
            price++;
        }
        return price;
    }

    @Override
    public String toString() {
        String s =  " tea ";
        if (isWithSugar) {
            s += " wih sugar";
        }
        return s;
    }
}
