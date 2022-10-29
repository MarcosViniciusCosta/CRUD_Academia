package academia.ginastica.controller;

import java.util.List;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import academia.ginastica.dto.MatriculaDTO;
import academia.ginastica.entity.Matricula;
import academia.ginastica.service.MatriculaService;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("matriculas")
public class MatriculaController 
{
	private final MatriculaService matriculaService;
	
	@GetMapping
	public ResponseEntity<List<Matricula>> findAll()
	{
		return ResponseEntity.ok(matriculaService.findAll());
	}
	
	@GetMapping("/{uuid}")
	public ResponseEntity<Matricula> findById(@PathVariable UUID uuid)
	{
		return ResponseEntity.ok(matriculaService.findById(uuid));
	}
	
	
	@DeleteMapping("/{uuid}")
	public ResponseEntity<String> delete(@PathVariable UUID uuid)
	{
		matriculaService.delete(uuid);
		return ResponseEntity.ok("Matricula deletada");
	}
	
	@PostMapping
	public ResponseEntity<Matricula> create(@RequestBody @Valid MatriculaDTO matriculaDTO)
	{
		return ResponseEntity.status(HttpStatus.CREATED).body(matriculaService.create(matriculaDTO));
	}
	
}
