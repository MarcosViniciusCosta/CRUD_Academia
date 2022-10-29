package academia.ginastica.dto;

import java.time.LocalDate;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.br.CPF;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

@Data
public class AlunoDTO 
{
	@NotBlank(message="Nome não pode ser vazio")
	@Size(min=3,max=60,message="Nome deve ter entre 3 e 60 caracteres")
	private String nome;
	
	@NotBlank(message="CPF não pode ser vazio")
	@CPF(message="Formato de CPF inválido")
	private String cpf;
	
	@NotBlank(message="Bairro não pode ser vazio")
	@Size(min=3,max=40,message="Bairro deve ter entre 3 e 40 caracteres")
	private String bairro;
	
	@NotNull(message="Data de nascimento precisa estar corretamente preenchida")
	@JsonFormat(pattern = "dd/MM/yyyy")
	@Past(message="Data inválida")
	private LocalDate dataDeNascimento;
	
}
