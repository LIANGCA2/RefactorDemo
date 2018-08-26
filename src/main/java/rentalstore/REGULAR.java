package rentalstore;

public class REGULAR extends Movie {
    @Override
    public Double getAmount(Rental each) {
        return 2+(each.getDayRented() > 2?(each.getDayRented() - 2) * 1.5:0);
    }

}
