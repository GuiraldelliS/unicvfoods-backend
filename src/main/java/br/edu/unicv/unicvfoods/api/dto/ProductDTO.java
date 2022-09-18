package br.edu.unicv.unicvfoods.api.dto;

import lombok.Data;

@Data
public class ProductDTO {

    private String description;

    private String fullDescription;

    private double buyPrice;

    private double sellPrice;

    private int stock;

    private int sellCount;

    private long brandId;

    private long departmentId;

    private long categoryId;

    private long measurementUnitId;

}
