package by.ibragimov.heap.web.controllers;

import by.ibragimov.heap.domain.todo.Task;
import by.ibragimov.heap.domain.todo.TasksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * TODO: CommentMe!
 *
 * @author Ibragimov Ruslan
 */
@RestController
@RequestMapping(value =  "/tasks")
public class TasksController {

    @Autowired
    private TasksRepository tasksRepository;

    @RequestMapping(value = {"/", ""}, method = RequestMethod.GET)
    public Iterable<Task> list(Pageable pageable) {
        return tasksRepository.findAll(pageable);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Task get(@PathVariable("id") Long id) {
        return tasksRepository.getOne(id);
    }

    @RequestMapping(value = {"/", ""}, method = RequestMethod.POST)
    public Task create(Task dto) {
        return tasksRepository.save(dto);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public Task update(@PathVariable("id") Long id, Task task) {
        return tasksRepository.save(task);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void remove(@PathVariable("id") Long id) {
        tasksRepository.delete(id);
    }

}
