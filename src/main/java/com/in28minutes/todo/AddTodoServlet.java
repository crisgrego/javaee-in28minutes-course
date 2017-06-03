package com.in28minutes.todo;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.in28minutes.todo.TodoService;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = "/add-todo.do")
public class AddTodoServlet extends HttpServlet{
	private TodoService service = new TodoService();
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 service.addTodo( new Todo(request.getParameter("todo")));
		 request.setAttribute("todos", service.retrieveTodos());
		 response.sendRedirect("/list-todo.do");
	}
}
