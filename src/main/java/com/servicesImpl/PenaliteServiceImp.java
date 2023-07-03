package com.servicesImpl;

import com.dto.PenaliteDto;
import com.entities.Penalite;
import com.exceptions.ResourceNotFoundException;
import com.mappers.EntityMapper;
import org.springframework.data.domain.Sort;
import com.repository.PenaliteRepository;
import com.services.PenaliteService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service

public class PenaliteServiceImp implements PenaliteService {

    private PenaliteRepository penaliteRepository;

    private EntityMapper entityMapper;


    public PenaliteServiceImp(PenaliteRepository penaliteRepository, EntityMapper entityMapper) {
        this.penaliteRepository = penaliteRepository;
        this.entityMapper = entityMapper;
}
    @Override
    public List<PenaliteDto> findAll() {
            List<Penalite> penalites = this.penaliteRepository.findAll(Sort.by("typePenalite"));
            return penalites.stream().map(p -> this.entityMapper.penaliteToPenaliteDto(p)).collect(Collectors.toList());
    }

    @Override
    public PenaliteDto findById(String typePenalite) {

        Penalite penalite = this.penaliteRepository.findById(typePenalite).orElseThrow(() -> new ResourceNotFoundException("Penalite", " typePenalite", typePenalite));
        return this.entityMapper.penaliteToPenaliteDto(penalite);
    }

    @Override
    public PenaliteDto save(PenaliteDto penaliteDto) {

        Penalite penalite= this.entityMapper.penaliteDtoToPenalite(penaliteDto);
        Penalite penaliteSaved = this.penaliteRepository.save(penalite);

        return this.entityMapper.penaliteToPenaliteDto(penaliteSaved);
    }

    @Override
    public PenaliteDto update(String typePenalite, PenaliteDto penaliteDto) {
        Penalite penalite = this.penaliteRepository.findById(typePenalite)
                .orElseThrow(() -> new ResourceNotFoundException("Penalite", "typePenalite ", typePenalite));
        penalite.setDuree(penaliteDto.getDuree());
        Penalite penaliteUpdate = this.penaliteRepository.save(penalite);
        return this.entityMapper.penaliteToPenaliteDto(penaliteUpdate);
    }

    @Override
    public void delete(String typePenalite) {
        Penalite penalite = this.penaliteRepository.findById(typePenalite)
                .orElseThrow(() -> new ResourceNotFoundException("AgrementObtenu", "typePenalite", typePenalite));
        this.penaliteRepository.delete(penalite);

    }
}
