package rentalstore;

public class CHILDRENS extends Movie {
    @Override
    public Double getAmount(Rental each) {
        return 1.5+(each.getDayRented() > 3?(each.getDayRented() -3)*1.5:0);
    }
}
