package com.servicesImpl;

import com.dto.AgrementDto;
import com.entities.Agrement;
import com.exceptions.ResourceNotFoundException;
import com.mappers.EntityMapper;
import com.services.AgrementService;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import com.repository.AgrementRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class AgrementServiceImp implements AgrementService {


    private final AgrementRepository agrementRepository;
    private final EntityMapper entityMapper;

    public AgrementServiceImp(AgrementRepository agrementRepository, EntityMapper entityMapper) {
        this.agrementRepository = agrementRepository;
        this.entityMapper = entityMapper;
    }

    @Override
    public List<AgrementDto> findAll() {
        List<Agrement>agrements = this.agrementRepository.findAll(Sort.by("code"));
        return agrements.stream().map(p -> this.entityMapper.agrementToAgrementDto(p)).collect(Collectors.toList());
    }

    @Override
    public AgrementDto findById(String code) {
        Agrement agrement = this.agrementRepository.findById(code)
                .orElseThrow(() -> new ResourceNotFoundException("Agrement", " code", code));
        return this.entityMapper.agrementToAgrementDto(agrement);
    }

    @Override
    public AgrementDto save(AgrementDto agrementDto) {

        Agrement agrement = this.entityMapper.agrementDtoToAgrement(agrementDto);
        Agrement agrementSaved = this.agrementRepository.save(agrement);

        return this.entityMapper.agrementToAgrementDto(agrementSaved);

    }

    @Override
    public AgrementDto update(String code, AgrementDto agrementDto) {
        Agrement agrement = this.agrementRepository.findById(code)
                .orElseThrow(() -> new ResourceNotFoundException("Agrement", " code ", code));
        agrement.setLibelle(agrementDto.getLibelle());

        Agrement  agrementUpdate = this.agrementRepository.save(agrement);
        return this.entityMapper.agrementToAgrementDto(agrementUpdate);

    }

    @Override
    public void delete(String code) {

        Agrement agrement = this.agrementRepository.findById(code)
                .orElseThrow(() -> new ResourceNotFoundException("Agrement", "code", code));
        this.agrementRepository.delete(agrement);

    }
}
