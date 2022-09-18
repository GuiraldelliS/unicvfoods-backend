package br.edu.unicv.unicvfoods.domain.repository;

import br.edu.unicv.unicvfoods.domain.model.GenericEntityInterface;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface GenericRepository<T extends GenericEntityInterface<T>> extends JpaRepository<T, Long> {
}
