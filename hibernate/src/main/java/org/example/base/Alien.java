package org.example.base;

import jakarta.persistence.*;

import java.util.Collection;

@Entity
@Table(name = "alien_table")
public class Alien {
    @Id
    private int id;
    //    @Transient
    private AlienName name;
//    @Column(name="alien_color")
//    private String color;

    @OneToMany(mappedBy = "alien", fetch = FetchType.EAGER)
    // alien have multiple laptop
    private Collection<Laptop> laptops;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public AlienName getName() {
        return name;
    }

    public void setName(AlienName name) {
        this.name = name;
    }

    public Collection<Laptop> getLaptops() {
        return laptops;
    }

    public void setLaptops(Collection<Laptop> laptops) {
        this.laptops = laptops;
    }

    @Override
    public String  toString() {
        return "Alien{" +
                "id=" + id +
                ", name=" + name +
                ", laptops=" + laptops +
                '}';
    }
}
