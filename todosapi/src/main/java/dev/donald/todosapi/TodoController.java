package dev.donald.todosapi;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/todos")
public class TodoController {

    private final TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping()
    public ResponseEntity<List<Todo>> getAllTodos() {
        List<Todo> allTodos = todoService.getAllTodos();
        return ResponseEntity.ok(allTodos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Todo> getTodoById(
            @PathVariable Long id
    )  {
        Todo todo = todoService.getTodoById(id);
        return ResponseEntity.ok(todo);
    }
}
