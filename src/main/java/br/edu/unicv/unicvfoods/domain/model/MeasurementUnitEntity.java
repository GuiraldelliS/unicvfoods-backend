package br.edu.unicv.unicvfoods.domain.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity(name = "measurement_unit")
@Data

public class MeasurementUnitEntity implements GenericEntity<MeasurementUnitEntity> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank
    @Size(min = 2, max = 2)
    private String abbreviation;

    @NotBlank
    @Size(min = 5, max = 255)
    private String description;

    @Override
    public void update(MeasurementUnitEntity entity) {
        this.description = entity.description;
        this.abbreviation = entity.abbreviation;
    }

    @Override
    public MeasurementUnitEntity createNewInstance() {

        MeasurementUnitEntity measurementUnitEntity = new MeasurementUnitEntity();
        measurementUnitEntity.update(this);

        return measurementUnitEntity;

    }


}
