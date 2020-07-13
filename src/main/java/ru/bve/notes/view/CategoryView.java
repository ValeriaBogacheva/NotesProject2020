package ru.bve.notes.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.bve.notes.Repositories.CategoryRepository;
import ru.bve.notes.Repositories.TaskRepository;
import ru.bve.notes.domain.CategoryEntity;
import ru.bve.notes.domain.TaskEntity;

import java.util.HashMap;
import java.util.Map;

@Controller
public class CategoryView {
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private TaskRepository taskRepository;

    @RequestMapping(value = {"/", "/category"}, method = RequestMethod.GET)
    public String getIndex(Model model){
        Map<Long, CategoryEntity> categories = getCategories();
        Iterable<TaskEntity> tasks = taskRepository.findAll();

        model.addAttribute("categories", categories.values());
        model.addAttribute("currentCategory", categories.get(0L));
        model.addAttribute("tasks", tasks);

        return "index";
    }

    @RequestMapping(value = {"/category/{id}"}, method = RequestMethod.GET)
    public String getIndex(Model model, @PathVariable Long id){
        Map<Long, CategoryEntity> categories = getCategories();
        Map<Long, TaskEntity> tasks = getTasks(id);

        model.addAttribute("categories", categories.values());
        model.addAttribute("currentCategory", categories.get(id));
        model.addAttribute("tasks", tasks.values());

        return "index";
    }

    private Map<Long, CategoryEntity> getCategories(){
        Map<Long, CategoryEntity> result = new HashMap<>();
        Iterable<CategoryEntity> categories = categoryRepository.findAll();
        result.put(0L, new CategoryEntity(("Все")));

        for (CategoryEntity entity: categories){
            result.put(entity.getId(), entity);
        }
        return result;
    }

    private Map<Long, TaskEntity> getTasks(Long id){
        Map<Long, TaskEntity> result = new HashMap<>();
        Iterable<TaskEntity> tasks = taskRepository.findAll();

        for (TaskEntity entity: tasks){
            if (entity.getParent() == id)
                result.put(entity.getId(), entity);
        }
        return result;
    }

    @RequestMapping(value = "/addCategory", method = RequestMethod.GET)
    public String categoryForm(Model model) {
        model.addAttribute("addCategory", new CategoryEntity());

        return "addCategory";
    }

    @RequestMapping(value = {"/addCategory"}, method = RequestMethod.POST)
    public String categorySubmit(@ModelAttribute CategoryEntity addcategory, Model model){
        if (StringUtils.hasText(addcategory.getName())){
            categoryRepository.save(new CategoryEntity(addcategory.getName()));
        }

        return "redirect:/";
    }

    @RequestMapping(value = {"/category/{id}/delete"})
    public String removeCategory(@PathVariable Long id) {
        categoryRepository.deleteById(id);

        return "redirect:/category";
    }

    @RequestMapping(value = "/category/addTask", method = RequestMethod.GET)
    public String taskForm(Model model){
        model.addAttribute("addTask", new TaskEntity());

        return "addTask";
    }

    @RequestMapping(value = {"/category/addTask"}, method = RequestMethod.POST)
    public String categorySubmit(@ModelAttribute TaskEntity addtask, Model model){
        CategoryEntity category = categoryRepository.findById(addtask.getParent()).get();
        TaskEntity task = new TaskEntity(addtask.getParent(), addtask.getTitle());
        task.setCategory(category);

        taskRepository.save(task);

        return "redirect:/category/" + addtask.getParent();
    }
}

