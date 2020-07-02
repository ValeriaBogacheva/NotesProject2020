package ru.bve.notes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import ru.bve.notes.Repositories.CategoryRepository;
import ru.bve.notes.domain.CategoryEntity;

@ComponentScan
@EnableAutoConfiguration
public class Application {

    public static void main(String[] args){
        ConfigurableApplicationContext context = SpringApplication.run(Application.class);
        CategoryRepository category = context.getBean(CategoryRepository.class);

        category.save(new CategoryEntity(1L,"Дом"));
        category.save(new CategoryEntity(2L,"Работа"));
        category.save(new CategoryEntity(3L,"Учеба"));

        //context.close();
    }
}
