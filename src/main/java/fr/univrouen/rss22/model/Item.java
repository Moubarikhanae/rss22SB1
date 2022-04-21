package fr.univrouen.rss22.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

@XmlRootElement(name="item")
@XmlAccessorType(XmlAccessType.NONE)
public class Item implements Serializable {

    @XmlAttribute
    private String guid;

    @XmlAttribute
    private String title;

    @XmlAttribute
    private String published;

    public Item(String guid, String title, String published) {
        this.guid = guid;
        this.title = title;
        this.published = published;
    }

    public Item() {
    }

    @Override
    public String toString() {
        return "Item{" +
                "guid='" + guid + '\'' +
                ", title='" + title + '\'' +
                ", published='" + published + '\'' +
                '}';
    }
}
