package upeu.edu.pe.report_ms.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import upeu.edu.pe.report_ms.services.ReportService;

import java.util.Map;

@RestController
@RequestMapping(path = "report")
public class ReportController {
    private ReportService reportService;

    public ReportController(ReportService reportService) {
        this.reportService = reportService;
    }
    @GetMapping(path = "{name}")
    public ResponseEntity<Map<String, String>> getReport(@PathVariable String name) {
        var response = Map.of("report", this.reportService.makeReport(name));
        return ResponseEntity.ok(response);
    }

    @PostMapping()
    public ResponseEntity<String> postReport(@RequestBody String report) {
        return ResponseEntity.ok(this.reportService.saveReport(report));
    }
    @DeleteMapping(path = "{name}")
    public ResponseEntity<Void> deleteReport(@PathVariable String name) {
        this.reportService.deleteReport(name);
        return ResponseEntity.noContent().build();
    }


}

