package org.jmal.tags.utils;

import org.jmal.tags.util.Bag;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.Assert.assertEquals;

public class BagTest {

    @Test
    public void testBasic() throws Exception {
        Bag<String, String> testBag = new Bag<String, String>();
        testBag.put("test", "first item");
        testBag.put("test", "second item");
        testBag.put("test", "third item");
        assertEquals("first item", testBag.get("test"));
        assertEquals(3, testBag.getValues("test").size());
        assertEquals("first item", testBag.getValues("test").get(0));
        assertEquals("second item", testBag.getValues("test").get(1));
        assertEquals("third item", testBag.getValues("test").get(2));
        assertEquals(null, testBag.get("ishouldreturnnull"));
        assertEquals(0, testBag.getValues("ishouldreturnnull").size());

    }

    @Test
    public void testPutAll() throws Exception {
        List<String> values = new ArrayList<String>();
        values.add("one");
        values.add("two");
        values.add("three");

        Bag<String, String> bag = new Bag<String, String>();
        bag.put("test", values);

        assertEquals(3, bag.getValues("test").size());
        assertEquals("one", bag.getValues("test").get(0));
        assertEquals("two", bag.getValues("test").get(1));
        assertEquals("three", bag.getValues("test").get(2));
    }

    @Test
    public void testBoundedBag() throws Exception {
        Bag<String, String> testBag = new Bag<String, String>(2);
        testBag.put("one", "first item");
        testBag.put("two", "second item");
        testBag.put("three", "third item");

        assertEquals(null, testBag.get("one"));
        assertEquals("second item", testBag.get("two"));
        assertEquals("third item", testBag.get("three"));
        testBag.put("four", "forth item");
        assertEquals(null, testBag.get("two"));
    }
}
