package com.servicesImpl;

import com.dto.SanctionObtenuDto;
import com.entities.SanctionObtenu;
import com.exceptions.ResourceNotFoundException;
import com.mappers.EntityMapper;
import org.springframework.data.domain.Sort;
import com.repository.SanctionObtenuRepository;
import com.services.SanctionObtenuService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service

public class SanctionObtenuServiceImp implements SanctionObtenuService {

    private SanctionObtenuRepository sanctionObtenuRepository;
    private EntityMapper entityMapper ;
    public SanctionObtenuServiceImp(SanctionObtenuRepository sanctionObtenuRepository, EntityMapper entityMapper ){
        this.sanctionObtenuRepository = sanctionObtenuRepository;
        this.entityMapper = entityMapper;
    }

    @Override
    public List<SanctionObtenuDto> findAll() {

        List<SanctionObtenu> sanctionObtenus = this.sanctionObtenuRepository.findAll(Sort.by("date"));
        return sanctionObtenus.stream().map(p -> this.entityMapper.sanctionObtenuToSanctionObtenuDto(p)).collect(Collectors.toList());
    }

    @Override
    public SanctionObtenuDto findById(String date) {
        SanctionObtenu sanctionObtenu = this.sanctionObtenuRepository.findById(date).orElseThrow(() -> new ResourceNotFoundException("SanctionObtenu", "date", date));
        return this.entityMapper.sanctionObtenuToSanctionObtenuDto(sanctionObtenu);
    }

    @Override
    public SanctionObtenuDto save(SanctionObtenuDto sanctionObtenuDto) {

        SanctionObtenu sanctionObtenu = this.entityMapper.sanctionObtenuDtoToSanctionObtenu(sanctionObtenuDto);
        SanctionObtenu sanctionObtenuSaved = this.sanctionObtenuRepository.save(sanctionObtenu);

        return this.entityMapper.sanctionObtenuToSanctionObtenuDto(sanctionObtenuSaved);
    }

    @Override
    public SanctionObtenuDto update(String date, SanctionObtenuDto sanctionObtenuDto) {

        SanctionObtenu sanctionObtenu = this.sanctionObtenuRepository.findById(date)
                .orElseThrow(() -> new ResourceNotFoundException("SanctionObtenu", " date", date));
        sanctionObtenu.setMotif(sanctionObtenuDto.getMotif());

        SanctionObtenu sanctionObtenuUpdate = this.sanctionObtenuRepository.save(sanctionObtenu);
        return this.entityMapper.sanctionObtenuToSanctionObtenuDto(sanctionObtenuUpdate);
    }

    @Override
    public void delete(String date) {

        SanctionObtenu sanctionObtenu = this.sanctionObtenuRepository.findById(date)
                .orElseThrow(() -> new ResourceNotFoundException("SanctionObtenu", "date", date));
        this.sanctionObtenuRepository.delete(sanctionObtenu);
    }
}
