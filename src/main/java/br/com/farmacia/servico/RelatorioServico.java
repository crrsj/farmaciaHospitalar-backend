package br.com.farmacia.servico;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import br.com.farmacia.dto.BuscarComandaDTO;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@Service
public class RelatorioServico {
	
	
	  public byte[] gerarRelatorio(List<BuscarComandaDTO> comandas) throws Exception {
	        // Corrigir o nome do arquivo .jrxml
	        InputStream templateStream = new ClassPathResource("relatorio.jrxml").getInputStream();

	        JasperReport report = JasperCompileManager.compileReport(templateStream);

	        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(comandas);

	        HashMap<String, Object> parametros = new HashMap<>();
	        parametros.put("titulo", "Relatório de Comandas");

	        JasperPrint print = JasperFillManager.fillReport(report, parametros, dataSource);

	        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
	        JasperExportManager.exportReportToPdfStream(print, outputStream);

	        return outputStream.toByteArray();
	    }
/*
	public byte[] gerarRelatorio(List<BuscarComandaDTO> comandas) throws Exception {
        InputStream templateStream = new ClassPathResource("relatorio.jrxml").getInputStream();

        JasperReport report = JasperCompileManager.compileReport(templateStream);

        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(comandas);

        HashMap<String, Object> parametros = new HashMap<>();
        parametros.put("titulo", "Relatório de Comandas");

        JasperPrint print = JasperFillManager.fillReport(report, parametros, dataSource);

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        JasperExportManager.exportReportToPdfStream(print, outputStream);

        return outputStream.toByteArray();
    }
    */
}
