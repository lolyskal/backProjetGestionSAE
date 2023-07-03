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
    public PenaliteObtenuDto findById(String date) {
        PenaliteObtenu penaliteObtenu = this.penaliteObtenuRepository.findById(date).orElseThrow(() -> new ResourceNotFoundException(" PenaliteObtenu", " date", date));
        return this.entityMapper.penaliteObtenuToPenaliteObtenuDto( penaliteObtenu);
    }

    @Override
    public PenaliteObtenuDto save(PenaliteObtenuDto penaliteObtenuDto) {
        PenaliteObtenu penaliteObtenu = this.entityMapper.penaliteObtenuDtoToPenaliteObtenu( penaliteObtenuDto);
        PenaliteObtenu  penaliteObtenuSaved = this.penaliteObtenuRepository.save(penaliteObtenu);

        return this.entityMapper.penaliteObtenuToPenaliteObtenuDto(penaliteObtenuSaved);
    }

    @Override
    public PenaliteObtenuDto update(String date, PenaliteObtenuDto penaliteObtenuDto) {

        PenaliteObtenu penaliteObtenu = this.penaliteObtenuRepository.findById(date)
                .orElseThrow(() -> new ResourceNotFoundException("PenaliteObtenu", "date ", date));
        penaliteObtenu.setMotif(penaliteObtenuDto.getMotif());

        PenaliteObtenu  penaliteObtenuUpdate = this.penaliteObtenuRepository.save(penaliteObtenu);
        return this.entityMapper.penaliteObtenuToPenaliteObtenuDto(penaliteObtenuUpdate);
    }

    @Override
    public void delete(String date) {

        PenaliteObtenu  penaliteObtenu= this.penaliteObtenuRepository.findById(date)
                .orElseThrow(() -> new ResourceNotFoundException("PenaliteObtenuObtenu", "date", date));
        this.penaliteObtenuRepository.delete(penaliteObtenu);

    }
}
