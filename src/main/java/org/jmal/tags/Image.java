package org.jmal.tags;

import java.io.PrintWriter;
import java.io.StringWriter;

import static org.jmal.tags.Html.attr;
import static org.jmal.tags.Html.img;

public class Image implements Renderable {
    private Tag img;

    public Image(Attribute... attributes) {
        img = img(attributes);
    }

    public Image(String src) {
        this(attr("src", src));
    }

    public Image(String src, Attribute... attributes) {
        this(attr("src", src));
        for (Attribute attribute : attributes) {
            img.addAttribute(attribute.getName(), attribute.getValue());
        }
    }

    public Image(String src, CssClass cssClass, Attribute... attributes) {
        this(attr("src", src));
        img.addCss(cssClass);
        for (Attribute attribute : attributes) {
            img.addAttribute(attribute.getName(), attribute.getValue());
        }
    }

    public Image(String src, CssClass cssClass) {
        this(attr("src", src));
        img.addCss(cssClass);
    }

    public Image addCss(CssClass... cssClasses) {
        img.addCss(cssClasses);
        return this;
    }

    @Override
    public void render(PrintWriter printWriter) {
        img.render(printWriter);
    }

    @Override
    public String renderString() {
        StringWriter sw = new StringWriter();
        img.render(new PrintWriter(sw));
        return sw.toString();
    }

}
