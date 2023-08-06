import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.*;

class AviaSoulsTest {

    @Test
    public void testSortTicketsByPrice() {

        AviaSouls manager = new AviaSouls();


        Ticket ticket1 = new Ticket("MSK", "SPB", 2_000, 12, 14);
        Ticket ticket2 = new Ticket("UFA", "SPB", 12_000, 3, 8);
        Ticket ticket3 = new Ticket("MSK", "SPB", 8_000, 10, 16);
        Ticket ticket4 = new Ticket("SPB", "MSK", 5_000, 9, 12);
        Ticket ticket5 = new Ticket("MSK", "SPB", 7_000, 5, 8);
        Ticket ticket6 = new Ticket("NEW", "LA", 30_000, 13, 22);
        Ticket ticket7 = new Ticket("MSK", "SPB", 50_000, 6, 23);
        Ticket ticket8 = new Ticket("MSK", "SPB", 27_000, 9, 14);

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);

        Ticket[] expected = {ticket1, ticket5, ticket3, ticket8, ticket7};
        Ticket[] actual = manager.search("MSK", "SPB");

        Assertions.assertArrayEquals(expected, actual);
    }
    @Test
    public void testSortTicketsByPriceNotFound() {

        AviaSouls manager = new AviaSouls();


        Ticket ticket1 = new Ticket("MSK", "SPB", 2_000, 12, 14);
        Ticket ticket2 = new Ticket("UFA", "SPB", 12_000, 3, 8);
        Ticket ticket3 = new Ticket("MSK", "SPB", 8_000, 10, 16);
        Ticket ticket4 = new Ticket("SPB", "MSK", 5_000, 9, 12);
        Ticket ticket5 = new Ticket("MSK", "SPB", 7_000, 5, 8);
        Ticket ticket6 = new Ticket("NEW", "LA", 30_000, 13, 22);
        Ticket ticket7 = new Ticket("MSK", "SPB", 50_000, 6, 23);
        Ticket ticket8 = new Ticket("MSK", "SPB", 27_000, 9, 14);

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);

        Ticket[] expected = {};
        Ticket[] actual = manager.search("NEW", "SPB");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testSortTicketsByPriceFoundOne() {

        AviaSouls manager = new AviaSouls();


        Ticket ticket1 = new Ticket("MSK", "SPB", 2_000, 12, 14);
        Ticket ticket2 = new Ticket("UFA", "SPB", 12_000, 3, 8);
        Ticket ticket3 = new Ticket("MSK", "SPB", 8_000, 10, 16);
        Ticket ticket4 = new Ticket("SPB", "MSK", 5_000, 9, 12);
        Ticket ticket5 = new Ticket("MSK", "SPB", 7_000, 5, 8);
        Ticket ticket6 = new Ticket("NEW", "LA", 30_000, 13, 22);
        Ticket ticket7 = new Ticket("MSK", "SPB", 50_000, 6, 23);
        Ticket ticket8 = new Ticket("MSK", "SPB", 27_000, 9, 14);

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);

        Ticket[] expected = {ticket6};
        Ticket[] actual = manager.search("NEW", "LA");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testSortTicketsTimeFlyWithComparator() {

        AviaSouls manager = new AviaSouls();


        Ticket ticket1 = new Ticket("MSK", "SPB", 2_000, 12, 14); //2
        Ticket ticket2 = new Ticket("UFA", "SPB", 12_000, 3, 8);
        Ticket ticket3 = new Ticket("MSK", "SPB", 8_000, 10, 16);  //6
        Ticket ticket4 = new Ticket("SPB", "MSK", 5_000, 9, 12);
        Ticket ticket5 = new Ticket("MSK", "SPB", 7_000, 5, 8);   //3
        Ticket ticket6 = new Ticket("NEW", "LA", 30_000, 13, 22);
        Ticket ticket7 = new Ticket("MSK", "SPB", 50_000, 6, 23);  //17
        Ticket ticket8 = new Ticket("MSK", "SPB", 27_000, 9, 14);  //5

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);

        Comparator<Ticket> comparator = new TicketTimeComparator();

        Ticket[] expected = {ticket1, ticket5, ticket8, ticket3, ticket7};
        Ticket[] actual = manager.search("MSK", "SPB", comparator);

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testSortTicketsTimeFlyWithComparatorNotFound() {

        AviaSouls manager = new AviaSouls();


        Ticket ticket1 = new Ticket("MSK", "SPB", 2_000, 12, 14); //2
        Ticket ticket2 = new Ticket("UFA", "SPB", 12_000, 3, 8);
        Ticket ticket3 = new Ticket("MSK", "SPB", 8_000, 10, 16);  //6
        Ticket ticket4 = new Ticket("SPB", "MSK", 5_000, 9, 12);
        Ticket ticket5 = new Ticket("MSK", "SPB", 7_000, 5, 8);   //3
        Ticket ticket6 = new Ticket("NEW", "LA", 30_000, 13, 22);
        Ticket ticket7 = new Ticket("MSK", "SPB", 50_000, 6, 23);  //17
        Ticket ticket8 = new Ticket("MSK", "SPB", 27_000, 9, 14);  //5

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);

        Comparator<Ticket> comparator = new TicketTimeComparator();

        Ticket[] expected = {};
        Ticket[] actual = manager.search("NEW", "SPB", comparator);

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testSortTicketsTimeFlyWithComparatorFoundOne() {

        AviaSouls manager = new AviaSouls();


        Ticket ticket1 = new Ticket("MSK", "SPB", 2_000, 12, 14); //2
        Ticket ticket2 = new Ticket("UFA", "SPB", 12_000, 3, 8);
        Ticket ticket3 = new Ticket("MSK", "SPB", 8_000, 10, 16);  //6
        Ticket ticket4 = new Ticket("SPB", "MSK", 5_000, 9, 12);
        Ticket ticket5 = new Ticket("MSK", "SPB", 7_000, 5, 8);   //3
        Ticket ticket6 = new Ticket("NEW", "LA", 30_000, 13, 22);
        Ticket ticket7 = new Ticket("MSK", "SPB", 50_000, 6, 23);  //17
        Ticket ticket8 = new Ticket("MSK", "SPB", 27_000, 9, 14);  //5

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);

        Comparator<Ticket> comparator = new TicketTimeComparator();

        Ticket[] expected = {ticket6};
        Ticket[] actual = manager.search("NEW", "LA", comparator);

        Assertions.assertArrayEquals(expected, actual);
    }

}