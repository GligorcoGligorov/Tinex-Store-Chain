package com.example.tinexchain.web.Controller;

import com.example.tinexchain.model.Category;
import com.example.tinexchain.service.CategoryService;
import com.example.tinexchain.service.viewsService.ListanjeProduktiPoKategorijaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/category")
public class CategoryController {

    private final CategoryService categoryService;

    private final ListanjeProduktiPoKategorijaService listanjeProduktiPoKategorijaService;
    boolean selectedCategory = false;

    public CategoryController(CategoryService categoryService, ListanjeProduktiPoKategorijaService listanjeProduktiPoKategorijaService) {
        this.categoryService = categoryService;
        this.listanjeProduktiPoKategorijaService = listanjeProduktiPoKategorijaService;
    }

    @GetMapping
    public String getCategories(Model model){

        model.addAttribute("categories",categoryService.listAll());
        return "categories";
    }

    @PostMapping
    public String getProductsByCategory(Model model, @RequestParam String getProductsByCategory){
        model.addAttribute("categories",categoryService.listAll());
        model.addAttribute("productsByCategory", listanjeProduktiPoKategorijaService.listProductsByCategoryId(getProductsByCategory));
        selectedCategory = true;
        model.addAttribute("selectedCategory",selectedCategory);
        System.out.println(getProductsByCategory);
        List<Category> list = categoryService.listAll();
        final String[] cat = {""};
        list.stream().filter(i->i.getCategory_name().equals(getProductsByCategory)).forEach(j-> {
            cat[0] = String.valueOf(j.getCategory_name());
        });

        String catId = (cat[0]);
        model.addAttribute("catId",catId);

//        System.out.println(catId);
        return "categories";
    }
}
