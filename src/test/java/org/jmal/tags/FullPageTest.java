package org.jmal.tags;

import com.google.common.collect.Lists;
import org.junit.Test;
import static junit.framework.Assert.assertEquals;

import java.util.List;

import static org.jmal.tags.Html.*;

public class FullPageTest {

    public enum testCssClass implements CssClass {
        logo;

        @Override
        public String toString() {
            return this.name();
        }
    }

    @Test
    public void testNewFeatures() {
        
        String page = "<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Strict//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd\">\n" +
                "<html xmlns=\"http://www.w3.org/1999/xhtml\" xml:lang=\"en-gb\" lang=\"en-gb\">\n" +
                "<head>\n" +
                "<title>\n" +
                "Test Page</title>\n" +
                "<script type=\"text/javascript\" src=\"/test.js\" ></script><link rel=\"stylesheet\" type=\"text/css\" href=\"/test.css\" /></head>\n" +
                "<body>\n" +
                "<div>\n" +
                "test<br />test2</div>\n" +
                "</body>\n" +
                "</html>\n";

        List<CssInclude> firstCssInclude = Lists.<CssInclude>newArrayList();
        List<JavascriptInclude> firstJSInclude = Lists.<JavascriptInclude>newArrayList();

        firstCssInclude.add(new CssInclude("/test.css"));
        firstJSInclude.add(new JavascriptInclude("/test.js"));

        List<Attribute> attributeList = Lists.<Attribute>newArrayList();

        attributeList.add(new Attribute("xmlns", "http://www.w3.org/1999/xhtml"));
        attributeList.add(new Attribute("xml:lang","en-gb"));
        attributeList.add(new Attribute("lang", "en-gb"));

        String test = new Renderables(
                DocType.XHTML_10_STRICT,
                html(
                        head(title("Test Page"),
                            new Includes(firstJSInclude, firstCssInclude)
                        ),
                        body(
                                div(
                                        text("test"),
                                        br(),
                                        text("test2")
                                )
                        )
                ).addAttributes(attributeList)
        ).renderString();

        assertEquals(page, test);
    }
}
