package com.servicesImpl;

import com.dto.PenaliteObtenuDto;
import com.entities.PenaliteObtenu;
import com.exceptions.ResourceNotFoundException;
import com.mappers.EntityMapper;
import com.repository.PenaliteObtenuRepository;
import com.services.PenaliteObtenuService;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service

public class PenaliteObtenuServiceImp implements PenaliteObtenuService {

    private PenaliteObtenuRepository penaliteObtenuRepository;
    private EntityMapper entityMapper;

    public PenaliteObtenuServiceImp(PenaliteObtenuRepository penaliteObtenuRepository, EntityMapper entityMapper ){

        this.penaliteObtenuRepository = penaliteObtenuRepository;
        this.entityMapper = entityMapper ;
    }

    @Override
    public List<PenaliteObtenuDto> findAll() {
        List<PenaliteObtenu>penaliteObtenus = this.penaliteObtenuRepository.findAll(Sort.by("date"));
        return penaliteObtenus.stream().map(p -> this.entityMapper.penaliteObtenuToPenaliteObtenuDto(p)).collect(Collectors.toList());

    }

    @Override
    public PenaliteObtenuDto findById(Long id) {
        PenaliteObtenu penaliteObtenu = this.penaliteObtenuRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(" PenaliteObtenu", " ID", id));
        return this.entityMapper.penaliteObtenuToPenaliteObtenuDto( penaliteObtenu);
    }

    @Override
    public PenaliteObtenuDto save(PenaliteObtenuDto penaliteObtenuDto) {
        PenaliteObtenu penaliteObtenu = this.entityMapper.penaliteObtenuDtoToPenaliteObtenu(penaliteObtenuDto);
        PenaliteObtenu  penaliteObtenuSaved = this.penaliteObtenuRepository.save(penaliteObtenu);
        return this.entityMapper.penaliteObtenuToPenaliteObtenuDto(penaliteObtenuSaved);
    }

    @Override
    public PenaliteObtenuDto update(Long id, PenaliteObtenuDto penaliteObtenuDto) {

        PenaliteObtenu penaliteObtenu = this.penaliteObtenuRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("PenaliteObtenu", "date ", id));
        penaliteObtenu.setMotif(penaliteObtenuDto.getMotif());

        PenaliteObtenu  penaliteObtenuUpdate = this.penaliteObtenuRepository.save(penaliteObtenu);
        return this.entityMapper.penaliteObtenuToPenaliteObtenuDto(penaliteObtenuUpdate);
    }

    @Override
    public void delete(Long id) {

        PenaliteObtenu  penaliteObtenu= this.penaliteObtenuRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("PenaliteObtenuObtenu", "ID", id));
        this.penaliteObtenuRepository.delete(penaliteObtenu);

    }
}
