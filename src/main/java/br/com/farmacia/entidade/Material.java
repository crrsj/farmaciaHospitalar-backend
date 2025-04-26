package br.com.farmacia.entidade;

import java.time.LocalDate;
import java.util.Random;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.farmacia.enums.Liberar;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tb_materiais") 
@Data
@NoArgsConstructor
public class Material {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nomeMaterial;
	private Integer lote = new Random().nextInt(9000) + 1000;
	@JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "yyyy-MM-dd")
	private LocalDate validade;
	private Integer qtdPedidaMaterial;
	private Integer estoque;
	@Enumerated(EnumType.STRING)
	private Liberar liberar;	
	private String obs;	
	@JoinColumn(name = "comandaId")
	@ManyToOne
	private Comanda comanda;
	
}
