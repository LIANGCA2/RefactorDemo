package rentalstore;

import java.util.Enumeration;

public class HtmlStatement extends Statement {

    protected  String getFooter(double totalAmount, Double frequentRenterPoints) {
        return "<P>You owe<EM>" + String.valueOf(totalAmount) + "</EM><P>\n"+
        "On this rental you earned <EM>" + String.valueOf(frequentRenterPoints) +
                "</EM> frequent renter points<P>";
    }

    protected  String getContent(double thisAmount, Rental each) {
        return each.getMovie().getTitle() + ": " + String.valueOf(thisAmount) + "<BR>\n";
    }

    protected  String getHeader(Customer customer) {
        return "<H1>Rentals for <EM>" + customer.getName() + "</EM></H1><P>\n";
    }
}
