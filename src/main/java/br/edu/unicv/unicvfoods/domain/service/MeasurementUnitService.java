package br.edu.unicv.unicvfoods.domain.service;

import br.edu.unicv.unicvfoods.domain.configuration.MessageConfiguration;
import br.edu.unicv.unicvfoods.domain.model.MeasurementUnitEntity;
import br.edu.unicv.unicvfoods.domain.repository.GenericRepository;
import org.springframework.stereotype.Service;

@Service
public class MeasurementUnitService extends GenericService<MeasurementUnitEntity>{
    public MeasurementUnitService(GenericRepository<MeasurementUnitEntity> repository, MessageConfiguration messageConfiguration) {
        super(repository, messageConfiguration);
    }
}
