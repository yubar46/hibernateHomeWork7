package domain;

import javax.persistence.*;

@Entity
@Table(name =Attribute.TABLE_NAME)
public class Attribute {
    public static final String TABLE_NAME = "attributes";
    @Id
    @Column(unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;


    public Attribute(String title ) {
        this.title = title;

    }

    public Attribute() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public static String getTableName() {
        return TABLE_NAME;
    }


}

