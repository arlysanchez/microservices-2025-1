package upeu.edu.pe.report_ms.services;


import org.springframework.stereotype.Service;
import upeu.edu.pe.report_ms.repositories.CompaniesRepository;

@Service
public class ReportServiceImpl  implements  ReportService{
    private final CompaniesRepository companiesRepository;


    public ReportServiceImpl(CompaniesRepository companiesRepository) {
        this.companiesRepository = companiesRepository;
    }

    @Override
    public String makeReport(String name) {
        return this.companiesRepository.getByName(name).orElseThrow().getName();

    }

    @Override
    public String saveReport(String report) {
        return "";
    }

    @Override
    public void deleteReport(String name) {

    }
}
