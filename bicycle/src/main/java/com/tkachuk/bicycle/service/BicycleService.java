package com.tkachuk.bicycle.service;

import com.tkachuk.bicycle.entity.Comment;
import com.tkachuk.bicycle.entity.DTO.BicycleDTO;
import com.tkachuk.bicycle.entity.DTO.CommentDTO;
import com.tkachuk.bicycle.entity.UserEntity;
import lombok.AllArgsConstructor;
import com.tkachuk.bicycle.entity.Bicycle;
import com.tkachuk.bicycle.exception.BicycleNotFoundException;
import com.tkachuk.bicycle.repo.BicycleRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@AllArgsConstructor
@Transactional
public class BicycleService {
    BicycleRepository bicycleRepository;



    public Bicycle findBicycleById(Long id) {
        return bicycleRepository.findBicycleById(id)
                .orElseThrow(() -> new BicycleNotFoundException("Computer was not found with id: " + id));
    }

    public BicycleDTO findBicycleDtoById(Long id) {
        Bicycle newBicycle = this.findBicycleById(id);
        return convertToDto(newBicycle);
    }

    public List<Bicycle> findAllBicycles() {
        return bicycleRepository.findAll();
    }


    public Bicycle addBicycle(Bicycle bicycle) {
        bicycle.setCommentCount(0);
        bicycle.setMarkCount(0);
        bicycle.setMark(0.0);
        return bicycleRepository.save(bicycle);
    }

    public Bicycle updateBicycle(Bicycle bicycle) {
        System.out.println(bicycle.getMark());
        return bicycleRepository.save(bicycle);
    }

    public Long deleteBicycle(Long id) {
        return bicycleRepository.deleteBicycleById(id).orElseThrow(() -> new BicycleNotFoundException("Cannot delete bicycle with id: "  + id
        + ", because there is no such id"));
    }

    private BicycleDTO convertToDto(Bicycle bicycle) {
        return new BicycleDTO(bicycle.getId(), bicycle.getBrand(), bicycle.getModel(), bicycle.getYear(), bicycle.getImageUrl(),
                bicycle.getPrice(), bicycle.getMark());
    }

}
