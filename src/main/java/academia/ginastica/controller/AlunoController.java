package academia.ginastica.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import academia.ginastica.dto.AlunoDTO;
import academia.ginastica.entity.Aluno;
import academia.ginastica.service.AlunoService;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("alunos")
@AllArgsConstructor
public class AlunoController 
{
	private final AlunoService alunoService;
	
	@GetMapping
	public ResponseEntity<List<Aluno>> findAll()
	{
		return ResponseEntity.ok(alunoService.findAll());
	}
	
	@GetMapping("/{uuid}")
	public ResponseEntity<Aluno> findById(@PathVariable UUID uuid)
	{
		return ResponseEntity.ok(alunoService.findById(uuid));
	}
	
	@GetMapping("/buscarPorDataDeNascimento")
	public ResponseEntity<List<Aluno>> findByDataNascimento(@RequestParam LocalDate dataNascimento)
	{
		return ResponseEntity.ok(alunoService.findByDataNascimento(dataNascimento));
	}
	
	
	@PostMapping
	public ResponseEntity<Aluno> create(@RequestBody @Valid AlunoDTO alunoDTO)
	{
		return ResponseEntity.status(HttpStatus.CREATED).body(alunoService.create(alunoDTO));
	}
	
	@DeleteMapping("/{uuid}")
	public ResponseEntity<String> delete(@PathVariable UUID uuid)
	{
		alunoService.delete(uuid);
		return ResponseEntity.ok("Aluno deletado!");
	}
	
	@PutMapping("/{uuid}")
	public ResponseEntity<Aluno> replace(@RequestBody @Valid AlunoDTO alunoDTO, @PathVariable UUID uuid)
	{
		return ResponseEntity.ok(alunoService.replace(alunoDTO, uuid));
	}
	
}
