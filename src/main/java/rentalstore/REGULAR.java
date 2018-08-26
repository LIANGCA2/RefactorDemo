package rentalstore;

public class REGULAR extends Movie {
    public REGULAR(String title) {
        super(title);
    }

    @Override
    public Double getAmount(Rental each) {
        return 2+(each.getDayRented() > 2?(each.getDayRented() - 2) * 1.5:0);
    }

}
