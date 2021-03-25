package plantapp.Entities;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
//@NoArgsConstructor
public class Plant {
    @Id
    @GeneratedValue
    public Long id;
    public String name;

    public Plant() {}
    public Plant(String name) {
        this.name = name;
    }
}
