package com.geovani.todolist.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.geovani.todolist.model.StatusTarefa;
import com.geovani.todolist.model.Tarefa;
import com.geovani.todolist.repository.TarefaRepository;

@Service
public class TarefaService {

	@Autowired
	private TarefaRepository tarefaRepository;

	public Tarefa createTarefa(Tarefa tarefa) {
		return tarefaRepository.save(tarefa);
	}

	public List<Tarefa> listAllTarefas() {
		return tarefaRepository.findAll();
	}

	public ResponseEntity<Tarefa> findTarefaById(Long id) {
		return tarefaRepository.findById(id).map(tarefa -> ResponseEntity.ok().body(tarefa))
				.orElse(ResponseEntity.notFound().build());
	}

	public ResponseEntity<Tarefa> updateTarefaById(Tarefa tarefa, Long id) {
		return tarefaRepository.findById(id).map(tarefaUpdate -> {
			tarefaUpdate.setTitulo(tarefa.getTitulo());
			tarefaUpdate.setDescricao(tarefa.getDescricao());
			tarefaUpdate.setDeadLine(tarefa.getDeadLine());
			tarefaUpdate.setStatus(StatusTarefa.CONCLUIDA);
			tarefaUpdate.setUrgencia(tarefa.getUrgencia());
			Tarefa updated = tarefaRepository.save(tarefaUpdate);
			return ResponseEntity.ok().body(updated);
		}).orElse(ResponseEntity.notFound().build());
	}

	public ResponseEntity<Object> deleteById(Long id) {
		return tarefaRepository.findById(id).map(tarefaDelete -> {
			tarefaRepository.deleteById(id);
			return ResponseEntity.noContent().build();
		}).orElse(ResponseEntity.notFound().build());
	}

}
