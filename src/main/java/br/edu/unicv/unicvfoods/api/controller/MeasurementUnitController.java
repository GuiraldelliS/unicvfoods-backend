package br.edu.unicv.unicvfoods.api.controller;

import br.edu.unicv.unicvfoods.domain.model.MeasurementUnitEntity;
import br.edu.unicv.unicvfoods.domain.service.GenericService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/measurement-unit")
public class MeasurementUnitController extends GenericController<MeasurementUnitEntity>{
    public MeasurementUnitController(GenericService<MeasurementUnitEntity> service) {
        super(service);
    }
}
