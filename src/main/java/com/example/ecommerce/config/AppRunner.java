package com.example.ecommerce.config;

import com.example.ecommerce.service.report.ReportService;
import com.example.ecommerce.service.seeder.DataSeederService;
import lombok.RequiredArgsConstructor;
import org.jspecify.annotations.NonNull;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AppRunner implements CommandLineRunner {

    private final DataSeederService seederService;
    private final ReportService reportService;

    @Override
    public void run(String @NonNull ... args) {
        seederService.seedAll();
        reportService.generateReports();
    }
}