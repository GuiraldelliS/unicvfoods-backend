package br.edu.unicv.unicvfoods.api.controller;

import br.edu.unicv.unicvfoods.domain.model.CategoryEntity;
import br.edu.unicv.unicvfoods.domain.service.GenericService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/categories")
public class CategoryController extends GenericController<CategoryEntity> {
    public CategoryController(GenericService<CategoryEntity> service) {
        super(service);
    }
}
