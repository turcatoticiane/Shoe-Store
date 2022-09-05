package com.turcatoticiane.stockmarketchart.commands;

import com.turcatoticiane.stockmarketchart.models.Shoe;
import com.turcatoticiane.stockmarketchart.persistence.ShoeRepository;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * The shoe form, responsible for receiving data from the client and add it to the database
 */
public class ShoeForm {

    @NotNull(message = "Product name is mandatory.")
    @NotBlank(message = "Product name is mandatory.")
    private String name;
    @NotNull(message = "Description is mandatory.")
    @NotBlank(message = "Description is mandatory.")
    private String description;
    @NotNull(message = "Amount is mandatory.")
    @NotBlank(message = "Amount is mandatory.")
    private Integer amount;
    @NotNull(message = "Quantity is mandatory.")
    @NotBlank(message = "Quantity is mandatory.")
    private Integer in_stock;

    public Shoe converter(){
        return new Shoe(name, description, amount, in_stock);
    }

    public Shoe update(Integer id, ShoeRepository repository){
        Shoe shoe =repository.getReferenceById(id);
        shoe.setShoename(this.name);
        shoe.setDescription(this.description);
        shoe.setAmount(this.amount);
        shoe.setIn_stock(this.in_stock);

        return shoe;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Integer getIn_stock() {
        return in_stock;
    }

    public void setIn_stock(Integer in_stock) {
        this.in_stock = in_stock;
    }
}
