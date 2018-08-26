package rentalstore;

import java.util.Enumeration;

public abstract class Statement {
    public String statement(Customer customer){
        double totalAmount = 0;
        int frequentRenterPoints = 0;
        Enumeration rentals = customer.getRentals().elements();
        String result = getHeader(customer);
        while(rentals.hasMoreElements()){
            double thisAmount =0;
            Rental each = (Rental) rentals.nextElement();

            thisAmount = getThisAmount(each);

            //add frequent renter points
            frequentRenterPoints ++;
            //add bonus for a two day new release rental
            if((each.getMovie() instanceof NEW_RELEASE) && each.getDayRented() > 1){
                frequentRenterPoints ++;
            }

            //show figures for this rental
            result += getContent(thisAmount, each);
            totalAmount += thisAmount;
        }

        //add footer lines
        result += getFooter(totalAmount, frequentRenterPoints);
        return result;
    }

    private double getThisAmount(Rental each) {
        double thisAmount = 0;
        Movie movie = each.getMovie();
        thisAmount = movie.getAmount(each);
        return thisAmount;
    }

    protected abstract  String getFooter(double totalAmount, int frequentRenterPoints);

    protected abstract  String getContent(double thisAmount, Rental each);

    protected abstract String getHeader(Customer customer);
}
