package br.com.farmacia.dto;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import br.com.farmacia.entidade.Comanda;
import br.com.farmacia.entidade.Material;
import br.com.farmacia.entidade.Medicamento;
import br.com.farmacia.enums.Especialidade;
import br.com.farmacia.enums.SetorOrigem;
import br.com.farmacia.enums.setorDestino;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CriarComandaDTO {
	

	private String dataHora = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
	private Integer codComanda = new Random().nextInt(9000) + 1000;	
	private String farmaceutico = "Marcos Augusto Dos Santos";	
    private SetorOrigem setorOrigem;
    private setorDestino setorDestino;
    private String medico;
    private Especialidade especialidade;
	private String paciente;
	private int idade;
    private String obs;    
    private List<Medicamento>medicamentos = new ArrayList<>();
    private List<Material>materiais = new ArrayList<>();
    
  
	public CriarComandaDTO(Comanda criar) {
		this.dataHora = criar.getDataHora();
		this.farmaceutico = criar.getFarmaceutico();
		this.setorOrigem = criar.getSetorOrigem();
		this.setorDestino   = criar.getSetorDestino();
		this.medico = criar.getMedico();
		this.especialidade = criar.getEspecialidade();
		this.paciente = criar.getPaciente();
		this.idade = criar.getIdade();
		this.obs = criar.getObs();
		this.medicamentos  = criar.getMedicamentos();
		this.materiais = criar.getMateriais();
	}


}
