package com.servicesImpl;


import com.dto.InspectionDto;
import com.entities.Inspection;
import com.exceptions.ResourceNotFoundException;
import com.mappers.EntityMapper;


import com.services.InspectionService;
import org.springframework.data.domain.Sort;
import com.repository.InspectionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class InspectionServiceImp implements InspectionService {

    private final InspectionRepository inspectionRepository;
    private final EntityMapper entityMapper;

    public InspectionServiceImp(InspectionRepository inspectionRepository, EntityMapper entityMapper) {
        this.inspectionRepository = inspectionRepository;
        this.entityMapper = entityMapper;
    }

    @Override
    public List<InspectionDto> findAll() {
            List<Inspection>inspections = this.inspectionRepository.findAll(Sort.by("numero"));
            return inspections.stream().map(p -> this.entityMapper.inspectionToInspectionDto(p)).collect(Collectors.toList());
    }

    @Override
    public InspectionDto findById(Long id) {
        Inspection inspection = this.inspectionRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Inspection", " numero", id));
        return this.entityMapper.inspectionToInspectionDto(inspection);
    }

    @Override
    public InspectionDto save(InspectionDto inspectionDto) {
        Inspection inspection = this.entityMapper.inspectionDtoToInspection(inspectionDto);
        Inspection inspectionSaved = this.inspectionRepository.save(inspection);

        return this.entityMapper.inspectionToInspectionDto(inspectionSaved);
    }

    @Override
    public InspectionDto update(Long id, InspectionDto inspectionDto) {
        Inspection inspection = this.inspectionRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Inspection", " numero ", id));
        inspection.setLibelle(inspectionDto.getLibelle());

        Inspection inspectionUpdate = this.inspectionRepository.save(inspection);
        return this.entityMapper.inspectionToInspectionDto(inspectionUpdate);
    }

    @Override
    public void delete(Long id) {

        Inspection inspection = this.inspectionRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Inspection", "numero", id));
        this.inspectionRepository.delete(inspection);
    }

}
