package br.edu.unicv.unicvfoods.domain.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity(name = "product")
@Data
public class ProductEntity implements GenericEntityInterface<ProductEntity> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank
    @Size(min = 3, max = 50)
    private String description;
    @NotEmpty
    private String fullDescription;
    @NotNull
    @PositiveOrZero
    private double buyPrice;
    @NotNull
    @PositiveOrZero
    private double sellPrice;
    @NotNull
    @PositiveOrZero
    private int stock;
    @NotNull
    @PositiveOrZero
    private int sellCount;

    @ManyToOne
    @JoinColumn(name = "brand_id")
    @NotNull
    private BrandEntity brand;
    @ManyToOne
    @JoinColumn(name = "department_id")
    @NotNull
    private DepartmentEntity department;
    @ManyToOne
    @JoinColumn(name = "category_id")
    @NotNull
    private CategoryEntity category;
    @ManyToOne
    @JoinColumn(name = "measurement_unit_id")
    @NotNull
    private MeasurementUnitEntity measurementUnit;

    @Override
    public void update(ProductEntity entity) {
        this.description = entity.description;
        this.fullDescription = entity.fullDescription;
        this.buyPrice = entity.buyPrice;
        this.sellPrice = entity.sellPrice;
        this.stock = entity.stock;
        this.sellCount = entity.sellCount;
        this.brand = entity.brand;
        this.department = entity.department;
        this.category = entity.category;
        this.measurementUnit = entity.measurementUnit;
    }

    @Override
    public ProductEntity createNewInstance() {
        ProductEntity productEntity = new ProductEntity();
        productEntity.update(this);
        return productEntity;
    }
}
