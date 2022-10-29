package academia.ginastica.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@Entity
@Table(name="aluno")
@JsonIgnoreProperties("{hibernateLazyInitializer,handler}")
public class Aluno 
{
	@Id
	private UUID uuid;
	
	
	private String nome;
	
	@Column(unique=true)
	private String cpf;
	
	private String bairro;
	
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate dataDeNascimento;
	
	@OneToMany(mappedBy = "aluno", fetch = FetchType.LAZY)
	@JsonIgnore
	private List<AvaliacaoFisica> listaAvaliacoes = new ArrayList<AvaliacaoFisica>();
	
	public Aluno()
	{
		this.uuid = UUID.randomUUID();
	}
	
}
