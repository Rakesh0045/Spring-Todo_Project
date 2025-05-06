package com.todo.todo_app;

import java.io.PrintWriter;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TodoController {
    private List<Todo> todos;
    private static int idCounter;

    // List object injected into tasks through constructor DI
    public TodoController(List<Todo> todos) {
        this.todos = todos;
    }

    @GetMapping("/")
    public String home(Model model) {
        // As this method doesn't pass any model attribute so when we hit / we dont get
        // data fetched by Model attribute
        model.addAttribute("todos", todos);
        return "index";
    }

    @PostMapping("/add")
    public String addTodo(@RequestParam String task, Model model) { // @RequestParam is used to extract query string
        if(!task.isEmpty() && !task.isBlank()){
            Todo todo = new Todo();
        todo.setId(++idCounter);
        todo.setTask(task);


        for (Todo existingTodo : todos) {
            if(existingTodo.getTask().equals(task)){
                return "redirect:/";
            }
        }

        todos.add(todo);
        //model.addAttribute("todos", todos); // Through model object we passed key-value pair using keys "todos" using
                                            // which we extract tasks List
         // Whenever add request is hit or form is accessed in index page then we redirect it to /

        // return "index"; //previous state is not maintained if we use this hence we
        // use redirect:/
        }

        return "redirect:/";
    }    
        
    /*
     * 
     * PROGRAM FLOW
     * 
     * At starting we hit / end point or index page. Initially the list is empty, so
     * it doesn't show anything
     * We access the form in index page
     * when we submit the form we hit /add which add the task to the List
     * Then again it hits / through redirect:/ which now it sends list to html for
     * viewing purpose
     * 
     * 
     * /add can't be directly hit from browser because controller won't allow GET
     * request because we use POST method. POST request can only be shared through
     * form. form available in index page and index is get from / endpoint. SO OUR
     * STARTER POINT IS ALWAYS GOING TO BE /
     * 
     * 
     * / end point ---> index page --> add Task through form --> Click submit (Add)
     * button --> /add endpoint hit --> addTodo() works --> task is extracted and
     * added to initially empty List --> return redirect:/ (control explicitly sent
     * to / end point) --> again enter / --> share List "tasks" using model object
     * with index.html --> index.html extracts the List using forEach and view in
     * page
     * 
     * 
     */

    @GetMapping("/toggle/{id}")
    // {id} is value to represent the id value in query parameter
    // @PathVariable used to extract the id
    public String toggleTodo(@PathVariable int id) {
        for (Todo todo : todos) {
            if (todo.getId() == id) {
                todo.setCompleted(!todo.isCompleted());
                break;
            }
        }
        return "redirect:/";
    }

    // @GetMapping("/get-value/{x}")
    // public void printValue(PrintWriter printWriter, @PathVariable int x) {
    // // {x} extracted by @PathVariable, otherwise it is consider as mapping
    // instead
    // // of constant
    // printWriter.println("Value extracted : " + x);
    // }

    @GetMapping("/delete/{id}")
    public String deleteTodo(@PathVariable int id) {
        for (Todo todo : todos) {
            if (todo.getId() == id) {
                todos.remove(todo);
                break;
            }
        }
        return "redirect:/";
    }

}
