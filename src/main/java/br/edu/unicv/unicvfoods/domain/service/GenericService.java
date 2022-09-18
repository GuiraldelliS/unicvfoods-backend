package br.edu.unicv.unicvfoods.domain.service;

import br.edu.unicv.unicvfoods.domain.configuration.MessageConfiguration;
import br.edu.unicv.unicvfoods.domain.exception.ResourceNotFoundException;
import br.edu.unicv.unicvfoods.domain.model.GenericEntityInterface;
import br.edu.unicv.unicvfoods.domain.repository.GenericRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import javax.persistence.Entity;
import javax.transaction.Transactional;

@RequiredArgsConstructor
@Log4j2
public abstract class GenericService<T extends GenericEntityInterface<T>> {

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

        T savedDomain = repository.save(dbDomain);

        log.info("Created new " + savedDomain.getClass().getSimpleName() + " with id " + savedDomain.getId()
                + " in table " + savedDomain.getClass().getAnnotation(Entity.class).name() + ".");

        return savedDomain;
    }

    @Transactional
    public T update(Long id, T updated) throws ResourceNotFoundException {
        T dbDomain = get(id);
        dbDomain.update(updated);

        log.info("Updating " + dbDomain.getClass().getSimpleName() + " with id " + dbDomain.getId() + " in table "
                + dbDomain.getClass().getAnnotation(Entity.class).name() + ".");

        return repository.save(dbDomain);
    }

    @Transactional
    public void delete(Long id) throws ResourceNotFoundException {
        get(id);

        log.info("Deleting " + get(id).getClass().getSimpleName() + " with id " + id + " of table "
                + get(id).getClass().getAnnotation(Entity.class).name() + ".");

        repository.deleteById(id);
    }

}
