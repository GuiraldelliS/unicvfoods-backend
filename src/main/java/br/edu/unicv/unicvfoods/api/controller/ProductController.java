package br.edu.unicv.unicvfoods.api.controller;

import br.edu.unicv.unicvfoods.api.dto.ProductDTO;
import br.edu.unicv.unicvfoods.domain.configuration.MessageConfiguration;
import br.edu.unicv.unicvfoods.domain.exception.*;
import br.edu.unicv.unicvfoods.domain.model.*;
import br.edu.unicv.unicvfoods.domain.service.*;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/products")
@AllArgsConstructor
public class ProductController {

    private final ProductService productService;
    private final DepartmentService departmentService;
    private final CategoryService categoryService;
    private final BrandService brandService;
    private final MeasurementUnitService measurementUnitService;

    private final MessageConfiguration messageConfiguration;

    @GetMapping
    public ResponseEntity<Page<ProductEntity>> getPage(Pageable pageable) {
        return ResponseEntity.ok(productService.getPage(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductEntity> get(@PathVariable Long id) throws ResourceNotFoundException {
        return ResponseEntity.ok(productService.get(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductEntity> update(@PathVariable Long id, @RequestBody ProductEntity updated) throws ResourceNotFoundException {
        return ResponseEntity.ok(productService.update(id, updated));
    }

    @PostMapping
    public ResponseEntity<ProductEntity> create(@Valid @RequestBody ProductDTO created) {
        return ResponseEntity.ok(productService.create(this.toEntity(created)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) throws ResourceNotFoundException {
        productService.delete(id);
        return ResponseEntity.noContent().build();
    }

    private ProductEntity toEntity(ProductDTO dto) {

        ProductEntity product = new ProductEntity();
        product.setDescription(dto.getDescription());
        product.setFullDescription(dto.getFullDescription());
        product.setBuyPrice(dto.getBuyPrice());
        product.setSellPrice(dto.getSellPrice());
        product.setStock(dto.getStock());
        product.setSellCount(dto.getSellCount());
        product.setDepartment(this.getDepartmentFromDto(dto));
        product.setCategory(this.getCategoryFromDto(dto));
        product.setBrand(this.getBrandFromDto(dto));
        product.setMeasurementUnit(this.getMeasurementUnitFromDto(dto));

        return product;

    }

    private MeasurementUnitEntity getMeasurementUnitFromDto(ProductDTO dto) {
        MeasurementUnitEntity measurementUnit;
        try {
            measurementUnit = measurementUnitService.get(dto.getMeasurementUnitId());
        } catch (ResourceNotFoundException e) {
            throw new MeasurementUnitNotFoundException(messageConfiguration.getMeasurementUnitNotFoundMessage()
                    .replace("{0}", String.valueOf(dto.getMeasurementUnitId())));
        }
        return measurementUnit;
    }

    private CategoryEntity getCategoryFromDto(ProductDTO dto) {
        CategoryEntity category;
        try {
            category = categoryService.get(dto.getCategoryId());
        } catch (ResourceNotFoundException e) {
            throw new CategoryNotFoundException(messageConfiguration.getCategoryNotFoundMessage()
                    .replace("{0}", String.valueOf(dto.getCategoryId())));
        }
        return category;
    }

    private BrandEntity getBrandFromDto(ProductDTO dto) {
        BrandEntity brand;
        try {
            brand = brandService.get(dto.getBrandId());
        } catch (ResourceNotFoundException e) {
            throw new BrandNotFoundException(messageConfiguration.getBrandNotFoundMessage()
                    .replace("{0}", String.valueOf(dto.getBrandId())));
        }
        return brand;
    }

    private DepartmentEntity getDepartmentFromDto(ProductDTO dto) {
        DepartmentEntity department;
        try {
            department = departmentService.get(dto.getDepartmentId());
        } catch (ResourceNotFoundException e) {
            throw new DepartmentNotFoundException(messageConfiguration.getDepartmentNotFoundMessage()
                    .replace("{0}", String.valueOf(dto.getDepartmentId())));
        }
        return department;
    }

}
