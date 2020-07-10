package ru.bve.notes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import ru.bve.notes.Repositories.CategoryRepository;
import ru.bve.notes.Repositories.TaskRepository;

@ComponentScan
@EnableAutoConfiguration
public class Application {

    public static void main(String[] args){
        ConfigurableApplicationContext context = SpringApplication.run(Application.class);

        CategoryRepository category = context.getBean(CategoryRepository.class);
        TaskRepository task = context.getBean(TaskRepository.class);

        //category.deleteAll();

    }
}
