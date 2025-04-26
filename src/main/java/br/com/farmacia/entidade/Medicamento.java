package br.com.farmacia.entidade;

import java.time.LocalDate;
import java.util.Random;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.farmacia.enums.Controlado;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tb_medicamentos") 
@Data
@NoArgsConstructor
public class Medicamento {	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;	
    private String nomeMedicamento;
    private Controlado controlado;
    private Integer lote = new Random().nextInt(9000) + 1000;
    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "yyyy-MM-dd")
    private LocalDate validade;
    private Integer qtdPedida;   
    @ManyToOne
    @JoinColumn(name ="comandaId")
    private Comanda comanda;
   
}
