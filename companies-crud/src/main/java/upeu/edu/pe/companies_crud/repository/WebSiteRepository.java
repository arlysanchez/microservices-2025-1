package upeu.edu.pe.companies_crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import upeu.edu.pe.companies_crud.entities.WebSite;

public interface WebSiteRepository  extends JpaRepository<WebSite, Long> {
}
