package br.edu.unicv.unicvfoods.domain.service;

import br.edu.unicv.unicvfoods.domain.configuration.MessageConfiguration;
import br.edu.unicv.unicvfoods.domain.model.BrandEntity;
import br.edu.unicv.unicvfoods.domain.repository.GenericRepository;
import org.springframework.stereotype.Service;

@Service
public class BrandService extends GenericService<BrandEntity> {

    public BrandService(GenericRepository<BrandEntity> repository, MessageConfiguration messageConfiguration) {
        super(repository, messageConfiguration);
    }

}
