package shipping;

import java.util.*;

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


    public List<Transportable> collectItemsByBreakableAndWeight(boolean breakable, int weight){
        List<Transportable> result = new ArrayList<>();
        for (Transportable element : packages){
            if (element.isBreakable() == breakable && element.getWeight()>=weight){
                result.add(element);
            }
        }
        return result;
    }

    public Map<String, Integer> collectTransportableByCountry(){
        Map<String, Integer> result = new HashMap<>();
        for (Transportable element : packages){
            int packageNumber = 1;
            if (result.containsKey(element.getDestinationCountry())){
                packageNumber = result.get(element.getDestinationCountry())+1;
            }
            result.put(element.getDestinationCountry(),packageNumber);
        }
        return result;
    }

    public List<Transportable> sortInternationalPackagesByDistanceWithList(){
        List<Transportable> result = new ArrayList<>();
        for (Transportable element : packages){
            if (element instanceof InternationalPackage){
                result.add(goodPosition(result, ((InternationalPackage) element).getDistance()), element);
            }
        }
        return result;
    }

    private int goodPosition(List<Transportable> result, int distance){
        int pos = 0;
        for (int i = 0; i<result.size(); i++ ){
            if (result.get(i).getWeight()<=distance){
                pos = i;
            }
        }
        return pos;
    }


    public List<Transportable> sortInternationalPackagesByDistance(){
        return packages.stream()
                .filter(transportable -> transportable instanceof InternationalPackage)
                .sorted(Comparator.comparing(packages -> ((InternationalPackage) packages).getDistance()))
                .toList();
    }
}
