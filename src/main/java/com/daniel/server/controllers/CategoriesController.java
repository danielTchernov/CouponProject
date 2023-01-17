package com.daniel.server.controllers;

import com.daniel.server.beans.Category;
import com.daniel.server.beans.Company;
import com.daniel.server.beans.Coupons;
import com.daniel.server.constants.Constants;
import com.daniel.server.entities.CategoryEntity;
import com.daniel.server.exceptions.ServerException;
import com.daniel.server.logic.CategoryLogic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoriesController {

    private CategoryLogic categoryLogic;

    @Autowired
    public CategoriesController(CategoryLogic categoryLogic){
        this.categoryLogic = categoryLogic;
    }

    @PostMapping
    public void createCategory (@RequestBody CategoryEntity category) throws Exception {
        categoryLogic.createCategory(category);
    }

    @PutMapping
    public void updateCategory (@RequestBody CategoryEntity category) throws Exception {
        categoryLogic.updateCategory(category);
    }

    @DeleteMapping("{categoryId}")
    public void removeCategory (@PathVariable ("categoryId") long id) throws Exception {
        categoryLogic.remove(id);
    }

    @GetMapping("{categoryId}")
    public CategoryEntity getCategory(@PathVariable("categoryId") long id) throws Exception {
        CategoryEntity category = categoryLogic.getCategory(id);
        return category;
    }

    @GetMapping
    public List<Category> getAllCategories(@RequestParam("page") int page) throws ServerException {
        List<Category> categories = categoryLogic.getAllCategories(page);
        return categories;
    }

    @GetMapping("/byName")
    public List<Category> getAllCategoriesByNameOrder(@RequestParam("page") int page) throws Exception {
        List<Category> categories = categoryLogic.getAllCategoriesByNameOrder(page);
        return categories;
    }

}
