package upeu.edu.pe.report_ms.models;


import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;
import java.util.List;


public class Company {

    private Long id;
    private String name;
    private String founder;
    private String logo;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private LocalDate foundationDate;
    private List<WebSite> webSites;

    // Constructor vacío
    public Company() {}

    // Constructor completo
    public Company(Long id, String name, String founder, String logo, LocalDate foundationDate, List<WebSite> webSites) {
        this.id = id;
        this.name = name;
        this.founder = founder;
        this.logo = logo;
        this.foundationDate = foundationDate;
        this.webSites = webSites;
    }

    // Getters y Setters
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

    public String getFounder() {
        return founder;
    }

    public void setFounder(String founder) {
        this.founder = founder;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public LocalDate getFoundationDate() {
        return foundationDate;
    }

    public void setFoundationDate(LocalDate foundationDate) {
        this.foundationDate = foundationDate;
    }

    public List<WebSite> getWebSites() {
        return webSites;
    }

    public void setWebSites(List<WebSite> webSites) {
        this.webSites = webSites;
    }

    // Builder interno
    public static class Builder {
        private Long id;
        private String name;
        private String founder;
        private String logo;
        private LocalDate foundationDate;
        private List<WebSite> webSites;

        public Builder id(Long id) {
            this.id = id;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder founder(String founder) {
            this.founder = founder;
            return this;
        }

        public Builder logo(String logo) {
            this.logo = logo;
            return this;
        }

        public Builder foundationDate(LocalDate foundationDate) {
            this.foundationDate = foundationDate;
            return this;
        }

        public Builder webSites(List<WebSite> webSites) {
            this.webSites = webSites;
            return this;
        }

        public Company build() {
            return new Company(id, name, founder, logo, foundationDate, webSites);
        }
    }

    // Método estático para el builder
    public static Builder builder() {
        return new Builder();
    }
}

