package by.ibragimov.heap.dao.repositories;

import by.ibragimov.heap.RepositoryBaseTest;
import by.ibragimov.heap.domain.todo.TasksRepository;
import by.ibragimov.heap.domain.todo.Task;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.*;

@Transactional
public class TasksRepositoryTest extends RepositoryBaseTest {

    @Autowired
    private TasksRepository tasksRepository;

    @Test
    public void testCRD() throws Exception {
        Task task = new Task();
        task.setTitle("Test");
        Long id = tasksRepository.save(task).getId();
        assertNotNull(task.getId());
        tasksRepository.delete(id);
        assertFalse(tasksRepository.exists(id));
    }

}