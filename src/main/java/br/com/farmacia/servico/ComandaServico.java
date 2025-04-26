package br.com.farmacia.servico;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import br.com.farmacia.dto.BuscarComandaDTO;
import br.com.farmacia.dto.CriarComandaDTO;
import br.com.farmacia.entidade.Comanda;
import br.com.farmacia.repositorio.ComandaRepostorio;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ComandaServico {
	private final ModelMapper modelMapper;
	private final ComandaRepostorio comandaRepostorio;
	
	public Comanda criarComanda(CriarComandaDTO criarComandaDTO) { 
		  var criar = new Comanda(criarComandaDTO);
		  
		  if (criar.getMedicamentos() != null) {
			    criar.getMedicamentos().forEach(med -> med.setComanda(criar));
			}

			
			if (criar.getMateriais() != null) {
			    criar.getMateriais().forEach(mat -> mat.setComanda(criar));
			}

		 return comandaRepostorio.save(criar);
		 
	}	
	
	public Comanda buscarPorCodigo(Integer codComanda) {
		return comandaRepostorio.findByCodComanda(codComanda);
	}
	
	
	public List<BuscarComandaDTO>buscarComandas(){
		return comandaRepostorio.findAll().stream()
				.map(listar -> modelMapper.map(listar, BuscarComandaDTO.class))
				.collect(Collectors.toList());
	}
	
	public List<BuscarComandaDTO> buscarComandasPorId(Long comandaId) {
		Optional<Comanda>comandas = comandaRepostorio.findById(comandaId);
		var comanda = modelMapper.map(comandas, BuscarComandaDTO.class);
		return List.of(comanda);
	}
	
	public void excluirComanda(Long id) {
		comandaRepostorio.deleteById(id);
	}
}
