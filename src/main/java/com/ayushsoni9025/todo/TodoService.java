package com.ayushsoni9025.todo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Service;

import jakarta.validation.Valid;

@Service
public class TodoService {
	private static int todoCount = 0;
	private static List<Todo> todos = new ArrayList<Todo>();
	
	static {
		todos.add(new Todo(++todoCount,"in28minutes","Learn AWS1", LocalDate.now().plusYears(1), false));;
		todos.add(new Todo(++todoCount,"in28minutes","Learn DevOps1", LocalDate.now().plusYears(2), false));
		todos.add(new Todo(++todoCount,"in28minutes","Learn Full Stack Development1", LocalDate.now().plusYears(3), false));
		todos.add(new Todo(++todoCount,"ayushsoni9025@gmail.com","Learn Full Stack Development1", LocalDate.now().plusYears(3), false));
	}
	
	public List<Todo> findByUname(String uname){
		Predicate<? super Todo> predicate = todo -> todo.getUname().equalsIgnoreCase(uname);
		return todos.stream().filter(predicate).toList();
	}
	
	public void addTodo(String uname, String description, LocalDate targetDate, boolean done) {
		Todo todo = new Todo(++todoCount,uname,description,targetDate,done);
		todos.add(todo);
	}
	
	public void deleteById(int id) {
		Predicate<? super Todo> predicate = todo -> todo.getId() == id;
		todos.removeIf(predicate);
	}

	public Todo findById(int id) {
		Predicate<? super Todo> predicate = todo -> todo.getId() == id;
		Todo todo = todos.stream().filter(predicate).findFirst().get();
		return todo;
	}
	
	public void updateTodo(@Valid Todo todo) {
		deleteById(todo.getId());
		todos.add(todo);
	}
	
	
}
