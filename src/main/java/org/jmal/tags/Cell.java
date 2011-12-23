package org.jmal.tags;

import com.google.common.collect.Lists;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.LinkedList;
import java.util.List;

import static org.jmal.tags.Html.*;

public class Cell implements Renderable {
    private Tag container;

    public Cell(CssClass cssClass) {
        this(1, 1);
        container.addCss(cssClass);
    }

    public Cell(Attribute... attributes) {
        this(1, 1, attributes);
    }

    public Cell(int colspan, Attribute... attributes) {
        this(colspan, 1, attributes);
    }

    public Cell(int colspan, int rowspan, Attribute... attributes) {
        this(td(), colspan, rowspan, attributes);
    }

    protected Cell(Tag container, int colspan, int rowspan, Attribute... attributes) {
        this.container = container;

        List<Attribute> list = new LinkedList<Attribute>();
        list.addAll(Lists.newArrayList(attributes));

        if (colspan > 1) {
            list.add(attr("colspan", Integer.toString(colspan)));
        }

        if (rowspan > 1) {
            list.add(attr("rowspan", Integer.toString(rowspan)));
        }

        for (Attribute attribute : list) {
            this.container.addAttribute(attribute.getName(), attribute.getValue());
        }
    }

    public final Cell append(Renderable renderable) {
        container.append(renderable);
        return this;
    }

    public final Cell append(String text) {
        container.append(text(text));
        return this;
    }

    public final Cell addCss(CssClass... cssClasses) {
        container.addCss(cssClasses);
        return this;
    }

    public final Cell addCss(String cssClass) {
        container.addCss(cssClass);
        return this;
    }

    public final void render(PrintWriter pw) {
        container.render(pw);
    }

    @Override
    public String renderString() {
        StringWriter sw = new StringWriter();
        container.render(new PrintWriter(sw));
        return sw.toString();
    }
}