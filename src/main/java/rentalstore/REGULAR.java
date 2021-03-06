package rentalstore;

public class REGULAR extends Movie {
    public REGULAR(String title) {
        super(title);
    }

    @Override
    public Double getAmount(Rental rental) {
        return 2+(rental.getDayRented() > 2?(rental.getDayRented() - 2) * 1.5:0);
    }

    @Override
    public Double getFrequentRenterPoints(Rental rental) {
        return 1.0;
    }
}
