package org.acme.routes;
import java.util.List;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import org.acme.services.*;
import jakarta.inject.Inject;


@Path("/tasks")
public class TaskResource {

    @Inject
    TaskService taskService;

    @GET
    public List<Task> getAllTasks() {
        return taskService.getAllTasks();
    }

    @GET
    @Path("/{id}")
    public Task getTaskById(@PathParam("id") Long id) {
        Task task = taskService.findTaskById(id);
        return task;
    }

    @POST
    public void createTask(Task task) {
        taskService.createTask(task);
    }

    @PUT
    @Path("/{id}/complete")
    public void markComplete(@PathParam("id") Long id) {
        taskService.markTaskComplete(id);
    }


}
