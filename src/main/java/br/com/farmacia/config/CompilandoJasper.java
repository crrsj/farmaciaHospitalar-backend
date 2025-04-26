package br.com.farmacia.config;

import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import net.sf.jasperreports.engine.JasperCompileManager;

//@Component
public class CompilandoJasper {
	@PostConstruct
    public void compilarRelatorio() {
        try {
            String caminhoJrxml = "src/main/resources/relatorio.jrxml";
            JasperCompileManager.compileReportToFile(caminhoJrxml);
            System.out.println("Relatório compilado com sucesso!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
