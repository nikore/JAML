package org.jmal.tags;

import com.google.common.collect.Lists;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;


public class IncludesTest {
    List<CssInclude> firstCssInclude = Lists.<CssInclude>newArrayList();
    List<JavascriptInclude> firstJSInclude = Lists.<JavascriptInclude>newArrayList();
    Includes includes;

    @Before
    public void setUpIncludes() {
        firstCssInclude.add(new CssInclude("/test.css"));
        firstJSInclude.add(new JavascriptInclude("/test.js"));

        includes = new Includes(firstJSInclude, firstCssInclude);
    }

    @Test
    public void addInFirstIncludes() {
        assertEquals(1, includes.getCss().size());
        assertEquals(1, includes.getJavascript().size());
    }

    @Test
    public void addInMoreIncludes() {
        List<CssInclude> moreCss = Lists.<CssInclude>newArrayList();
        moreCss.add(new CssInclude("/test2.css"));

        includes.merge(Lists.<JavascriptInclude>newArrayList(), moreCss);

        assertEquals(2, includes.getCss().size());
        assertEquals(1, includes.getJavascript().size());
    }

    @Test
    public void addInMoreIncludesViaInclude() {
        List<CssInclude> CssNewInclude = Lists.<CssInclude>newArrayList();
        List<JavascriptInclude> JSNewInclude = Lists.<JavascriptInclude>newArrayList();

        CssNewInclude.add(new CssInclude("/test3.css"));
        JSNewInclude.add(new JavascriptInclude("/test3.js"));

        Includes newIncludes = new Includes(JSNewInclude, CssNewInclude);

        includes.merge(newIncludes);

        assertEquals(2, includes.getCss().size());
        assertEquals(2, includes.getJavascript().size());
    }
}
