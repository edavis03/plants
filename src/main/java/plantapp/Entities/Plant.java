package plantapp.Entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Plant {
    @Id
    @GeneratedValue
    public Long id;
    public String name;

    public Plant(String name) {
        this.name = name;
    }
}
