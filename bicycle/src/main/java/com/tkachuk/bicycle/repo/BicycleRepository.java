package com.tkachuk.bicycle.repo;

import com.tkachuk.bicycle.entity.Bicycle;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface BicycleRepository extends JpaRepository<Bicycle, Long> {

    Optional<Bicycle> findBicycleById(Long id);

    Optional<Long> deleteBicycleById(Long id);

}
