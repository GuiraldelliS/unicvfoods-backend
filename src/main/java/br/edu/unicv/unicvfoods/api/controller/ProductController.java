package br.edu.unicv.unicvfoods.api.controller;

import br.edu.unicv.unicvfoods.domain.model.ProductEntity;
import br.edu.unicv.unicvfoods.domain.service.GenericService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public class ProductController extends GenericController<ProductEntity> {

    public ProductController(GenericService<ProductEntity> service) {
        super(service);
    }

}
