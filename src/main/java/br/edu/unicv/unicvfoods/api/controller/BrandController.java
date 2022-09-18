package br.edu.unicv.unicvfoods.api.controller;

import br.edu.unicv.unicvfoods.domain.model.BrandEntity;
import br.edu.unicv.unicvfoods.domain.service.GenericService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/brands")
public class BrandController extends GenericController<BrandEntity> {

    public BrandController(GenericService<BrandEntity> service) {
        super(service);
    }


}
