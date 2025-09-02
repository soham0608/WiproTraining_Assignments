package com.wipro.orderms.dto;

import java.time.LocalDate;

import lombok.Data;

@Data
public class Product {
    int id;
    String prodName;
    String prodDesc;
    String prodCat;
    String make;
    int availableQty;
    double price;
    String uom;
    
    double prodRating;
    String imageURL;
    LocalDate dateOfManufacture;
}