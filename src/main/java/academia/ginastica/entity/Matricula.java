package academia.ginastica.entity;

import java.time.LocalDateTime;
import java.util.UUID;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="matricula")
public class Matricula 
{
	@Id
	private UUID uuid;
	
	@OneToOne(cascade = CascadeType.DETACH)
	@JoinColumn(name="uuidAluno")
	private Aluno aluno;
	
	private LocalDateTime dataDeMatricula;
	
	public Matricula()
	{
		this.uuid = UUID.randomUUID();
	}
	
}
