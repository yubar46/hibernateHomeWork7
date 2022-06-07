package domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = ProductType.TABLE_NAME)
public class ProductType {
    public static final String TABLE_NAME = "product_types";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true)
    private int id;


    @Column(nullable = false)
    private String name;

    @OneToMany(fetch = FetchType.LAZY)
    private Set<Attribute> attributes = new HashSet<Attribute>();

    public ProductType() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Set<Attribute> getAttributes() {
        return attributes;
    }

    public void setAttributes(Set<Attribute> attributes) {
        this.attributes = attributes;
    }

}
