package org.jmal.tags;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AttributeTest {
    @Test
    public void testToString() throws Exception {
        assertEquals("k=\"v\"", new Attribute("k", "v").toString());
        assertEquals("k=\"o'reilly\"", new Attribute("k", "o'reilly").toString());
        assertEquals("k=\"this is a &quot;java string &quot;\"", new Attribute("k", "this is a \"java string \"").toString());
    }
}
