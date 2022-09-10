package bootproject.peaksoft.service;

import bootproject.peaksoft.dao.TaskDao;
import bootproject.peaksoft.entities.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServiceImpl implements TaskService{

    private final TaskDao taskDao;

    @Autowired
    public TaskServiceImpl(TaskDao taskDao) {
        this.taskDao = taskDao;
    }

    @Override
    public List<Task> getAllTasks() {
        return taskDao.getAllTasks();
    }

    @Override
    public void addTask(Long id, Task task) {
        taskDao.addTask(id, task);
    }

    @Override
    public Task getTaskById(Long id) {
        return taskDao.getTaskById(id);
    }

    @Override
    public void updateTask(Task task, Long id) {
        taskDao.updateTask(task, id);
    }

    @Override
    public void deleteTask(Long id) {
        taskDao.deleteTask(id);
    }
}
