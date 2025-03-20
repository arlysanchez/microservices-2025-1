package upeu.edu.pe.companies_crud.entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "web_site")
public class WebSite implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    //@Column(columnDefinition ="category")
    @Enumerated(value = EnumType.STRING)
    private Category category;
    private String description;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "WebSite{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", category=" + category +
                ", description='" + description + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        WebSite webSite = (WebSite) o;
        return Objects.equals(id, webSite.id) && Objects.equals(name, webSite.name) && category == webSite.category && Objects.equals(description, webSite.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, category, description);
    }
}
