package rentalstore;

public class ART extends Movie {
    public ART(String title) {
        super(title);
    }

    @Override
    public Double getAmount(Rental rental) {
        return 6.0*rental.getDayRented();
    }

    @Override
    public Double getFrequentRenterPoints(Rental rental) {
        return 1.5;
    }
}
