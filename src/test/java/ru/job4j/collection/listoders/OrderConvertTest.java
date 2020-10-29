package ru.job4j.collection.listoders;

import org.junit.Test;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import static org.junit.Assert.*;

public class OrderConvertTest {

    @Test
    public void process() {
        List<Order> orders = Arrays.asList(
                new Order("123", "Table"),
                new Order("13f", "toys")
        );
        HashMap<String, Order> result = OrderConvert.process(orders);
        HashMap<String, Order> expected = new HashMap<>();
        expected.put("123", new Order("123", "Table"));
        expected.put("13f", new Order("13f", "toys"));
        assertEquals(expected, result);
    }
}