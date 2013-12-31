package services;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class CalculatorTest {

    private Calculator sut = new Calculator();

    @Test
    public void testAdd() {
        String actual = sut.add(1, 1);
        assertThat(actual, is("2"));
    }

    @Test
    public void testSubtract() throws Exception {
        String actual = sut.subtract(3, 2);
        assertThat(actual, is("1"));
    }
}
