package academia.ginastica.dto;

import java.util.UUID;

import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class MatriculaDTO 
{
	@NotNull(message="Id de aluno não pode ser vazio")
	private UUID uuidAluno;
}
