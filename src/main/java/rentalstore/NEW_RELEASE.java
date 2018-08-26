package rentalstore;

public class NEW_RELEASE extends Movie {
    public NEW_RELEASE(String title) {
        super(title);
    }

    @Override
    public Double getAmount(Rental each) {
        return each.getDayRented()*3.0;
    }
}
