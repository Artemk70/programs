package main;

import main.model.Task;
import main.services.TaskService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/todoList")
public class todoListController {

    private TaskService taskService;

    public todoListController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping()
    public ResponseEntity<Integer> add(Task task) {
        return new ResponseEntity<>(taskService.add(task), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable int id, @RequestBody Task task) {
        if (taskService.existsById(id)) {
            Optional<Task> optionalTask = taskService.findById(id);

            if (optionalTask.isPresent()) {

                Task newTask = optionalTask.get();

                newTask.setName(task.getName());
                newTask.setYear(task.getYear());

                taskService.save(newTask);
                return new ResponseEntity<>(taskService.findById(id), HttpStatus.OK);
            }
        }
        return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);

    }

    @PutMapping()
    public ResponseEntity<?> update(Task task) {
        taskService.deleteAll();
        taskService.save(task);

        Optional<Task> optionalTask = taskService.findById(task.getId());
        if (optionalTask.isPresent()) {
            return new ResponseEntity<>(optionalTask.get(), HttpStatus.OK);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    @GetMapping()
    public List<Task> list() {
        Iterable<Task> taskIterable = taskService.findAll();
        ArrayList<Task> tasks = new ArrayList<>();
        for (Task task : taskIterable) {
            tasks.add(task);
        }
        return tasks;
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> get(@PathVariable int id) {
        Optional<Task> optionalBook = taskService.findById(id);
        if (!optionalBook.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return new ResponseEntity<>(optionalBook.get(), HttpStatus.OK);
    }

    @DeleteMapping()
    public void delete() {
        taskService.deleteAll();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        if (taskService.existsById(id)) {
            taskService.deleteById(id);
        }
    }
}
