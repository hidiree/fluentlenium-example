package services;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class CalculatorTest {

    @Test
    public void testAdd() {
        Calculator sut = new Calculator();
        String actual = sut.add(1, 1);
        assertThat(actual, is("2"));
    }

    @Test
    public void testMinus() throws Exception {
        Calculator sut = new Calculator();
        String actual = sut.subtract(3, 2);
        assertThat(actual, is("1"));
    }
}
