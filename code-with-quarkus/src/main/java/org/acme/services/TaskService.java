package org.acme.services;
import java.util.List;
import org.acme.models.Task;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.NotFoundException;


@ApplicationScoped
public class TaskService {


    public List<Task> getAllTasks() {
        return Task.listAll();
    }

    public Task findTaskById(Long id) {
        Task task = Task.findById(id);
        return task;
    }

    @Transactional
    public void createTask(Task task) {
        task.persist();
    }

    @Transactional
    public void markTaskComplete(Long id) {
        Task task = Task.findById(id);
        if(task == null) {
            throw new NotFoundException();
        }
        task.completed = true;
    }
}