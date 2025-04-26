package br.com.farmacia.entidade;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.farmacia.dto.CriarComandaDTO;
import br.com.farmacia.enums.Especialidade;
import br.com.farmacia.enums.SetorOrigem;
import br.com.farmacia.enums.setorDestino;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "tb_comandas") 
@Data
@NoArgsConstructor
public class Comanda {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String dataHora = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
	private Integer codComanda = new Random().nextInt(9000) + 1000;	 
	private String farmaceutico = "Marcos Augusto Dos Santos";	
	@Enumerated(EnumType.STRING)
    private SetorOrigem setorOrigem;
	@Enumerated(EnumType.STRING)
    private setorDestino setorDestino;
    private String medico;
    @Enumerated(EnumType.STRING)
    private Especialidade especialidade;
	private String paciente; 
	private int idade;
    private String obs;
    @JsonIgnore
    @OneToMany(mappedBy = "comanda",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<Medicamento>medicamentos = new ArrayList<>();
    @JsonIgnore
    @OneToMany(mappedBy = "comanda",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<Material>materiais = new ArrayList<>();    
    
    public Comanda(CriarComandaDTO criarComandaDTO) {
		this.dataHora = criarComandaDTO.getDataHora();
		this.codComanda = criarComandaDTO.getCodComanda();
		this.farmaceutico = criarComandaDTO.getFarmaceutico();
		this.setorOrigem = criarComandaDTO.getSetorOrigem();
		this.setorDestino = criarComandaDTO.getSetorDestino();
		this.medico = criarComandaDTO.getMedico();
		this.especialidade = criarComandaDTO.getEspecialidade();
		this.paciente = criarComandaDTO.getPaciente();
		this.idade = criarComandaDTO.getIdade();
		this.obs = criarComandaDTO.getObs();
		this.medicamentos = criarComandaDTO.getMedicamentos();
		this.materiais = criarComandaDTO.getMateriais();
	}
}
