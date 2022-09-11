package br.edu.unicv.unicvfoods.domain.repository;

import br.edu.unicv.unicvfoods.domain.model.DepartmentModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<DepartmentModel, Long> {
}
