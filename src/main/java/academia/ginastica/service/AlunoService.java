package academia.ginastica.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;
import academia.ginastica.dto.AlunoDTO;
import academia.ginastica.entity.Aluno;
import academia.ginastica.exception.BadRequestException;
import academia.ginastica.repository.AlunoRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class AlunoService 
{
	private final AlunoRepository alunoRepository;
	
	public List<Aluno> findAll()
	{
		return alunoRepository.findAll();
	}
	
	public Aluno findById(UUID uuid)
	{
		Optional<Aluno> alunoAchado = alunoRepository.findById(uuid);
		if(alunoAchado.isEmpty())
		{
			throw new BadRequestException("Id de aluno não encontrado");
		}
		
		return alunoAchado.get();
	}
	
	
	public Aluno create(AlunoDTO alunoDTO)
	{
		Aluno aluno = new Aluno();
		aluno.setBairro(alunoDTO.getBairro());
		aluno.setCpf(alunoDTO.getCpf());
		aluno.setDataDeNascimento(alunoDTO.getDataDeNascimento());
		aluno.setNome(alunoDTO.getNome());
		return alunoRepository.save(aluno);
	}
	
	public void delete(UUID uuid)
	{
		Optional<Aluno> alunoEncontrado = alunoRepository.findById(uuid);
		
		if(alunoEncontrado.isEmpty())
		{
			throw new BadRequestException("Id de aluno não encontrado");
		}
		
		alunoRepository.delete(alunoEncontrado.get());
	}
	
	public Aluno replace(AlunoDTO alunoDTO, UUID uuid)
	{
		Optional<Aluno> alunoAchado = alunoRepository.findById(uuid);
		
		if(alunoAchado.isEmpty()) 
		{
			throw new BadRequestException("uuid não encontrado");
		}
	
		Aluno aluno = alunoAchado.get();
		
		aluno.setBairro(alunoDTO.getBairro());
		aluno.setCpf(alunoDTO.getCpf());
		aluno.setDataDeNascimento(alunoDTO.getDataDeNascimento());
		aluno.setNome(alunoDTO.getNome());
		
		return alunoRepository.save(aluno);
	}
	
	public List<Aluno> findByDataNascimento(LocalDate dataNascimento)
	{
		return alunoRepository.findByDataDeNascimento(dataNascimento);
	}
	
}
