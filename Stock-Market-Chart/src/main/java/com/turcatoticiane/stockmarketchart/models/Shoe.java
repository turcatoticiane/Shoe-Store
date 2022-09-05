package com.turcatoticiane.stockmarketchart.models;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * The shoe model entity
 */
@Entity
@Table(name = "shoes")
public class Shoe extends AbstractModel{

    private String shoename;
    private String description;
    private Integer amount;
    private Integer in_stock;

    /**
     * Default constructor
     */
    public Shoe() {
    }

    /**
     * Constructor with parameters
     * @param shoename      for the Shoe
     * @param description   for the Shoe
     * @param amount        for teh Shoe
     * @param in_stock      for the Shoe
     */
    public Shoe(String shoename, String description, Integer amount, Integer in_stock) {
        this.shoename = shoename;
        this.description = description;
        this.amount = amount;
        this.in_stock = in_stock;
    }

    /**
     * Gets shoe name
     * @return shoe name
     */
    public String getShoename() {
        return shoename;
    }

    /**
     * Sets shoe name
     * @param shoe_name
     */
    public void setShoename(String shoe_name) {
        this.shoename = shoe_name;
    }

    /**
     * Gets shoe description
     * @return shoe description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets shoe description
     * @param description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Gets shoe value for sale
     * @return shoe value for sale
     */
    public Integer getAmount() {
        return amount;
    }

    /**
     * Sets shoe value for sale
     * @param amount
     */
    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    /**
     * Gets shoe quantity in stock
     * @return shoe quantity in stock
     */
    public Integer getIn_stock() {
        return in_stock;
    }

    /**
     * Sets shoe quantity in stock
     * @param in_stock
     */
    public void setIn_stock(Integer in_stock) {
        this.in_stock = in_stock;
    }
}
