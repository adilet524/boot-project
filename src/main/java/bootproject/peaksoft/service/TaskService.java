package bootproject.peaksoft.service;

import bootproject.peaksoft.entities.Task;

import java.util.List;

public interface TaskService {
    List<Task> getAllTasks();
    void addTask(Long id, Task task);
    Task getTaskById(Long id);
    void updateTask(Task task, Long id);
    void deleteTask(Long id);
}
