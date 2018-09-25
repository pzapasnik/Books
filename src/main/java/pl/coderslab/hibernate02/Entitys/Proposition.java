package pl.coderslab.hibernate02.Entitys;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "propositions")
public class Proposition {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @NotNull
    private String title;

    @NotNull
    private String description;

    public Proposition() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
