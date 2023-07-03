package com.services;

import com.dto.AgrementDto;

import java.util.List;

public interface AgrementService {

    List<AgrementDto> findAll();

    AgrementDto findById(String code);

    AgrementDto save(AgrementDto agrementDto);

    AgrementDto update(String code, AgrementDto agrementDto);

    void delete(String code);
}
