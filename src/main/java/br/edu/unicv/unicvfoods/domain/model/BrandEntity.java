package br.edu.unicv.unicvfoods.domain.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity(name = "brand")
@Data
public class BrandEntity implements GenericEntity<BrandEntity> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank
    @Size(min = 5, max = 255)
    private String description;

    @Override
    public void update(BrandEntity entity) {
        this.description = entity.description;
    }

    @Override
    public BrandEntity createNewInstance() {

        BrandEntity brandEntity = new BrandEntity();
        brandEntity.update(this);

        return brandEntity;

    }
}
