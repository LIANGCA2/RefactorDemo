package rentalstore;

import java.util.Enumeration;

public class TextStatement extends Statement{

    protected  String getFooter(double totalAmount, Double frequentRenterPoints) {
        return "Amount owed is " + String.valueOf(totalAmount) + "\n"+
        "You earned " + String.valueOf(frequentRenterPoints) + " frequent renter points";
    }

    protected  String getContent(double thisAmount, Rental each) {
        return "\t" + each.getMovie().getTitle() + "\t" + String.valueOf(thisAmount) + "\n";
    }

    protected  String getHeader(Customer customer) {
        return "Rental Record for " + customer.getName() + "\n";
    }
}
