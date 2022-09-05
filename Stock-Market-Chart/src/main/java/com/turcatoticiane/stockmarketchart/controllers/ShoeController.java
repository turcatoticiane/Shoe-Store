package com.turcatoticiane.stockmarketchart.controllers;

import com.turcatoticiane.stockmarketchart.commands.ShoeDto;
import com.turcatoticiane.stockmarketchart.commands.ShoeForm;
import com.turcatoticiane.stockmarketchart.models.Shoe;
import com.turcatoticiane.stockmarketchart.persistence.ShoeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

/**
 * REST controller responsible for {@link Shoe} related CRUD operations
 */
@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/")
public class ShoeController {

    @Autowired
    private ShoeRepository repository;

    /**
     * Retrieves a representation of the list of shoes
     * @param name if you want to search by the shoe name
     * @return the response entity
     */
    @GetMapping
    public ResponseEntity<List<ShoeDto>> list(String name){
        if (name == null){
            List<ShoeDto> list = ShoeDto.convert(repository.findAll());
            return ResponseEntity.ok(list);
        } else {
            List<ShoeDto> list = ShoeDto.convert(repository.findByShoename(name));
            return ResponseEntity.ok(list);
        }
    }

    /**
     * Retrieves a representation of the shoe by this id
     * @param id of the shoe
     * @return the response entity
     */
    @GetMapping("/{id}")
    public ResponseEntity<ShoeDto> findShoe(@PathVariable Integer id){

        Optional<Shoe> optional = repository.findById(id);

        if(optional.isPresent()){
            return ResponseEntity.ok(new ShoeDto(optional.get()));
        }
        return ResponseEntity.notFound().build();
    }

    /**
     * Add a new shoe for the list
     * @param shoe information about new shoe
     * @return the reponse entity
     */
    @PostMapping
    @Transactional
    public ResponseEntity<?> addShoe(@RequestBody Shoe shoe) {
        Shoe newShoe = repository.save(shoe);

        return new ResponseEntity<>(newShoe, HttpStatus.CREATED);
    }

    /**
     * Update information of the shoe with the received id
     * @param id of the shoe
     * @param form information in the client form
     * @return the response entity
     */
    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<ShoeDto> update(@PathVariable Integer id, @RequestBody @Valid ShoeForm form) {

        Optional<Shoe> optional = repository.findById(id);

        if (optional.isPresent()) {
            Shoe income = form.update(id, repository);
            return ResponseEntity.ok(new ShoeDto(income));
        }

        return ResponseEntity.notFound().build();
    }

    /**
     * Delete the shoe of the received id
     * @param id of the shoe
     * @return the response entity
     */
    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<?> delete(@PathVariable Integer id){

        Optional<Shoe> optional = repository.findById(id);

        if (optional.isPresent()) {
            repository.deleteById(id);
            return ResponseEntity.ok().build();
        }

        return ResponseEntity.notFound().build();
    }


}
