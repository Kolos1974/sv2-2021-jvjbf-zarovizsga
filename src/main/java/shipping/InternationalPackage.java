package shipping;

public class InternationalPackage implements Transportable{
    private static final int transferCost = 1200;
    private static final int multiplier = 2;
    private static final int extraCostPerKm = 10;

    private int weight;
    private boolean breakable;
    private String destinationCountry;
    private int distance;

    public InternationalPackage(int weight, boolean breakable, String destinationCountry, int distance) {
        this.weight = weight;
        this.breakable = breakable;
        this.destinationCountry = destinationCountry;
        this.distance = distance;
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
            return (transferCost*multiplier)+(extraCostPerKm*distance);
        } else {
            return (transferCost)+(extraCostPerKm*distance);
        }
    }

    @Override
    public String getDestinationCountry() {
        return destinationCountry;
    }

    public int getDistance() {
        return distance;
    }
}
