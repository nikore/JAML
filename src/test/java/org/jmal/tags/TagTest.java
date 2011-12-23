package org.jmal.tags;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class TagTest {
    @Test
    public void testTag() throws Exception {
        assertEquals("<div />", new Tag("div").renderString());
        assertEquals("<p />", new Tag("p").renderString());

    }

    @Test
    public void testAttributes() throws Exception {
        Tag tag = new Tag("div", new Attribute("a", "b"), new Attribute("c", "d"));
        assertEquals("<div a=\"b\" c=\"d\" />", tag.renderString());
    }

    @Test
    public void testAppend() throws Exception {
        Renderable foo = new Text("foo");
        Tag tag = new Tag("div", new Attribute("k", "v"));
        tag.append(foo);
        assertEquals("<div k=\"v\">\nfoo</div>\n", tag.renderString());
        assertEquals("<div>\nhello</div>\n", new Tag("div").append("hello").renderString());
    }
}
