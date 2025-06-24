package com.todoapp.todoapp.view;

import com.todoapp.todoapp.models.Todo;
import com.todoapp.todoapp.repository.TodoRepo;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;
@Route("")
public class TodoView extends VerticalLayout {
    private TodoRepo repo;
    @Autowired
    public TodoView(TodoRepo repo) {
        this.repo = repo;
        var task = new TextField();
        var button = new Button("Add");
        var todos = new VerticalLayout();
        button.addClickListener(click -> {
            var todo = repo.save(new Todo(task.getValue()));
            todos.add(createCheckbox(todo));
        });
        repo.findAll().forEach(todo -> todos.add(createCheckbox(todo)));
        add(
                new H1("Todo"),
                new HorizontalLayout(task, button),
                todos
        );
    }
    private Component createCheckbox(Todo todo) {
        return new Checkbox(todo.getTask(), todo.isDone(), e -> {
            todo.setDone(e.getValue());
            repo.save(todo);
        });
    }
}