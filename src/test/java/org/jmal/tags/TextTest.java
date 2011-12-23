package org.jmal.tags;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class TextTest {
    @Test
    public void testText() throws Exception {
        assertEquals("&lt;hello world!&gt;", new Text("<hello world!>").renderString());
    }

    @Test
    public void testNullText() throws Exception {
        assertEquals("", new Text(null).renderString());
    }

    @Test
    public void testSpaceOnly() throws Exception {
        assertEquals(" ", new Text(" ").renderString());
    }
}
