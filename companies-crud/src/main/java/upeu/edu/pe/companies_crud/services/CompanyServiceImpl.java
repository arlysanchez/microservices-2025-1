package upeu.edu.pe.companies_crud.services;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import upeu.edu.pe.companies_crud.entities.Category;
import upeu.edu.pe.companies_crud.entities.Company;
import upeu.edu.pe.companies_crud.repository.CompanyRepository;

import java.util.NoSuchElementException;
import java.util.Objects;

@Service
@Transactional
public class CompanyServiceImpl implements CompanyService {

    private final CompanyRepository companyRepository;

    public CompanyServiceImpl(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    @Override
    public Company create(Company company) {
        company.getWebSites().forEach(webSite -> {
            if (Objects.isNull(webSite.getCategory())) {
                webSite.setCategory(Category.NONE);
            }
        });
        return this.companyRepository.save(company);
    }

    @Override
    public Company readByName(String name) {
        return this.companyRepository.findByName(name)
                .orElseThrow(() -> new NoSuchElementException("Company not found"));
    }

    @Override
    public Company update(Company company, String name) {
        var companyToUpdate = this.companyRepository.findByName(name)
                .orElseThrow(() -> new NoSuchElementException("Company not found"));
        companyToUpdate.setLogo(company.getLogo());
        companyToUpdate.setFoundationDate(company.getFoundationDate());
        companyToUpdate.setFounder(company.getFounder());
        return this.companyRepository.save(companyToUpdate);
    }

    @Override
    public void delete(String name) {
        var companyToDelete = this.companyRepository.findByName(name)
                .orElseThrow(() -> new NoSuchElementException("Company not found"));
        this.companyRepository.delete(companyToDelete);
    }
}
