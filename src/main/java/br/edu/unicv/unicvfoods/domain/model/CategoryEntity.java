package br.edu.unicv.unicvfoods.domain.model;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity(name = "category")
@Data

public class CategoryEntity implements GenericEntity<CategoryEntity>{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(min=1, max = 60)
    private String name;

    @NotBlank
    @Size(min = 5, max = 255)
    private String description;

    @Override
    public void update(CategoryEntity entity) {
        this.description = entity.description;
        this.name = entity.name;
    }

    @Override
    public CategoryEntity createNewInstance() {
        CategoryEntity categoryEntity = new CategoryEntity();
        categoryEntity.update(this);

        return categoryEntity;
    }
}
