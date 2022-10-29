package academia.ginastica.entity;

import java.time.LocalDateTime;
import java.util.UUID;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="avaliacao_fisica")
public class AvaliacaoFisica 
{

	@Id
	private UUID uuid;
	
	@ManyToOne(cascade = CascadeType.DETACH)
	@JoinColumn(name="aluno_uuid")
	private Aluno aluno;
	
	private LocalDateTime dataDeAvaliacao = LocalDateTime.now();
	
	private Double peso;
	
	private Double altura;
	
	
	public AvaliacaoFisica()
	{
		this.uuid = UUID.randomUUID();
	}
}
