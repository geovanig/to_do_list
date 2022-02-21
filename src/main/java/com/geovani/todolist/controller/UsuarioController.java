package com.geovani.todolist.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

//	@Autowired
//	private LeitorService leitorService;
//
//	@Autowired
//	private LeitorRepository leitorRepository;
//
//	@GetMapping("/all")
//	public ResponseEntity<List<Leitor>> getAll() {
//		return ResponseEntity.ok(leitorRepository.findAll());
//	}
//
//	@PostMapping("/logar")
//	public ResponseEntity<LoginLeitor> loginLeitor(@RequestBody Optional<LoginLeitor> loginLeitor) {
//		return leitorService.autenticarLeitor(loginLeitor)
//				.map(resp -> ResponseEntity.status(HttpStatus.OK).body(resp))
//				.orElse(ResponseEntity.status(HttpStatus.UNAUTHORIZED).build());
//	}
//
//	@PostMapping("/cadastrar")
//	public ResponseEntity<Leitor> postLeitor(@Valid @RequestBody Leitor leitor) {
//		return leitorService.cadastrarLeitor(leitor)
//				.map(resposta -> ResponseEntity.status(HttpStatus.CREATED).body(resposta))
//				.orElse(ResponseEntity.status(HttpStatus.BAD_REQUEST).build());
//	}
//
//	@PutMapping("/atualizar")
//	public ResponseEntity<Leitor> putLeitor(@Valid @RequestBody Leitor leitor) {
//		return leitorService.atualizarLeitor(leitor)
//				.map(resposta -> ResponseEntity.status(HttpStatus.OK).body(resposta))
//				.orElse(ResponseEntity.status(HttpStatus.BAD_REQUEST).build());
//	}
//	
//	@DeleteMapping("/deletar/{id}")
//	public ResponseEntity<?> deleteLeitor(@PathVariable long id) {
//		return leitorRepository.findById(id).map(resposta -> {
//			leitorRepository.deleteById(id);
//			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
//		}).orElse(ResponseEntity.notFound().build());
//	}
	
}
