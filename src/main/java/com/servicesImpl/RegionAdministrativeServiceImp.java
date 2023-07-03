package com.servicesImpl;

import com.dto.RegionAdministrativeDto;
import com.entities.RegionAdministrative;
import com.exceptions.ResourceNotFoundException;
import com.mappers.EntityMapper;
import org.springframework.data.domain.Sort;
import com.repository.RegionAdministrativeRepository;
import com.services.RegionAdministrativeService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service

public class RegionAdministrativeServiceImp implements RegionAdministrativeService {

    private RegionAdministrativeRepository regionAdministrativeRepository;
    private EntityMapper entityMapper;
    public RegionAdministrativeServiceImp(RegionAdministrativeRepository regionAdministrativeRepository, EntityMapper entityMapper){
        this.regionAdministrativeRepository = regionAdministrativeRepository ;
        this.entityMapper = entityMapper;
    }

    @Override
    public List<RegionAdministrativeDto> findAll() {
        List<RegionAdministrative> regionAdministratives = this.regionAdministrativeRepository.findAll(Sort.by("code"));
        return regionAdministratives.stream().map(p -> this.entityMapper.regionAdministrativeToRegionAdministrativeDto(p)).collect(Collectors.toList());
    }

    @Override
    public RegionAdministrativeDto findById(String code) {
        RegionAdministrative regionAdministrative = this.regionAdministrativeRepository.findById(code).orElseThrow(() -> new ResourceNotFoundException("RegionAdministrative", "code", code));
        return this.entityMapper.regionAdministrativeToRegionAdministrativeDto(regionAdministrative);
    }

    @Override
    public RegionAdministrativeDto save(RegionAdministrativeDto regionAdministrativeDto) {
        RegionAdministrative regionAdministrative = this.entityMapper.regionAdministrativeDtoToRegionAdministrative(regionAdministrativeDto);
        RegionAdministrative regionAdministrativeSaved = this.regionAdministrativeRepository.save(regionAdministrative);

        return this.entityMapper.regionAdministrativeToRegionAdministrativeDto(regionAdministrativeSaved);
    }

    @Override
    public RegionAdministrativeDto update(String code, RegionAdministrativeDto regionAdministrativeDto) {
        RegionAdministrative regionAdministrative = this.regionAdministrativeRepository.findById(code)
                .orElseThrow(() -> new ResourceNotFoundException("RegionAdministrative", " code", code));
        regionAdministrative.setLibelle(regionAdministrativeDto.getLibelle());

        RegionAdministrative regionAdministrativeUpdate = this.regionAdministrativeRepository.save(regionAdministrative);
        return this.entityMapper.regionAdministrativeToRegionAdministrativeDto(regionAdministrativeUpdate);
    }

    @Override
    public void delete(String code) {

        RegionAdministrative regionAdministrative = this.regionAdministrativeRepository.findById(code)
                .orElseThrow(() -> new ResourceNotFoundException("RegionAdministrative", "code", code));
        this.regionAdministrativeRepository.delete(regionAdministrative);
    }
}
