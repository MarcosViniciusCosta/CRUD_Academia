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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import academia.ginastica.service.AvaliacaoFisicaService;
import lombok.AllArgsConstructor;
import academia.ginastica.dto.AvaliacaoFisicaDTO;
import academia.ginastica.dto.AvaliacaoFisicaUpdateDTO;
import academia.ginastica.entity.AvaliacaoFisica;

@RestController
@AllArgsConstructor
@RequestMapping("avaliacoes")
public class AvaliacaoFisicaController 
{
	private final AvaliacaoFisicaService avaliacaoFisicaService;


	@GetMapping("/{uuid}")
	public ResponseEntity<AvaliacaoFisica> findById(@PathVariable UUID uuid)
	{
		return ResponseEntity.ok(avaliacaoFisicaService.findById(uuid));
	}

	@GetMapping("")
	public ResponseEntity<List<AvaliacaoFisica>> findAll()
	{
		return ResponseEntity.ok(avaliacaoFisicaService.findAll());
	}
	
	
	@PostMapping
	public ResponseEntity<AvaliacaoFisica> create(@RequestBody @Valid AvaliacaoFisicaDTO avaliacaoFisicaDTO)
	{
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(avaliacaoFisicaService.create(avaliacaoFisicaDTO));
	}
	
	@DeleteMapping("/{uuid}")
	public ResponseEntity<String> delete (@PathVariable UUID uuid)
	{
		avaliacaoFisicaService.delete(uuid);
		return ResponseEntity.ok("Avaliacão física deletada");
	}
	
	@PutMapping("/{uuid}")
	public ResponseEntity<AvaliacaoFisica> replace(@RequestBody @Valid AvaliacaoFisicaUpdateDTO avaliacaoFisicaUpdateDTO,@PathVariable UUID uuid)
	{
		return ResponseEntity.ok
				(avaliacaoFisicaService.replace(avaliacaoFisicaUpdateDTO, uuid));
	}
	
	
}
