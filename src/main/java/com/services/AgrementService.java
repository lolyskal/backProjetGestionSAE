package com.services;

import com.dto.AgrementDto;

import java.util.List;

public interface AgrementService {

    List<AgrementDto> findAll();

    AgrementDto findById(Long id);

    AgrementDto save(AgrementDto agrementDto);

    AgrementDto update(Long id, AgrementDto agrementDto);

    void delete(Long code);
}
