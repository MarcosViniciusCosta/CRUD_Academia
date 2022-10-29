package academia.ginastica.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;

import academia.ginastica.repository.MatriculaRepository;
import lombok.AllArgsConstructor;
import academia.ginastica.dto.MatriculaDTO;
import academia.ginastica.entity.Aluno;
import academia.ginastica.entity.Matricula;
import academia.ginastica.exception.BadRequestException;

@Service
@AllArgsConstructor
public class MatriculaService 
{
	private final MatriculaRepository matriculaRepository;
	private final AlunoService alunoService;
	
	public List<Matricula> findAll()
	{
		return matriculaRepository.findAll();
	}
	
	public Matricula findById(UUID uuid)
	{
		Optional<Matricula> matriculaAchada = matriculaRepository.findById(uuid);
		
		if(matriculaAchada.isEmpty())
		{
			throw new BadRequestException("Id de matrícula não encontrado");
		}
		return matriculaAchada.get();
	}
	
	
	public void delete(UUID uuid)
	{
		Matricula matriculaAchada = findById(uuid);
		matriculaRepository.delete(matriculaAchada);
	}
	
	
	public Matricula create(MatriculaDTO matriculaDTO)
	{
		Matricula novaMatricula = new Matricula();
		novaMatricula.setDataDeMatricula(LocalDateTime.now());
		
		Aluno aluno = alunoService.findById(matriculaDTO.getUuidAluno()); 
		novaMatricula.setAluno(aluno);
		return matriculaRepository.save(novaMatricula);
	}
	
}
