package br.edu.unicv.unicvfoods.domain.model;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity(name = "department")
@Data
public class DepartmentEntity implements GenericEntityInterface<DepartmentEntity> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank
    @Size(min = 5, max = 255)
    private String description;

    @Override
    public void update(DepartmentEntity entity) {
        this.description = entity.description;
    }

    @Override
    public DepartmentEntity createNewInstance() {

        DepartmentEntity departmentEntity = new DepartmentEntity();
        departmentEntity.update(this);

        return departmentEntity;

    }
}
