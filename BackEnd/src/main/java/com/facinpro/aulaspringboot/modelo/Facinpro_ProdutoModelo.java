package com.facinpro.aulaspringboot.modelo;

import java.io.Serializable;

import java.math.BigDecimal;

import java.util.UUID;

import org.springframework.hateoas.RepresentationModel;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import jakarta.persistence.Id;


@Entity
@Table(name = "TB_PRODUCTS")
public class Facinpro_ProdutoModelo extends RepresentationModel<Facinpro_ProdutoModelo> implements Serializable {

    private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
    private UUID id_product;

    private String name;

    private String description;

    private BigDecimal price;

    private String categoryPath;
    
	private String available;
   
    
    /**
     * @return UUID return the id_product
     */
    public UUID getId_product() {
        return id_product;
    }

    /**
     * @param id_product the id_product to set
     */
    public void setId_product(UUID id_product) {
        this.id_product = id_product;
    }

    /**
     * @return String return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return String return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return BigDecimal return the price
     */
    public BigDecimal getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    /**
     * @return String return the categoryPath
     */
    public String getCategoryPath() {
        return categoryPath;
    }

    /**
     * @param categoryPath the categoryPath to set
     */
    public void setCategoryPath(String categoryPath) {
        this.categoryPath = categoryPath;
    }

    /**
     * @return String return the available
     */
    public String getAvailable() {
        return available;
    }

    /**
     * @param available the available to set
     */
    public void setAvailable(String available) {
        this.available = available;
    }

}
