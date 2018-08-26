package rentalstore;

public class NEW_RELEASE extends Movie {
    @Override
    public Double getAmount(Rental each) {
        return each.getDayRented()*3.0;
    }
}
