package com.jpragma;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;

@Controller("/test")
public class MyController {

    private final CalcService calcService;
    private final ReportService reportService;

    public MyController(CalcService calcService, ReportService reportService) {
        this.calcService = calcService;
        this.reportService = reportService;
    }

    @Get("/calc")
    public int getSumOf2and3() {
        return calcService.calcSum(2, 3);
    }

    @Get("/report")
    public String getReport() {
        return reportService.createReport();
    }

}
