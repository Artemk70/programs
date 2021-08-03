package main;

import main.model.Task;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicInteger;

@Component
public class Storage {
//    private int currentId = 1;
    private AtomicInteger currentIdd = new AtomicInteger(0);
    private final ConcurrentMap<Integer, Task> todoList = new ConcurrentHashMap<>();

    public List<Task> getTaskList() {
        List<Task> taskList = new ArrayList<>(todoList.values());
        return taskList;
    }

    public Task getTaskById(int taskId) {
        if (todoList.containsKey(taskId)) {
            return todoList.get(taskId);
        }
        return null;
    }

    public int addTask(Task task) {
        int id = currentIdd.incrementAndGet();
        task.setId(id);
        todoList.put(id, task);
        return id;
    }

    public void ubdateTaskById(Task task, int idTask) {
        task.setId(idTask);
        todoList.replace(idTask, task);
    }

    public void updateToDoList(Task task){
        todoList.clear();
        currentIdd.set(0);
        int id = currentIdd.incrementAndGet();
        task.setId(id);
        todoList.put(id, task);
    }

    public void deleteToDoList(){
        todoList.clear();
    }

    public void deleteById(int id){
        todoList.remove(id);
    }
}
