package com.example.PersonalWorkshop.service.Impl;

import com.example.PersonalWorkshop.dto.vehicle.VehicleRequestDto;
import com.example.PersonalWorkshop.dto.vehicle.VehicleResponseDto;
import com.example.PersonalWorkshop.exception.*;
import com.example.PersonalWorkshop.mapper.GenericMapper;
import com.example.PersonalWorkshop.model.Vehicle;
import com.example.PersonalWorkshop.repository.VehicleRepository;
import com.example.PersonalWorkshop.service.IVehicleService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;


import java.time.LocalDateTime;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class VehicleServiceImpl implements IVehicleService {

    private final VehicleRepository repository;

    private final GenericMapper mapper;

    private final MessageSource messageSource;

    public VehicleResponseDto create(VehicleRequestDto dto){

        try {
            Vehicle entity = mapper.map(dto, Vehicle.class);
            entity = repository.save(entity);
            return mapper.map(entity, VehicleResponseDto.class);
        }catch (Exception e){
            throw new UnableToSaveEntityException(messageSource.getMessage("unable-to-save-vehicle", null, Locale.US));
        }
    }

    public VehicleResponseDto update(VehicleRequestDto dto, Long id){

        Vehicle entity = getVehicleById(id);

        try {
            Vehicle updateEntity = mapper.map(dto, Vehicle.class);
            updateEntity.setId(updateEntity.getId());
            updateEntity.setPlate(entity.getPlate());
            updateEntity.setModel(entity.getModel());
            updateEntity.setBrand(entity.getBrand());
            updateEntity.setYear(entity.getYear());
            updateEntity.setKm(entity.getKm());
            updateEntity.setUserId(entity.getUserId());
            updateEntity.setCreationDate(entity.getUpdateDate());
            updateEntity.setUpdateDate(LocalDateTime.now());
            updateEntity = repository.save(updateEntity);
            return mapper.map(updateEntity, VehicleResponseDto.class);
        }catch (Exception e){
            throw new UnableToUpdateEntityException(messageSource.getMessage("unable-to-update-vehicle", null, Locale.US));
        }
    }

    public void delete(Long id){
        Vehicle entity = getVehicleById(id);
        try {
            entity.setUpdateDate(LocalDateTime.now());
            repository.deleteById(id);
        }catch (Exception e){
            throw new UnableToDeleteEntityException(messageSource.getMessage("unable-to-delete-vehicle", null, Locale.US));
        }
    }

    public List<VehicleResponseDto> findAll(){
        List<Vehicle> vehicles = repository.findAll();
        if (vehicles.isEmpty()){
            throw new EmptyListException(messageSource.getMessage("empty-list", null, Locale.US));
        }
        return mapper.mapAll(vehicles, VehicleResponseDto.class);
    }

    public VehicleResponseDto findVehicleByPlate(String plate){
        List<Vehicle> entitys = repository.findByPlate(plate);
        if (entitys.isEmpty()){
            throw new NotFoundException(messageSource.getMessage("vehicle-not-found-plate", null, Locale.US));
        }
        return mapper.map(entitys, VehicleResponseDto.class);
    }

    public VehicleResponseDto findVehicleByUser(Long id){
        List<Vehicle> entitys = repository.findByUserId(id);
        if (entitys.isEmpty()){
            throw new NotFoundException(messageSource.getMessage("vehicle-not-found-user", null, Locale.US));
        }
        return mapper.map(entitys, VehicleResponseDto.class);
    }

    private Vehicle getVehicleById(Long id){
        Optional<Vehicle> entity = repository.findById(id);
        if (entity.isEmpty()){
            throw new NotFoundException(messageSource.getMessage("vehicle-not-found", null,Locale.US));
        }
        return entity.get();
    }
}
