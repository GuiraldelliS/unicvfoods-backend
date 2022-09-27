package br.edu.unicv.unicvfoods.domain.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

@Data
@Entity(name = "packing")
public class PackingEntity implements GenericEntityInterface<PackingEntity> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank
    @Size(min = 5, max = 30)
    private String name;

    @NotNull
    @Positive
    private int unitsInPack;

    @Override
    public void update(PackingEntity entity) {
        this.name = entity.name;
        this.unitsInPack = entity.unitsInPack;
    }

    @Override
    public PackingEntity createNewInstance() {
        PackingEntity packingEntity = new PackingEntity();
        packingEntity.update(this);
        return packingEntity;
    }

}
