package org.jmal.tags;

import java.io.PrintWriter;

public class Html {
    public static Attribute attr(String name, String value) {
        return new Attribute(name, value);
    }

    public static Tag a(Attribute... attributes) {
        return tag("a", attributes);
    }

    public static Tag b(String text, Attribute... attributes) {
        return tag("b", attributes).append(text);
    }

    public static Tag body(Renderable... renderables) {
        return tag("body").append(renderables);
    }

    public static Tag br() {
        return tag("br");
    }

    public static Tag div(Renderable... renderables) {
        return tag("div").append(renderables);
    }

    public static Tag div(String id, CssClass... cssClasses) {
        return tag("div", new Id(id)).addCss(cssClasses);
    }

    public static Tag div(Attribute... attributes) {
        return tag("div", attributes);
    }

    public static Tag div(CssClass... cssClasses) {
        return tag("div").addCss(cssClasses);
    }

    public static Tag form(Attribute... attributes) {
        return tag("form", attributes);
    }

    public static Tag h1(String text) {
        return tag("h1").append(text);
    }

    public static Tag h2(String text) {
        return tag("h2").append(text);
    }

    public static Tag h3(String text) {
        return tag("h3").append(text);
    }

    public static Tag h3(Renderable renderable) {
        return tag("h3").append(renderable);
    }

    public static Tag h4(String text) {
        return tag("h4").append(text);
    }

    public static Tag head(Renderable... renderables) {
        return tag("head").append(renderables);
    }

    public static Tag html(Renderable... renderables) {
        return tag("html").append(renderables);
    }

    public static Tag meta(Attribute... attributes) {
        return tag("meta", attributes);
    }

    public static Tag img(Attribute... attributes) {
        return tag("img", attributes);
    }

    public static Tag img(String src) {
        return tag("img", attr("src", src));
    }

    public static Tag input(Attribute... attributes) {
        return tag("input", attributes);
    }

    public static Tag input(CssClass cssClass, Attribute... attributes) {
        return tag("input", attributes).addCss(cssClass);
    }

    public static Tag input(String name, Attribute... attributes) {
        return tag("input").addAttribute("id", name).addAttribute("name", name);
    }

    public static Tag label(String name, Attribute... attributes) {
        return tag("label").addAttribute("id", name);
    }

    public static Tag li(Attribute... attributes) {
        return tag("li", attributes);
    }

    public static Tag link(Attribute... attributes) {
        return tag("link", attributes);
    }

    public static Renderable nbsp() {
        return new RawHtml("&nbsp;");
    }

    public static Tag option(Attribute... attributes) {
        return tag("option", attributes);
    }

    public static Tag p(Renderable... renderables) {
        return tag("p").append(renderables);
    }

    public static Tag p(Attribute... attributes) {
        return tag("p", attributes);
    }

    public static Tag pre(Attribute... attributes) {
        return tag("pre", attributes);
    }

    public static Script script(Attribute... attributes) {
        return new Script(attributes);
    }

    public static final class Script extends Tag {
        public Script(Attribute... attributes) {
            super("script", attributes);
        }

        public Script appendScriptText(String scriptText) {
            append(raw(scriptText));
            return this;
        }
    }


    public static Tag select(Attribute... attributes) {
        return tag("select", attributes);
    }

    public static Tag span(CssClass cssClass, Attribute... attributes) {
        return tag("span", attributes).addCss(cssClass);
    }

    public static Tag span(Attribute... attributes) {
        return tag("span", attributes);
    }

    public static Tag table(Attribute... attributes) {
        return tag("table", attributes);
    }

    public static Tag td(Attribute... attributes) {
        return tag("td", attributes);
    }

    public static Tag th(Attribute... attributes) {
        return tag("th", attributes);
    }

    public static Tag tr(Attribute... attributes) {
        return tag("tr", attributes);
    }

    public static Tag textarea(Attribute... attributes) {
        return tag("textarea", attributes);
    }

    public static Tag textarea(CssClass cssClass, Attribute... attributes) {
        return tag("textarea", attributes).addCss(cssClass);
    }

    public static Renderable text(String text) {
        return new Text(text);
    }

    public static Tag title(String contents) {
        return tag("title").append(text(contents));
    }

    public static Tag ul(Attribute... attributes) {
        return tag("ul", attributes);
    }

    private static Tag tag(String name, Attribute... attributes) {
        return new Tag(name, attributes);
    }

    public static JavascriptInclude js(String path) {
        return new JavascriptInclude(path);
    }

    public static CssInclude css(String path) {
        return new CssInclude(path);
    }

    protected static Renderable raw(String raw) {
        return new RawHtml(raw);
    }

    private static final class RawHtml implements Renderable {
        private String raw;

        public RawHtml(String raw) {
            this.raw = raw;
        }

        @Override
        public void render(PrintWriter pw) {
            pw.print(raw);
        }

        @Override
        public String renderString() {
            return raw;
        }
    }
}
