package org.jmal.tags;

import com.google.common.collect.Lists;

import java.io.PrintWriter;
import java.util.List;

import static org.jmal.tags.Html.attr;
import static org.jmal.tags.Html.link;
import static org.jmal.tags.Html.script;

public class Includes implements Renderable{
    private List<JavascriptInclude> javascript;
    private List<CssInclude> css;

    public Includes() {
        this(Lists.<JavascriptInclude>newArrayList(), Lists.<CssInclude>newArrayList());
    }

    public Includes(List<JavascriptInclude> javascript, List<CssInclude> css) {
        this.javascript = javascript;
        this.css = css;
    }

    public void merge(List<JavascriptInclude> javascript, List<CssInclude> css) {
        this.javascript.addAll(javascript);
        this.css.addAll(css);
    }

    public void merge(Includes includes) {
        this.javascript.addAll(includes.getJavascript());
        this.css.addAll(includes.getCss());
    }

    public List<JavascriptInclude> getJavascript() {
        return javascript;
    }

    public List<CssInclude> getCss() {
        return css;
    }

    private Renderable makeRenderableOutput() {
        Renderables output = new Renderables();

        for (JavascriptInclude javascriptInclude : javascript) {
            output.append(script(attr("type", "text/javascript"), attr("src", javascriptInclude.getPath())));
        }

        for (CssInclude cssInclude : css) {
            output.append(link(attr("rel", "stylesheet"), attr("type", "text/css"), attr("href", cssInclude.getPath())));
        }

        return output;
    }


    @Override
    public void render(PrintWriter pw) {
        makeRenderableOutput().render(pw);
    }

    @Override
    public String renderString() {
        return makeRenderableOutput().renderString();
    }
}
