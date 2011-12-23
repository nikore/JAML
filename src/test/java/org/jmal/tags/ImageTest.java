package org.jmal.tags;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static org.jmal.tags.Html.attr;

public class ImageTest {

    public enum testCssClass implements CssClass {
        img;

        @Override
        public String toString() {
            return this.name();
        }
    }


    @Test
    public void testImageAttrabutes() {
        assertEquals("<img src=\"test\" />", new Image(attr("src", "test")).renderString());
    }

    @Test
    public void testImageSrc() {
        assertEquals("<img src=\"test\" />", new Image("test").renderString());
    }

    @Test
    public void testImageSrcCssInclude() {
        assertEquals("<img src=\"test\" class=\"img\" />", new Image("test", testCssClass.img).renderString());
    }

    @Test
    public void testImageSrcAttrabutes() {
        assertEquals("<img src=\"test\" testattr=\"testattr\" />", new Image("test", attr("testattr", "testattr")).renderString());
    }

    @Test
    public void testImageSrcAddCss() {
        assertEquals("<img src=\"test\" class=\"img\" />", new Image("test").addCss(testCssClass.img).renderString());
    }

}
