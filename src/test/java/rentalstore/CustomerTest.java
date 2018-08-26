package rentalstore;

import rentalstore.Movie;
import rentalstore.Rental;
import rentalstore.Customer;
import org.junit.Test;

import static org.junit.Assert.*;

public class CustomerTest {
    private Customer customer = new Customer("Carol");
    @Test
    public void should_return_correct_statement_given_customer_has_no_rental() {
        String statement = customer.statement();
        assertEquals("Rental Record for Carol\nAmount owed is 0.0\nYou earned 0.0 frequent renter points", statement);
    }
    @Test
    public void should_return_correct_statement_given_customer_has_rent_one_regular_movie_for_1_day() {
        Movie regularMovie = new REGULAR("Titanic");
        Rental oneDayRental = new Rental(regularMovie, 1);
        customer.addRental(oneDayRental);

        String statement = customer.statement();

        assertEquals("Rental Record for Carol\n" +
                "\t" + regularMovie.getTitle() + "\t2.0\n" +
                "Amount owed is 2.0\n" +
                "You earned 1.0 frequent renter points", statement);
    }

    @Test
    public void should_return_correct_statement_given_customer_has_rent_one_regular_movie_for_3_day() {
        Movie regularMovie = new REGULAR("Titanic");
        Rental threeDayRental = new Rental(regularMovie, 3);
        customer.addRental(threeDayRental);

        String statement = customer.statement();

        assertEquals("Rental Record for Carol\n" +
                "\t" + regularMovie.getTitle() + "\t3.5\n" +
                "Amount owed is 3.5\n" +
                "You earned 1.0 frequent renter points", statement);
    }

    @Test
    public void should_return_correct_statement_given_customer_has_rent_one_new_release_movie_for_1_day() {
       Movie newReleaseMovie = new NEW_RELEASE("Titanic");
       Rental oneDayRental = new Rental(newReleaseMovie, 1);
        customer.addRental(oneDayRental);

        String statement = customer.statement();

        assertEquals("Rental Record for Carol\n" +
                "\t" + newReleaseMovie.getTitle() + "\t3.0\n" +
                "Amount owed is 3.0\n" +
                "You earned 1.0 frequent renter points", statement);
    }

    @Test
    public void should_return_correct_statement_given_customer_has_rent_one_new_release_movie_for_2_day() {
       Movie newReleaseMovie = new NEW_RELEASE("Titanic");
        Rental twoDayRental = new Rental(newReleaseMovie, 2);
        customer.addRental(twoDayRental);

        String statement = customer.statement();

        assertEquals("Rental Record for Carol\n" +
                "\t" + newReleaseMovie.getTitle() + "\t6.0\n" +
                "Amount owed is 6.0\n" +
                "You earned 2.0 frequent renter points", statement);
    }

    @Test
    public void should_return_correct_statement_given_customer_has_rent_one_child_movie_for_1_day() {
        Movie childrenMovie = new CHILDRENS("Titanic");
        Rental oneDayRental = new Rental(childrenMovie, 1);
        customer.addRental(oneDayRental);

        String statement = customer.statement();

        assertEquals("Rental Record for Carol\n" +
                "\t" + childrenMovie.getTitle() + "\t1.5\n" +
                "Amount owed is 1.5\n" +
                "You earned 1.0 frequent renter points", statement);
    }

    @Test
    public void should_return_correct_statement_given_customer_has_rent_one_child_movie_for_4_day() {
        Movie childrenMovie = new CHILDRENS("Titanic");
        Rental fourDayRental = new Rental(childrenMovie, 4);
        customer.addRental(fourDayRental);

        String statement = customer.statement();

        assertEquals("Rental Record for Carol\n" +
                "\t" + childrenMovie.getTitle() + "\t3.0\n" +
                "Amount owed is 3.0\n" +
                "You earned 1.0 frequent renter points", statement);
    }

    @Test
    public void should_return_correct_html_statement_given_customer_has_rent_one_child_movie_for_4_day() {
        Movie childrenMovie = new CHILDRENS("Titanic");
        Rental fourDayRental = new Rental(childrenMovie, 4);
        customer.addRental(fourDayRental);

        String statement = customer.htmlStatement();

        System.out.println(statement);

        assertEquals("<H1>Rentals for <EM>Carol</EM></H1><P>\n" +
                "Titanic: 3.0<BR>\n" +
                "<P>You owe<EM>3.0</EM><P>\n" +
                "On this rental you earned <EM>1.0</EM> frequent renter points<P>", statement);
    }


    @Test
    public void should_return_correct_html_statement_given_customer_has_rent_one_art_movie_for_4_day() {
        Movie artMovie = new ART("Titanic");
        Rental fourDayRental = new Rental(artMovie,4);
        customer.addRental(fourDayRental);

        String statement = customer.htmlStatement();

        System.out.println(statement);

        assertEquals("<H1>Rentals for <EM>Carol</EM></H1><P>\n" +
                "Titanic: 24.0<BR>\n" +
                "<P>You owe<EM>24.0</EM><P>\n" +
                "On this rental you earned <EM>1.5</EM> frequent renter points<P>", statement);
    }



}
