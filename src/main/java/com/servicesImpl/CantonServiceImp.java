package com.servicesImpl;

import com.dto.CantonDto;
import com.entities.Canton;
import com.exceptions.ResourceNotFoundException;
import com.mappers.EntityMapper;
import org.springframework.data.domain.Sort;
import com.repository.CantonRepository;
import com.services.CantonService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class CantonServiceImp implements CantonService {

    private CantonRepository cantonRepository;
    private EntityMapper entityMapper;

    public CantonServiceImp(CantonRepository cantonRepository, EntityMapper entityMapper){

        this.cantonRepository = cantonRepository;
        this.entityMapper = entityMapper;

    }


    @Override
    public List<CantonDto> findAll() {
        List<Canton> cantons = this.cantonRepository.findAll(Sort.by("code"));
        return cantons.stream().map(p -> this.entityMapper.cantonToCantonDto(p)).collect(Collectors.toList());
    }

    @Override
    public CantonDto findById(String code) {
        Canton canton= this.cantonRepository.findById(code).orElseThrow(() -> new ResourceNotFoundException("Canton", " code", code));
        return this.entityMapper.cantonToCantonDto(canton);
    }

    @Override
    public CantonDto save(CantonDto cantonDto) {

        Canton canton = this.entityMapper.cantonDtoToCanton(cantonDto);
        Canton cantonSaved = this.cantonRepository.save(canton);

        return this.entityMapper.cantonToCantonDto(cantonSaved);
    }

    @Override
    public CantonDto update(String code, CantonDto cantonDto) {
        Canton canton = this.cantonRepository.findById(code)
                .orElseThrow(() -> new ResourceNotFoundException("Canton", " code", code));
        canton.setLibelle(cantonDto.getLibelle());

        Canton  cantonUpdate = this.cantonRepository.save(canton);
        return this.entityMapper.cantonToCantonDto(cantonUpdate);
    }

    @Override
    public void delete(String code) {

        Canton canton= this.cantonRepository.findById(code)
                .orElseThrow(() -> new ResourceNotFoundException("Canton", "code", code));
        this.cantonRepository.delete(canton);
    }
}
