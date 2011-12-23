package org.jmal.tags;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static org.jmal.tags.Html.attr;

public class LinkTest {

    public enum testCssClass implements CssClass {
        logo;

        @Override
        public String toString() {
            return this.name();
        }
    }

    @Test
    public void testLinkAttrabutes() {
        assertEquals("<a href=\"test\" />", new Link(attr("href", "test")).renderString());
    }

    @Test
    public void testLinkSrc() {
        assertEquals("<a href=\"test\" />", new Link("test").renderString());
    }

    @Test
    public void testLinkSrcCssInclude() {
        assertEquals("<a href=\"test\" class=\"logo\" />", new Link("test", testCssClass.logo).renderString());
    }

    @Test
    public void testLinkSrcAttrabuites() {
        assertEquals("<a href=\"test\" testattr=\"testattr\" />", new Link("test", attr("testattr", "testattr")).renderString());
    }

    @Test
    public void testLinkHrefAddCss() {
        assertEquals("<a href=\"test\" class=\"logo\" />", new Link("test").addCss(testCssClass.logo).renderString());
    }
}
