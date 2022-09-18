package br.edu.unicv.unicvfoods.domain.service;

import br.edu.unicv.unicvfoods.domain.configuration.MessageConfiguration;
import br.edu.unicv.unicvfoods.domain.model.CategoryEntity;
import br.edu.unicv.unicvfoods.domain.repository.GenericRepository;
import org.springframework.stereotype.Service;

@Service
public class CategoryService extends GenericService<CategoryEntity> {
    public CategoryService(GenericRepository<CategoryEntity> repository, MessageConfiguration messageConfiguration) {
        super(repository, messageConfiguration);
    }
}
