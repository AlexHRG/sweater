package com.example.sweater.repos;

import com.example.sweater.domain.Bird;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface BirdRepo extends CrudRepository<Bird, Long> {
    List<Bird> findAll();
    Bird findByName(String name);
}
