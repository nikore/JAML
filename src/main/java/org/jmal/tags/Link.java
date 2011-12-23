package org.jmal.tags;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Arrays;

import static org.jmal.tags.Html.*;

public class Link implements Renderable {
    private Tag a;

    public Link(Attribute... attributes) {
        a = a(attributes);
    }

    public Link(String href) {
        this(attr("href", href));
    }

    public Link(String href, Attribute... attributes) {
        this(attr("href", href));
        for (Attribute attribute : attributes) {
            a.addAttribute(attribute.getName(), attribute.getValue());
        }
    }

    public Link(String href, CssClass... cssClasses) {
        this(attr("href", href));
        a.addCss(cssClasses);
    }

    public Link addCss(CssClass... cssClasses) {
        a.addCss(cssClasses);
        return this;
    }

    public Link append(Renderable renderable) {
        a.append(renderable);
        return this;
    }

    public Link append(Renderable... children) {
        a.getChildren().addAll(Arrays.asList(children));
        return this;
    }

    public Link append(String text) {
        a.append(text(text));
        return this;
    }

    @Override
    public void render(PrintWriter printWriter) {
        a.render(printWriter);
    }

    @Override
    public String renderString() {
        StringWriter sw = new StringWriter();
        a.render(new PrintWriter(sw));
        return sw.toString();
    }
}
