package org.jmal.tags;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static org.jmal.tags.Html.a;

public class UnescapedAttributeTest {
    @Test
    public void testRender() throws Exception {
        Tag tag = a(new UnescapedAttribute("href", "hello?foo=bar&panda=bafoon")).append("link");
        String result = tag.renderString();
        assertEquals("<a href=\"hello?foo=bar&panda=bafoon\">\nlink</a>\n", result);
    }
}
