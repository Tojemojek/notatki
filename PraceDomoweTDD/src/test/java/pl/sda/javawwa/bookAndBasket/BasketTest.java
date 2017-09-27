package pl.sda.javawwa.bookAndBasket;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class BasketTest {

    Basket basket;


    @Before
    public void setUp() throws Exception {

        basket = new Basket();
        basket.addToBasket(new Book("Author1", "Title1", 15.25));
        basket.addToBasket(new Book("Author2", "Title2", 11.25));
        basket.addToBasket(new Book("Author3", "Title3", 13d));

    }


    @Test
    public void clearBasket() {

        assertThat(basket.getSetOfBooksInBasket())
                .hasSize(3)
                .contains(new Book("Author1", "Title1", 15.25))
                .doesNotContain(new Book("Author1", "Title1", 15.35));

        basket.clearBasket();

        assertThat(basket.getSetOfBooksInBasket())
                .hasSize(0);
    }

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void addToBasket() {

        basket.addToBasket(new Book("Author4", "Title4", 19.10));

        assertThat(basket.getSetOfBooksInBasket())
                .hasSize(4)
                .contains(new Book("Author4", "Title4", 19.10));

        basket.addToBasket(new Book("Author4", "Title4", 19.10));

        assertThat(basket.getSetOfBooksInBasket())
                .hasSize(4);

        boolean shouldBeFalse = basket.addToBasket(null);
        assertThat(shouldBeFalse).isFalse();

        assertThat(basket.getMyBasket().get(new Book("Author4", "Title4", 19.10)))
                .isEqualTo(2);

    }


    @Test
    public void removeFromBasket() {

        boolean shouldBeFalse = basket.removeFromBasket(new Book("Author4", "Title4", 19.10));

        assertThat(shouldBeFalse).isFalse();

       basket.removeFromBasket(new Book("Author1", "Title1", 15.25));

        assertThat(basket.getSetOfBooksInBasket())
                .hasSize(2)
                .doesNotContain(new Book("Author4", "Title4", 19.10))
                .doesNotContain(new Book("Author1", "Title1", 15.25));


    }

    @Test
    public void testTotalValueInBasket() throws Exception {


        assertThat(basket.totalValueInBasket()).isEqualTo(1*15.25+1*11.25+1*13);

        basket.addToBasket(new Book("Author3", "Title3", 13d));

        assertThat(basket.totalValueInBasket()).isEqualTo(1*15.25+1*11.25+2*13);

        basket.addToBasket(new Book("Author3", "Title3", 189.25));

        assertThat(basket.totalValueInBasket()).isEqualTo(1*15.25+1*11.25+2*13+189.25);

    }



    @After
    public void tearDown() throws Exception {
    }

}