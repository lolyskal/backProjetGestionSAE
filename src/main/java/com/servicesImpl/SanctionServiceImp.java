package com.servicesImpl;

import com.dto.SanctionDto;
import com.entities.Sanction;
import com.exceptions.ResourceNotFoundException;
import com.mappers.EntityMapper;
import org.springframework.data.domain.Sort;
import com.repository.SanctionRepository;
import com.services.SanctionService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class SanctionServiceImp implements SanctionService {
    private SanctionRepository sanctionRepository;
    private EntityMapper entityMapper;
    public SanctionServiceImp(SanctionRepository sanctionRepository, EntityMapper entityMapper ){
        this.sanctionRepository = sanctionRepository;
        this.entityMapper = entityMapper;
    }

    @Override
    public List<SanctionDto> findAll() {
        List<Sanction> sanctions = this.sanctionRepository.findAll(Sort.by("code"));
        return sanctions.stream().map(p -> this.entityMapper.sanctionToSanctionDto(p)).collect(Collectors.toList());
    }

    @Override
    public SanctionDto findById(String code) {
        Sanction sanction = this.sanctionRepository.findById(code).orElseThrow(() -> new ResourceNotFoundException("Sanction", "code", code));
        return this.entityMapper.sanctionToSanctionDto(sanction);
    }

    @Override
    public SanctionDto save(SanctionDto sanctionDto) {
        Sanction sanction= this.entityMapper.sanctionDtoToSanction(sanctionDto);
        Sanction sanctionSaved = this.sanctionRepository.save(sanction);

        return this.entityMapper.sanctionToSanctionDto(sanctionSaved);
    }

    @Override
    public SanctionDto update(String code, SanctionDto sanctionDto) {
        Sanction sanction = this.sanctionRepository.findById(code)
                .orElseThrow(() -> new ResourceNotFoundException("Sanction", " code",code));
        sanction.setLibelle(sanctionDto.getLibelle());

        Sanction sanctionUpdate = this.sanctionRepository.save(sanction);
        return this.entityMapper.sanctionToSanctionDto(sanctionUpdate);
    }

    @Override
    public void delete(String code) {

        Sanction sanction = this.sanctionRepository.findById(code)
                .orElseThrow(() -> new ResourceNotFoundException("Sanction", "code", code));
        this.sanctionRepository.delete(sanction);
    }
}
