package academia.ginastica.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;

import academia.ginastica.dto.AvaliacaoFisicaDTO;
import academia.ginastica.dto.AvaliacaoFisicaUpdateDTO;
import academia.ginastica.entity.AvaliacaoFisica;
import academia.ginastica.exception.BadRequestException;
import academia.ginastica.entity.Aluno;
import academia.ginastica.repository.AlunoRepository;
import academia.ginastica.repository.AvaliacaoFisicaRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class AvaliacaoFisicaService 
{

	private final AvaliacaoFisicaRepository avaliacaoFisicaRepository;
	private final AlunoRepository alunoRepository;
	
	public AvaliacaoFisica create(AvaliacaoFisicaDTO avaliacaoFisicaDTO)
	{
		Optional<Aluno> alunoBuscado = alunoRepository.findById(avaliacaoFisicaDTO.getUuidAluno());
		if(alunoBuscado.isEmpty())
		{
			throw new BadRequestException("Id de aluno não encontrado");
		}
			
		AvaliacaoFisica avaliacaoFisica = new AvaliacaoFisica();
		avaliacaoFisica.setAltura(avaliacaoFisicaDTO.getAltura());
		avaliacaoFisica.setPeso(avaliacaoFisicaDTO.getPeso());
		avaliacaoFisica.setAluno(alunoBuscado.get());
		
		return avaliacaoFisicaRepository.save(avaliacaoFisica);
	}
	
	public AvaliacaoFisica findById(UUID uuid)
	{
		Optional<AvaliacaoFisica> avaliacaoFisicaAchada = avaliacaoFisicaRepository.findById(uuid);
		
		if(avaliacaoFisicaAchada.isEmpty())
		{
			throw new BadRequestException("Id de avaliação física não encontrado");
		}
		
		return avaliacaoFisicaAchada.get();
	}
	
	public List<AvaliacaoFisica> findAll()
	{
		return avaliacaoFisicaRepository.findAll();
	}
	
	public void delete(UUID uuid)
	{
		AvaliacaoFisica avaliacaoFisicaAchada = findById(uuid);
		avaliacaoFisicaRepository.delete(avaliacaoFisicaAchada);
	}

	public AvaliacaoFisica replace(AvaliacaoFisicaUpdateDTO avaliacaoFisicaUpdateDTO, UUID uuid) 
	{
		AvaliacaoFisica avaliacaoFisicaAchada = findById(uuid);
		avaliacaoFisicaAchada.setAltura(avaliacaoFisicaUpdateDTO.getAltura());
		avaliacaoFisicaAchada.setPeso(avaliacaoFisicaUpdateDTO.getPeso());
		
		return avaliacaoFisicaRepository.save(avaliacaoFisicaAchada);
	}
	
}
