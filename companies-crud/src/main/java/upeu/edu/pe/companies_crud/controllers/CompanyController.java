package upeu.edu.pe.companies_crud.controllers;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import upeu.edu.pe.companies_crud.entities.Company;
import upeu.edu.pe.companies_crud.services.CompanyService;

import java.net.URI;

@RestController
@RequestMapping(path = "company")
@Tag(name = "Companies resource")
public class CompanyController {
    private final CompanyService companyService;
    private final Logger log = LoggerFactory.getLogger(CompanyController.class);

    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @Operation(summary = "get a company given a company name")
    @GetMapping(path = "{name}")
    public ResponseEntity<Company> get(@PathVariable String name) {
        //probar circuit breaker
      /*  try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } */
        log.info("GET: company {}", name);
        return ResponseEntity.ok(this.companyService.readByName(name));
    }

   @Operation(summary = "save in DB a company given a company from body")
    @PostMapping
    public ResponseEntity<Company> post(@RequestBody Company company) {
        log.info("Post: company {}", company.getName());
        return ResponseEntity.created(
                        URI.create(this.companyService.create(company).getName()))
                .build();
    }
 @Operation(summary = "update in DB a company given a company from body")
    @PutMapping(path = "{name}")
    public ResponseEntity<Company> put(@RequestBody Company company,
                                       @PathVariable String name) {
        log.info("PUT: company {}", name);
        return ResponseEntity.ok(this.companyService.update(company, name));
    }

   @Operation(summary = "delete in DB a company given a company name")
    @DeleteMapping(path = "{name}")
    public ResponseEntity<?> delete(@PathVariable String name) { //<?> esto es un comodin regresa distintos objetos, pueden ser un objeto string, company
        log.info("DELETE: company {}", name);
        this.companyService.delete(name);
        return ResponseEntity.noContent().build();
    }


}
