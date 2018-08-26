package rentalstore;

public class CHILDRENS extends Movie {
    public CHILDRENS(String title) {
        super(title);
    }

    @Override
    public Double getAmount(Rental each) {
        return 1.5+(each.getDayRented() > 3?(each.getDayRented() -3)*1.5:0);
    }

    @Override
    public Double getFrequentRenterPoints(Rental rental) {
        return 1.0;
    }
}
