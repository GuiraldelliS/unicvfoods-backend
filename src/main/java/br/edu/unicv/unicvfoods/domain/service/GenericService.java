package br.edu.unicv.unicvfoods.domain.service;

import br.edu.unicv.unicvfoods.domain.configuration.MessageConfiguration;
import br.edu.unicv.unicvfoods.domain.exception.ResourceNotFoundException;
import br.edu.unicv.unicvfoods.domain.model.GenericEntity;
import br.edu.unicv.unicvfoods.domain.repository.GenericRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import javax.transaction.Transactional;

@RequiredArgsConstructor
public abstract class GenericService<T extends GenericEntity<T>> {

    private final GenericRepository<T> repository;
    private final MessageConfiguration messageConfiguration;

    public Page<T> getPage(Pageable pageable) {
        return repository.findAll(pageable);
    }

    public T get(Long id) throws ResourceNotFoundException {
        return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException(messageConfiguration.getEntityNotFoundMessage()));
    }

    @Transactional
    public T create(T newDomain) {
        T dbDomain = newDomain.createNewInstance();
        return repository.save(dbDomain);
    }

    @Transactional
    public T update(Long id, T updated) throws ResourceNotFoundException {
        T dbDomain = get(id);
        dbDomain.update(updated);

        return repository.save(dbDomain);
    }

    @Transactional
    public void delete(Long id) throws ResourceNotFoundException {
        get(id);
        repository.deleteById(id);
    }

}
