package com.servicesImpl;

import com.dto.RegionEducativeDto;
import com.entities.RegionEducative;
import com.exceptions.ResourceNotFoundException;
import com.mappers.EntityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import com.repository.RegionEducativeRepository;
import com.services.RegionEducativeService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;
@Service
@Transactional
public class RegionEducativeServiceImp implements RegionEducativeService {

    private RegionEducativeRepository regionEducativeRepository;
    private EntityMapper entityMapper;
    @Autowired
    public RegionEducativeServiceImp(RegionEducativeRepository regionEducativeRepository,EntityMapper entityMapper){
        this.regionEducativeRepository = regionEducativeRepository;
        this.entityMapper = entityMapper;
    }

    @Override
    public List<RegionEducativeDto> findAll() {
        List<RegionEducative>regionEducatives = this.regionEducativeRepository.findAll(Sort.by("libelle"));
        return regionEducatives.stream().map(p -> entityMapper.regionEducativeToRegionEducativeDto(p)).collect(Collectors.toList());
    }

    @Override
    public RegionEducativeDto findById(Long id) {
        RegionEducative regionEducative = this.regionEducativeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("RegionEducative", " ID", id));
        return this.entityMapper.regionEducativeToRegionEducativeDto(regionEducative);
    }

    @Override
    public RegionEducativeDto save(RegionEducativeDto regionEducativeDto) {
        RegionEducative regionEducative = this.entityMapper.regionEducativeDtoToRegionEducative(regionEducativeDto);
        RegionEducative regionEducativeSaved = this.regionEducativeRepository.save(regionEducative);

        return this.entityMapper.regionEducativeToRegionEducativeDto(regionEducativeSaved);
    }

    @Override
    public RegionEducativeDto update(Long id, RegionEducativeDto regionEducativeDto) {
        RegionEducative regionEducative = this.regionEducativeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("RegionEducative", " ID", id));
        regionEducative.setZoneCouverture(regionEducativeDto.getZoneCouverture());

        RegionEducative  regionEducativeUpdate = this.regionEducativeRepository.save(regionEducative);
        return this.entityMapper.regionEducativeToRegionEducativeDto(regionEducativeUpdate);
    }

    @Override
    public void delete(Long id) {

        RegionEducative regionEducative= this.regionEducativeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("RegionEducative", "ID", id));
        this.regionEducativeRepository.delete(regionEducative);
    }
}
