package academia.ginastica.repository;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import academia.ginastica.entity.Aluno;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, UUID>
{
	
	public List<Aluno> findByDataDeNascimento(LocalDate dataDeNascimento);
	
}
