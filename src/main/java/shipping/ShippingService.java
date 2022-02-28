package shipping;

import java.util.ArrayList;
import java.util.List;

public class ShippingService {
    private List<Transportable> packages;

    public ShippingService() {
        this.packages =  new ArrayList<>();
    }


    public void addPackage(Transportable transportable){
        packages.add(transportable);
    }

    public List<Transportable> getPackages() {
        return packages;
    }
}
