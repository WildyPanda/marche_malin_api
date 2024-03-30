package com.epsi.marche_malin_api.controller;

import com.epsi.marche_malin_api.entities.Categories;
import com.epsi.marche_malin_api.repositories.CategoriesRepo;
import org.hibernate.dialect.unique.CreateTableUniqueDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/category")
@CrossOrigin
public class CategoriesController {
    @Autowired
    CategoriesRepo repo;

    @GetMapping("/public/getAll")
    public List<String> getAllCategories(){
        List<Categories> categories = repo.findAll();
        List<String> categoriesName = new ArrayList<>();
        categories.forEach((elt) -> categoriesName.add(elt.getNameCategory()));
        return categoriesName;
    }
}
