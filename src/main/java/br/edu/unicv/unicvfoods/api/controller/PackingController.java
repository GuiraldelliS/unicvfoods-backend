package br.edu.unicv.unicvfoods.api.controller;

import br.edu.unicv.unicvfoods.domain.model.PackingEntity;
import br.edu.unicv.unicvfoods.domain.service.GenericService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/packing")
public class PackingController extends GenericController<PackingEntity> {
    public PackingController(GenericService<PackingEntity> service) {
        super(service);
    }
}
