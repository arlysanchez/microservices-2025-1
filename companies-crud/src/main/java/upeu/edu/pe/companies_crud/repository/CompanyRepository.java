package upeu.edu.pe.companies_crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import upeu.edu.pe.companies_crud.entities.Company;

import java.util.Optional;

public interface CompanyRepository extends JpaRepository<Company, Long> {
Optional<Company> findByName(String name);

}
