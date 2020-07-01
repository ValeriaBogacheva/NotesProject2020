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
        CategoryRepository repository = context.getBean(CategoryRepository.class);

        repository.save(new CategoryEntity(1L,"Дом"));
        repository.save(new CategoryEntity(2L,"Работа"));
        repository.save(new CategoryEntity(3L,"Учеба"));
        repository.save(new CategoryEntity(4L,"Отпуск"));

        //context.close();
    }
}
