package main;

import main.model.Task;
import main.model.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class todoListController {

    @Autowired
    private TaskRepository taskRepository;

    @PostMapping("/todoList/")
    public int add(Task task) {
        Task newTask = taskRepository.save(task);
        return newTask.getId();
    }

    @PutMapping("/todoList/{id}")
    public ResponseEntity<?> update(@PathVariable int id, Task task) {
        if (taskRepository.existsById(id)) {
            Optional<Task> optionalTask = taskRepository.findById(id);

            if (optionalTask.isPresent()) {

                Task newTask = optionalTask.get();

                newTask.setName(task.getName());
                newTask.setYear(task.getYear());

                taskRepository.save(newTask);
                return new ResponseEntity<>(taskRepository.findById(id), HttpStatus.OK);
            }
        }
        return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);

    }

    @PutMapping("/todoList/")
    public ResponseEntity<?> update(Task task) {
        taskRepository.deleteAll();
        taskRepository.save(task);
        return new ResponseEntity<>(taskRepository.findById(task.getId()), HttpStatus.OK);
    }

    @GetMapping("/todoList/")
    public List<Task> list() {
        Iterable<Task> taskIterable = taskRepository.findAll();
        ArrayList<Task> tasks = new ArrayList<>();
        for (Task task : taskIterable) {
            tasks.add(task);
        }
        return tasks;
    }

    @GetMapping("/todoList/{id}")
    public ResponseEntity<?> get(@PathVariable int id) {
        Optional<Task> optionalBook = taskRepository.findById(id);
        if (!optionalBook.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return new ResponseEntity<>(optionalBook.get(), HttpStatus.OK);
    }

    @DeleteMapping("/todoList/")
    public void delete() {
        if (taskRepository != null) {
            taskRepository.deleteAll();
        }
    }

    @DeleteMapping("/todoList/{id}")
    public void delete(@PathVariable int id) {
        if (taskRepository.existsById(id)) {
            taskRepository.deleteById(id);
        }
    }
}
