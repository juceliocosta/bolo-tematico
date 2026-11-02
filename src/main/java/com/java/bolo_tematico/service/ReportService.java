package com.java.bolo_tematico.service;

import com.java.bolo_tematico.model.Bolo;
import com.java.bolo_tematico.repository.BoloRepository;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.util.JRLoader;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ReportService {

    private final BoloRepository boloRepo;

    public ReportService(BoloRepository boloRepo) {
        this.boloRepo = boloRepo;
    }

    public byte[] generateReport() {
        try {
            List<Bolo> bolos = boloRepo.findAll();

            // Converte a lista em um JRBeanCollectionDataSource
            JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(bolos);

            // Carrega o arquivo jasper
            InputStream reportStream = getClass()
                    .getResourceAsStream("/reports/encomendas.jasper");

            if (reportStream == null) {
                throw new IllegalArgumentException("Relatório não encontrado em /reports/encomendas.jasper");
            }

            JasperReport reporte = (JasperReport) JRLoader.loadObject(reportStream);

            // Parâmetros do relatório, se houver
            Map<String, Object> params = new HashMap<>();

            JasperPrint print = JasperFillManager.fillReport(reporte, params, dataSource);

            return JasperExportManager.exportReportToPdf(print);

        } catch (Exception e) {
            throw new RuntimeException("Erro ao gerar relatório", e);
        }
    }
}