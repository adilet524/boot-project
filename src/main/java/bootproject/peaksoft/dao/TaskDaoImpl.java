package bootproject.peaksoft.dao;

import bootproject.peaksoft.entities.Lesson;
import bootproject.peaksoft.entities.Task;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class TaskDaoImpl implements TaskDao{

    @PersistenceContext
    private EntityManager manager;

    @Override
    public List<Task> getAllTasks() {
        List<Task> tasks = manager.createQuery("select t from Task t", Task.class).getResultList();
        return tasks;
    }

    @Override
    public void addTask(Long id, Task task) {
        Lesson lesson = manager.find(Lesson.class, id);
        lesson.addTask(task);
        task.setLesson(lesson);
        manager.merge(lesson);
    }

    @Override
    public Task getTaskById(Long id) {
        return manager.find(Task.class, id);
    }

    @Override
    public void updateTask(Task task, Long id) {
        Task task1 = manager.find(Task.class, id);
        task1.setTaskName(task.getTaskName());
        task1.setDeadline(task.getDeadline());
        manager.merge(task1);
    }

    @Override
    public void deleteTask(Long id) {
        manager.remove(manager.find(Task.class, id));
    }
}
