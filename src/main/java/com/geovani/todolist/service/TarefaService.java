package com.geovani.todolist.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
	
	public List<Tarefa> listAllTarefas(){
		return tarefaRepository.findAll();
	}
	
	public ResponseEntity<Tarefa> findTarefaById(Long id) {
		return tarefaRepository.findById(id).map(tarefa -> ResponseEntity.ok().body(tarefa))
				.orElse(ResponseEntity.notFound().build());
	}
	
}
