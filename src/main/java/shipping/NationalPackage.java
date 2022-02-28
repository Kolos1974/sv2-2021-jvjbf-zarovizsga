package shipping;

public class NationalPackage implements Transportable{
    private static final int transferCost = 1000;
    private static final int multiplier = 2;

    private int weight;
    private boolean breakable;

    public NationalPackage(int weight, boolean breakable) {
        this.weight = weight;
        this.breakable = breakable;
    }

    @Override
    public int getWeight() {
        return weight;
    }

    @Override
    public boolean isBreakable() {
        return breakable;
    }

    @Override
    public int calculateShippingPrice() {
        if (this.breakable){
            return transferCost*multiplier;
        } else {
            return transferCost;
        }
    }
}
