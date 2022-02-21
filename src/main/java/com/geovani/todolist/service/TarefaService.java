package com.geovani.todolist.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.geovani.todolist.model.Tarefa;
import com.geovani.todolist.repository.TarefaRepository;

@Service
public class TarefaService {

	@Autowired
	private TarefaRepository tarefaRepository;
	
	public Tarefa createTarefa(Tarefa tarefa) {
		return tarefaRepository.save(tarefa);
	}
	
}
