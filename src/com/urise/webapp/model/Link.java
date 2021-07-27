package com.urise.webapp.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import java.io.Serializable;
import java.util.Objects;

@XmlAccessorType(XmlAccessType.FIELD)
public class Link implements Serializable {
    private static final long serialVersionUID = 1L;

    private String name;

    private String url;

    public Link() {
    }

    public Link(String name, String url) {
        Objects.requireNonNull(name, " name must not be null");
        this.name = name;
        this.url = (url == null) ? "" : url;
    }

    public String getName() {
        return name;
    }

    public String getUrl() {
        return url;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Link link = (Link) o;

        if (getName() != null ? !getName().equals(link.getName()) : link.getName() != null) return false;
        return getUrl() != null ? getUrl().equals(link.getUrl()) : link.getUrl() == null;
    }

    @Override
    public int hashCode() {
        int result = getName() != null ? getName().hashCode() : 0;
        result = 31 * result + (getUrl() != null ? getUrl().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Link(" + name + ", " + url + ')';
    }
}
