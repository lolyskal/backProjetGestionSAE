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
    public SanctionObtenuDto findById(Long id) {
        SanctionObtenu sanctionObtenu = this.sanctionObtenuRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("SanctionObtenu", "date", id));
        return this.entityMapper.sanctionObtenuToSanctionObtenuDto(sanctionObtenu);
    }

    @Override
    public SanctionObtenuDto save(SanctionObtenuDto sanctionObtenuDto) {

        SanctionObtenu sanctionObtenu = this.entityMapper.sanctionObtenuDtoToSanctionObtenu(sanctionObtenuDto);
        SanctionObtenu sanctionObtenuSaved = this.sanctionObtenuRepository.save(sanctionObtenu);

        return this.entityMapper.sanctionObtenuToSanctionObtenuDto(sanctionObtenuSaved);
    }

    @Override
    public SanctionObtenuDto update(Long id, SanctionObtenuDto sanctionObtenuDto) {

        SanctionObtenu sanctionObtenu = this.sanctionObtenuRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("SanctionObtenu", " date", id));
        sanctionObtenu.setMotif(sanctionObtenuDto.getMotif());

        SanctionObtenu sanctionObtenuUpdate = this.sanctionObtenuRepository.save(sanctionObtenu);
        return this.entityMapper.sanctionObtenuToSanctionObtenuDto(sanctionObtenuUpdate);
    }

    @Override
    public void delete(Long id) {

        SanctionObtenu sanctionObtenu = this.sanctionObtenuRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("SanctionObtenu", "date", id));
        this.sanctionObtenuRepository.delete(sanctionObtenu);
    }
}
