package com.servicesImpl;

import com.dto.OrdreEnseignementDto;
import com.entities.OrdreEnseignement;
import com.exceptions.ResourceNotFoundException;
import com.mappers.EntityMapper;
import com.repository.OrdreEnseignementRepository;
import org.springframework.data.domain.Sort;
import com.services.OrdreEnseignementService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class OrdreEnseignementServiceImp implements OrdreEnseignementService {

    private OrdreEnseignementRepository ordreEnseignementRepository;
    private EntityMapper entityMapper;

    public OrdreEnseignementServiceImp(OrdreEnseignementRepository ordreEnseignementRepository, EntityMapper entityMapper){

        this.ordreEnseignementRepository = ordreEnseignementRepository;
        this.entityMapper = entityMapper;
    }

    @Override
    public List<OrdreEnseignementDto> findAll() {
        List<OrdreEnseignement>ordreEnseignements = this.ordreEnseignementRepository.findAll(Sort.by("code"));
        return ordreEnseignements.stream().map(p -> this.entityMapper.ordreEnseignementToOrdreEnseignementDto(p)).collect(Collectors.toList());
    }

    @Override
    public OrdreEnseignementDto findById(String code) {
        OrdreEnseignement ordreEnseignement = this.ordreEnseignementRepository.findById(code)
                .orElseThrow(() -> new ResourceNotFoundException("OrdreEnseignement", " code", code));
        return this.entityMapper.ordreEnseignementToOrdreEnseignementDto(ordreEnseignement);
    }

    @Override
    public OrdreEnseignementDto save(OrdreEnseignementDto ordreEnseignementDto) {

        OrdreEnseignement ordreEnseignement = this.entityMapper.ordreEnseignementDtoToOrdreEnseignement(ordreEnseignementDto);
        OrdreEnseignement ordreEnseignementSaved = this.ordreEnseignementRepository.save(ordreEnseignement);

        return this.entityMapper.ordreEnseignementToOrdreEnseignementDto(ordreEnseignementSaved);
    }

    @Override
    public OrdreEnseignementDto update(String code, OrdreEnseignementDto ordreEnseignementDto) {
        OrdreEnseignement ordreEnseignement = this.ordreEnseignementRepository.findById(code)
                .orElseThrow(() -> new ResourceNotFoundException("OrdreEnseignement", " code ", code));
        ordreEnseignement.setLibelle(ordreEnseignementDto.getLibelle());

        OrdreEnseignement ordreEnseignementUpdate = this.ordreEnseignementRepository.save(ordreEnseignement);
        return this.entityMapper.ordreEnseignementToOrdreEnseignementDto(ordreEnseignementUpdate);
    }

    @Override
    public void delete(String code) {

        OrdreEnseignement ordreEnseignement = this.ordreEnseignementRepository.findById(code)
                .orElseThrow(() -> new ResourceNotFoundException("OrdreEnseignement", "code", code));
        this.ordreEnseignementRepository.delete(ordreEnseignement);

    }
}
