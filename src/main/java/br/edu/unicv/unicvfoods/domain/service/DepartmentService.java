package br.edu.unicv.unicvfoods.domain.service;

import br.edu.unicv.unicvfoods.domain.configuration.MessageConfiguration;
import br.edu.unicv.unicvfoods.domain.model.DepartmentEntity;
import br.edu.unicv.unicvfoods.domain.repository.GenericRepository;
import org.springframework.stereotype.Service;

@Service
public class DepartmentService extends GenericService<DepartmentEntity> {

    public DepartmentService(GenericRepository<DepartmentEntity> repository, MessageConfiguration messageConfiguration) {
        super(repository, messageConfiguration);
    }

}
