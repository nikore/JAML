package org.jmal.tags;

import com.google.common.base.Joiner;
import com.google.common.collect.Sets;
import org.apache.commons.lang.StringUtils;
import org.jmal.tags.util.Bag;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Tag implements Renderable {
    private String name;
    private Bag<String, Attribute> attributes;
    private List<Renderable> children;

    private static Set<String> selfClosers = Sets.newHashSet(
            "br", "img", "div", "span", "input", "col", "hr", "link", "meta", "base", "param", "area"
    );

    public Tag(String name) {
        this.name = name;
        this.attributes = new Bag<String, Attribute>();
        this.children = new LinkedList<Renderable>();
    }

    public Tag(String name, Attribute... attributes) {
        this.name = name;
        this.attributes = new Bag<String, Attribute>();
        for (Attribute attribute : attributes) {
            this.attributes.put(attribute.getName(), attribute);
        }
        this.children = new LinkedList<Renderable>();
    }

    public Tag addAttribute(String name, String value) {
        Attribute attribute = new Attribute(name, value);
        attributes.put(name, attribute);
        return this;
    }
    
    public Tag addAttributes(List<Attribute> attributeList) {
        for (Attribute attribute : attributeList) {
            this.attributes.put(attribute.getName(), attribute);
        }
        return this;
    }
    
    public Tag addAttributes(Attribute... attributeList) {
        for (Attribute attribute : attributeList) {
            this.attributes.put(attribute.getName(), attribute);
        }
        return this;
    }

    public Tag append(Renderable... children) {
        this.children.addAll(Arrays.asList(children));
        return this;
    }

    public Tag append(List<? extends Renderable> children) {
        this.children.addAll(children);
        return this;
    }

    public Tag append(String text) {
        children.add(new Text(text));
        return this;
    }

    public Tag addCss(CssClass... cssClasses) {
        if (cssClasses.length != 0) {
            Attribute attribute = new Attribute("class", Joiner.on(" ").join(cssClasses));
            attributes.put(attribute.getName(), attribute);
        }

        return this;
    }

    public Tag addCss(String cssClass) {
        if (cssClass.length() != 0) {
            Attribute attribute = new Attribute("class", cssClass);
            attributes.put(attribute.getName(), attribute);
        }
        return this;
    }

    public List<Attribute> getAttributes(String key) {
        return attributes.getValues(key);
    }

    public List<Renderable> getChildren() {
        return this.children;
    }

    public String renderString() {
        StringWriter writer = new StringWriter();
        render(new PrintWriter(writer));
        return writer.toString();
    }

    public void render(PrintWriter pw) {
        if (StringUtils.isBlank(name)) {
            return;
        }
        pw.print("<");
        pw.print(name);

        if (attributes.size() != 0 || children.size() == 0) {
            pw.print(" ");
        }

        pw.print(Joiner.on(" ").join(attributes.values()));

        if (children.size() != 0) {
            pw.print(">\n");
            for (Renderable child : children) {
                child.render(pw);
            }
            pw.print("</" + name + ">\n");
            return;
        }

        if (attributes.size() != 0) {
            pw.print(" ");
        }

        if(selfClosers.toString().contains(name)){
            pw.print("/>");
        } else {
            pw.print("></" + name + ">");
        }
    }
}