package com.geovani.todolist.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
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
	
}
