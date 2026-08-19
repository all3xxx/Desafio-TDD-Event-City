package com.devsuperior.bds02.services;

import com.devsuperior.bds02.dto.CityDTO;
import com.devsuperior.bds02.entities.City;
import com.devsuperior.bds02.repositories.CityRepository;
import com.devsuperior.bds02.services.exceptions.DatabaseException;
import com.devsuperior.bds02.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CityService {

    @Autowired
    private CityRepository repository;

    @Transactional(readOnly = true)
    public List<CityDTO> findAllSortedByName() {
        List<City> result = repository.findAll(Sort.by("name"));
        return result.stream().map(city -> new CityDTO(city)).toList();
    }

    @Transactional
    public CityDTO insert(CityDTO dto) {
        City entity = new City(null, dto.getName());
        entity = repository.save(entity);
        return new CityDTO(entity);
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    public void deleteById(Long id) {
        if(!repository.existsById(id)) {
            throw new ResourceNotFoundException("Resource not found");
        }
        try {
            repository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException("Integrity violation");
        }
    }

}
