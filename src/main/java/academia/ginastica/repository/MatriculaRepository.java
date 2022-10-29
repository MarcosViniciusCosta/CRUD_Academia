package academia.ginastica.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import academia.ginastica.entity.Matricula;

@Repository
public interface MatriculaRepository extends JpaRepository<Matricula, UUID>
{
	
}
