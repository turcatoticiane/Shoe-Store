package com.turcatoticiane.stockmarketchart.persistence;

import com.turcatoticiane.stockmarketchart.models.Shoe;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Interface which provides CRUD methods for the IncomeController
 */
public interface ShoeRepository extends JpaRepository<Shoe, Integer> {

    /**
     * Gets the list of the name by their name
     * @param shoename in the URL
     * @return the shoe
     */
    List<Shoe> findByShoename(String shoename);

}
