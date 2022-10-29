package academia.ginastica.dto;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;


import lombok.Data;

@Data
public class AvaliacaoFisicaUpdateDTO 
{
	@NotNull(message="Peso precisa ser informada")
	@Min(35)
	@Max(300)
	private Double peso;
	
	@NotNull(message="Altura precisa ser informada")
	@Min(1)
	@Max(3)
	private Double altura;
}
