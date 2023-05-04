package com.example.PersonalWorkshop.service.Impl;

import com.example.PersonalWorkshop.dto.budget.BudgetRequestDto;
import com.example.PersonalWorkshop.dto.budget.BudgetResponseDto;
import com.example.PersonalWorkshop.mapper.GenericMapper;
import com.example.PersonalWorkshop.repository.BudgetRepository;
import com.example.PersonalWorkshop.service.IBudgetService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BudgetServiceImpl implements IBudgetService {

    private final BudgetRepository budgetRepository;

    private final GenericMapper genericMapper;

    private final MessageSource messageSource;

    public BudgetResponseDto create(BudgetRequestDto dto){



    }

}
