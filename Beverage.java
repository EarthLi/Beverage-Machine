public abstract class Beverage {
    private String size;
    private int count;

    public Beverage(String size, String count) {
        this.size = size;
        this.count = Integer.parseInt(count);
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public abstract int getPrice();

    /**
     * this method just calculates size price
     *
     * @return
     */
    public int getOptionsPrice() {
        //"Small", "Medium", "Large"
        if (size.equals("Small")) {
            return 5;
        } else if (size.equals("Medium")) {
            return 6;
        } else {
            return 7;
        }
    }

    @Override
    public String toString() {
        return count + " glass(es) of";
    }
}
