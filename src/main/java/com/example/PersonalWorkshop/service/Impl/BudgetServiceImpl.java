package com.example.PersonalWorkshop.service.Impl;

import com.example.PersonalWorkshop.dto.budget.BudgetRequestDto;
import com.example.PersonalWorkshop.dto.budget.BudgetResponseDto;
import com.example.PersonalWorkshop.exception.*;
import com.example.PersonalWorkshop.mapper.GenericMapper;
import com.example.PersonalWorkshop.model.Budget;
import com.example.PersonalWorkshop.repository.BudgetRepository;
import com.example.PersonalWorkshop.service.IBudgetService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BudgetServiceImpl implements IBudgetService {

    private final BudgetRepository repository;

    private final GenericMapper mapper;

    private final MessageSource messageSource;

    public BudgetResponseDto create(BudgetRequestDto dto){

            try {
                Budget entity = mapper.map(dto, Budget.class);
                entity = repository.save(entity);
                return mapper.map(entity, BudgetResponseDto.class);
            }catch (Exception e){
                throw new UnableToSaveEntityException(messageSource.getMessage("unable-to-save-budget", null, Locale.US));
            }
    }

    public BudgetResponseDto update (BudgetRequestDto dto, Long id){

        Budget entity = getBudgetById(id);

        try {
            Budget updateEntity = mapper.map(dto, Budget.class);
            updateEntity.setId(entity.getId());
            updateEntity.setVehicleId(entity.getVehicleId());
            updateEntity.setUserId(entity.getUserId());
            updateEntity.setFaultDescription(entity.getFaultDescription());
            updateEntity.setQuantity(entity.getQuantity());
            updateEntity.setDetail(entity.getDetail());
            updateEntity.setPrice(entity.getPrice());
            updateEntity.setCreationDate(entity.getCreationDate());
            updateEntity.setUpdateDate(LocalDateTime.now());
            updateEntity = repository.save(updateEntity);
            return mapper.map(updateEntity, BudgetResponseDto.class);

        }catch (Exception e){
            throw new UnableToUpdateEntityException(messageSource.getMessage("unable-to-update-budget", new Object[] {id}, Locale.US));
        }
    }

    public void delete(Long id){
        Budget entity = getBudgetById(id);
        try {
            entity.setUpdateDate(LocalDateTime.now());
            repository.deleteById(id);
        }catch (Exception e){
            throw new UnableToDeleteEntityException(messageSource.getMessage("unable-to-delete-budget", new Object[] {id}, Locale.US));
        }
    }

    public List<BudgetResponseDto> findAll(){
        List<Budget> budgets = repository.findAll();
        if (budgets.isEmpty()){
        throw new EmptyListException(messageSource.getMessage("empty-list",null, Locale.US));
        }
        return mapper.mapAll(budgets, BudgetResponseDto.class);
    }

    public List<BudgetResponseDto> findBudgetsByVehicleId(Long id){
        List<Budget> budgets = repository.findBudgetsByVehicleId(id);
        if (budgets.isEmpty()){
            throw new EmptyListException(messageSource.getMessage("empty-list", null, Locale.US));
        }
        return mapper.mapAll(budgets, BudgetResponseDto.class);
    }



    private Budget getBudgetById(Long id){
        Optional<Budget> entity = repository.findById(id);
        if(entity.isEmpty()){
            throw new NotFoundException(messageSource.getMessage("budget-not-found", new Object[] {id} ,Locale.US));
        }
        return entity.get();
    }

}
