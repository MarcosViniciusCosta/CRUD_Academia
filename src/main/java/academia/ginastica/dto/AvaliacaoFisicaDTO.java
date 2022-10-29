package academia.ginastica.dto;

import java.util.UUID;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;


import lombok.Data;

@Data
public class AvaliacaoFisicaDTO 
{
	@NotNull(message="Aluno precisa ser informado")
	private UUID uuidAluno;
	
	@NotNull(message="Peso precisa ser informada")
	@Min(35)
	@Max(300)
	private Double peso;
	
	@NotNull(message="Altura precisa ser informada")
	@Min(1)
	@Max(3)
	private Double altura;
}
