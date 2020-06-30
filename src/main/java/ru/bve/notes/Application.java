package ru.bve.notes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import ru.bve.notes.Repositories.CategoryRepository;
import ru.bve.notes.domain.CategoryEntity;

@ComponentScan
@EnableAutoConfiguration
@Configuration
public class Application {
    public static void main(String[] args){
        SpringApplication.run(Application.class, args);

        ConfigurableApplicationContext context = SpringApplication.run(Application.class);
        CategoryRepository repository = context.getBean(CategoryRepository.class);

        repository.save(new CategoryEntity("Test Category1"));
        repository.save(new CategoryEntity("Test Category2"));

        Iterable<CategoryEntity> categories = repository.findAll();

        for (CategoryEntity entity : categories) {
            System.out.println(entity.getName());
        }

        context.close();
    }
}
