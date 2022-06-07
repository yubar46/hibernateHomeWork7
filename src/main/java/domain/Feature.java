package domain;

import javax.persistence.*;

@Entity
@Table(name = Feature.TABLE_NAME)
public class Feature {
    public static final String TABLE_NAME = "features";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true)
    private int id;
    private String value;


    @ManyToOne
    private Attribute attribute;

    public Feature(String value, Attribute attribute) {
        this.value = value;

        this.attribute = attribute;

    }

    public Feature() {

    }


    public String getValue() {
        return value;
    }

    public void setValue(String featureValue) {
        this.value = featureValue;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public Attribute getAttribute() {
        return attribute;
    }

    public void setAttribute(Attribute attribute) {
        this.attribute = attribute;
    }
}
