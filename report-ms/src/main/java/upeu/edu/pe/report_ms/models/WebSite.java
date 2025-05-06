package upeu.edu.pe.report_ms.models;



import java.io.Serializable;


public class WebSite implements Serializable {

    private String name;

    public WebSite() {
    }

    public WebSite(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    // Builder interno
    public static class Builder {
        private String name;



        public Builder name(String name) {
            this.name = name;
            return this;
        }
       public WebSite build() {
            return new WebSite(name);
        }
    }

    // Método estático para el builder
    public static Builder builder() {
        return new Builder();
    }
}
