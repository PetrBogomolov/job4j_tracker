package ru.job4j.collection.listoders;

import org.junit.Test;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

public class OrderConvertTest {

    @Test
    public void process() {
        List<Order> orders = List.of(
                new Order("123", "Table"),
                new Order("13f", "toys")
        );
        HashMap<String, Order> result = OrderConvert.process(orders);
        Map<String, Order> expected = Map.of(
        "123", new Order("123", "Table"),
        "13f", new Order("13f", "toys")
        );
        assertEquals(expected, result);
    }
}