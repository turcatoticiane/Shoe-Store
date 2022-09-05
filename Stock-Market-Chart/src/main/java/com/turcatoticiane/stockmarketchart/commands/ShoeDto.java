package com.turcatoticiane.stockmarketchart.commands;

import com.turcatoticiane.stockmarketchart.models.Shoe;

import java.util.List;
import java.util.stream.Collectors;

/**
 * The {@link Shoe} data transfer object
 */
public class ShoeDto {

    private Integer id;
    private String shoename;
    private String description;
    private Integer amount;
    private Integer in_stock;

    /**
     * Constructor to convert Shoe to Shoe data transfer object
     * @param shoe
     */
    public ShoeDto(Shoe shoe) {
        this.id = shoe.getId();
        this.shoename = shoe.getShoename();
        this.description = shoe.getDescription();
        this.amount = shoe.getAmount();
        this.in_stock = shoe.getIn_stock();
    }

    /**
     * To convert the stock list from the database to a data transfer object list
     * @param list list of shoes
     * @return list of shoes data transfer object
     */
    public static List<ShoeDto> convert(List<Shoe> list){
        return list.stream().map(ShoeDto::new).collect(Collectors.toList());
    }

    /**
     * Gets the ShoeDto id
     * @return shoe data transfer object id
     */
    public Integer getId() {
        return id;
    }

    /**
     * Gets the ShoeDto name
     * @return shoe data transfer object name
     */
    public String getShoename() {
        return shoename;
    }

    /**
     * Gets the ShoeDto description
     * @return shoe data transfer object description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Gets the ShoeDto value for sale
     * @return shoe data transfer object value for sale
     */
    public Integer getAmount() {
        return amount;
    }

    /**
     * Gets the ShoeDto quantity in stock
     * @return shoe data transfer object quantity in stock
     */
    public Integer getIn_stock() {
        return in_stock;
    }

}
