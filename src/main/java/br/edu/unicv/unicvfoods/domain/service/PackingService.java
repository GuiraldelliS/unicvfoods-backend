package br.edu.unicv.unicvfoods.domain.service;

import br.edu.unicv.unicvfoods.domain.configuration.MessageConfiguration;
import br.edu.unicv.unicvfoods.domain.model.PackingEntity;
import br.edu.unicv.unicvfoods.domain.repository.GenericRepository;
import org.springframework.stereotype.Service;

@Service
public class PackingService extends GenericService<PackingEntity> {
    public PackingService(GenericRepository<PackingEntity> repository, MessageConfiguration messageConfiguration) {
        super(repository, messageConfiguration);
    }
}
