package main;

import main.model.Task;
import main.model.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;

@Controller
public class DefaultController {

    @Autowired
    private TaskRepository taskRepository;

    @Value("${parameter.value}")
    private Integer parameter;

    @RequestMapping("/")
    public String index(Model model){
        Iterable<Task> taskIterable = taskRepository.findAll();
        ArrayList<Task> todoList = new ArrayList<>();
        for (Task task : taskIterable) {
            todoList.add(task);
        }
        model.addAttribute("todoList", todoList);
        model.addAttribute("todoListCount", todoList.size());
        model.addAttribute("parameter", parameter);
        return "index";
    }
}
