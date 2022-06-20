package com.tkachuk.bicycle.resource;

import com.tkachuk.bicycle.entity.Bicycle;
import com.tkachuk.bicycle.entity.DTO.BicycleDTO;
import com.tkachuk.bicycle.service.BicycleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/bicycles")
public class BicycleController {
    private final BicycleService bicycleService;

    public BicycleController(BicycleService bicycleService) {
        this.bicycleService = bicycleService;
    }

    @GetMapping("/all")
    @PreAuthorize("hasAuthority('user:read')")
    public ResponseEntity<List<Bicycle>> findAllBicycles() {
        List<Bicycle> toys = bicycleService.findAllBicycles();
        return new ResponseEntity<>(toys, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    @PreAuthorize("hasAuthority('user:read')")
    public ResponseEntity<BicycleDTO> findBicycleDtoById(@PathVariable("id") Long id) {
        BicycleDTO bicycleDto = bicycleService.findBicycleDtoById(id);
        return new ResponseEntity<>(bicycleDto, HttpStatus.OK);
    }

    @PostMapping("/add")
    @PreAuthorize("hasAuthority('user:read')")
    public ResponseEntity<Bicycle> addToy(@RequestBody Bicycle bicycle) {
        Bicycle newBicycle = bicycleService.addBicycle(bicycle);
        return new ResponseEntity<>(newBicycle, HttpStatus.CREATED);

    }

    @PutMapping("/update")
    @PreAuthorize("hasAuthority('user:read')")
    public ResponseEntity<Bicycle> updateBicycle(@RequestBody Bicycle bicycle) {
       Bicycle updatedBicycle = bicycleService.updateBicycle(bicycle);
        return new ResponseEntity<>(updatedBicycle, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    @PreAuthorize("hasAuthority('user:read')")
    public ResponseEntity<?> deleteBicycle(@PathVariable("id") Long id) {
        bicycleService.deleteBicycle(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
