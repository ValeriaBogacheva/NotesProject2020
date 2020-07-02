package ru.bve.notes.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.bve.notes.Repositories.CategoryRepository;
import ru.bve.notes.domain.CategoryEntity;

@Controller
public class AddCategoryView {
    @Autowired
    private CategoryRepository categoryRepository;

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
        return "redirect:/category";
    }
}
