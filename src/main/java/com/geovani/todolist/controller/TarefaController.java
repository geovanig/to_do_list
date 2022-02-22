package com.geovani.todolist.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.geovani.todolist.model.Tarefa;
import com.geovani.todolist.service.TarefaService;

@RestController
@RequestMapping("/tarefas")
public class TarefaController {

	@Autowired
	TarefaService tarefaService;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Tarefa createTarefa(@RequestBody Tarefa tarefa) {
		return tarefaService.createTarefa(tarefa);
	}
	
	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public List<Tarefa> getAllTarefas(){
		return tarefaService.listAllTarefas(); 
	}
	
	@GetMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Tarefa> getTarefaById(@PathVariable (value = "id") Long id){
		return tarefaService.findTarefaById(id); 
	}
	
	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Tarefa> updateTarefaById(@PathVariable (value = "id") Long id, @RequestBody Tarefa tarefa){
		return tarefaService.updateTarefaById(tarefa, id); 
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public ResponseEntity<Object> deleteTarefaById(@PathVariable (value = "id") Long id){
		return tarefaService.deleteById(id); 
	}
	
}
