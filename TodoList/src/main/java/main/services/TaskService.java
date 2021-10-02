package main.services;

import main.model.Task;
import main.services.inter.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TaskService {

    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public int add(Task task) {
        Task newTask = taskRepository.save(task);
        return newTask.getId();
    }

    public boolean existsById(int id) {
        return taskRepository.existsById(id);
    }

    public Optional<Task> findById(int id) {
        return taskRepository.findById(id);
    }

    public Iterable<Task> findAll() {
        return taskRepository.findAll();
    }

    public void save(Task task) {
        taskRepository.save(task);
    }

    public void deleteAll() {
        taskRepository.deleteAll();
    }

    public void deleteById(int id) {
        taskRepository.deleteById(id);
    }


}
