package br.com.farmacia.controle;


import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.farmacia.dto.BuscarComandaDTO;
import br.com.farmacia.dto.CriarComandaDTO;
import br.com.farmacia.servico.ComandaServico;
import br.com.farmacia.servico.RelatorioServico;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/comandas")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class ComandaControle {

	private final ModelMapper modelMapper;
	private final ComandaServico comandaServico;
	private final RelatorioServico relatorioServico;
	
	
	@PostMapping
	public ResponseEntity<CriarComandaDTO>criaComandas(@RequestBody CriarComandaDTO criarComandaDTO){
		var criar = comandaServico.criarComanda(criarComandaDTO);
		var uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(criar.getId()).toUri();
		return ResponseEntity.created(uri).body(new CriarComandaDTO(criar));
   }
	
	@GetMapping("/gerarRelatorio")
    public ResponseEntity<byte[]> gerarRelatorio(@RequestParam("comandaId") Long comandaId) {
    	
    	   try {
    		   // Buscar os dados das comandas através do serviço
               List<BuscarComandaDTO> comandas = comandaServico.buscarComandasPorId(comandaId);
               
               // Gerar o relatório em PDF
               byte[] relatorioPdf = relatorioServico.gerarRelatorio(comandas);

               // Configurar os headers para download do PDF
               HttpHeaders headers = new HttpHeaders();
               headers.add(HttpHeaders.CONTENT_DISPOSITION, "inline; filename=relatorio.pdf");

               // Retornar o PDF gerado como resposta
               return ResponseEntity.ok()
                       .headers(headers)
                       .contentType(MediaType.APPLICATION_PDF)
                       .body(relatorioPdf);

           } catch (Exception e) {
              
               return ResponseEntity.status(500).build();
           }
       }
    
	
	@GetMapping
	public ResponseEntity<List<BuscarComandaDTO>>buscarComanda(){
		var buscar = comandaServico.buscarComandas();
		return ResponseEntity.ok(buscar);
	}
	
	
	@GetMapping("/buscarComanda")
	public ResponseEntity<BuscarComandaDTO>buscarPorCodigoComanda(@RequestParam("codComanda")Integer codComanda){
		var buscar = comandaServico.buscarPorCodigo(codComanda);
		return ResponseEntity.ok(modelMapper.map(buscar, BuscarComandaDTO.class));
		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void>excluirComanda(@PathVariable Long id){
		comandaServico.excluirComanda(id);
		return ResponseEntity.noContent().build();
	}
}