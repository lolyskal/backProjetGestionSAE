package com.servicesImpl;

import com.dto.CommuneDto;
import com.entities.Commune;
import com.exceptions.ResourceNotFoundException;
import com.mappers.EntityMapper;
import org.springframework.data.domain.Sort;
import com.repository.CommuneRepository;
import com.services.CommuneService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class CommuneServiceImp implements CommuneService {

    private final CommuneRepository communeRepository;

    private final EntityMapper entityMapper;

    public CommuneServiceImp(CommuneRepository communeRepository,EntityMapper entityMapper){

        this.communeRepository = communeRepository;
        this.entityMapper = entityMapper;

    }

    @Override
    public List<CommuneDto> findAll() {
       List<Commune>communes = this.communeRepository.findAll(Sort.by("code"));
       return communes.stream().map(p -> this.entityMapper.communeToCommuneDto(p)).collect(Collectors.toList());
    }

    @Override
    public CommuneDto findById(Long id) {
        Commune commune =   this.communeRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Commune","code", id));
        return this.entityMapper.communeToCommuneDto(commune);
    }

    @Override
    public CommuneDto save(CommuneDto communeDto) {
     Commune commune =   this.entityMapper.communeDtoToCommune(communeDto);
     Commune communeSaved = this.communeRepository.save(commune);
     return this.entityMapper.communeToCommuneDto(communeSaved);

    }

    @Override
    public CommuneDto update(Long id, CommuneDto communeDto) {

        Commune commune = this.communeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Commune", " code ", id));
        commune.setLibelle(communeDto.getLibelle());

        Commune  communeUpdate = this.communeRepository.save(commune);
        return this.entityMapper.communeToCommuneDto(communeUpdate);
    }

    @Override
    public void delete(Long id) {

        Commune commune = this.communeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Commune", "code", id));
        this.communeRepository.delete(commune);

    }
}
