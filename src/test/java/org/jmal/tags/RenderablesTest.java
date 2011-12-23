package org.jmal.tags;

import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.ArrayList;

import static junit.framework.Assert.assertEquals;
import static org.jmal.tags.Html.attr;
import static org.jmal.tags.Html.text;

public class RenderablesTest {

    @Test
    public void testRender() throws Exception {
        Renderables renderables = new Renderables();
        renderables.append(text("foo"));
        renderables.append(text(" "));
        renderables.append(text("bar"));
        assertEquals("foo bar", renderables.renderString());
    }

    @Test
    public void testAppendList() throws Exception {
        Renderables renderableAppendsVariableParameters = new Renderables();
        Renderables renderableAppendList = new Renderables();

        ArrayList<Link> renderableList = Lists.newArrayList(new Link(attr("foo", "foo")), new Link(attr("bar", "bar")));
        renderableAppendsVariableParameters.append(new Link(attr("foo", "foo")), new Link(attr("bar", "bar")));
        renderableAppendList.append(renderableList);
        assertEquals(renderableAppendList.renderString(), renderableAppendsVariableParameters.renderString());
    }
}
