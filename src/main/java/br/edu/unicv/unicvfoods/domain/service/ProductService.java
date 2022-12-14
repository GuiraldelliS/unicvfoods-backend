package br.edu.unicv.unicvfoods.domain.service;

import br.edu.unicv.unicvfoods.domain.configuration.MessageConfiguration;
import br.edu.unicv.unicvfoods.domain.model.ProductEntity;
import br.edu.unicv.unicvfoods.domain.repository.GenericRepository;
import org.springframework.stereotype.Service;

@Service
public class ProductService extends GenericService<ProductEntity> {
    public ProductService(GenericRepository<ProductEntity> repository, MessageConfiguration messageConfiguration) {
        super(repository, messageConfiguration);
    }
}
