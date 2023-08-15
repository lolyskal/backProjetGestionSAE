package com.servicesImpl;

import com.dto.FraisCycleDto;
import com.entities.FraisCycle;
import com.exceptions.ResourceNotFoundException;
import com.mappers.EntityMapper;
import com.services.FraisCycleService;
import org.springframework.data.domain.Sort;
import com.repository.FraisCycleRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class FraisCycleServiceImp implements FraisCycleService {


    private final FraisCycleRepository fraisCycleRepository;
    private final EntityMapper entityMapper ;

    public FraisCycleServiceImp(FraisCycleRepository fraisCycleRepository,EntityMapper entityMapper){
        this.fraisCycleRepository = fraisCycleRepository;
        this.entityMapper = entityMapper;
    }

    @Override
    public List<FraisCycleDto> findAll() {
        List<FraisCycle>fraisCycles = this.fraisCycleRepository.findAll(Sort.by("code"));
        return fraisCycles.stream().map(p -> this.entityMapper.fraisCycleToFraisCycleDto(p)).collect(Collectors.toList());
    }

    @Override
    public FraisCycleDto findById(Long id) {

        FraisCycle fraisCycle = this.fraisCycleRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("FraisCycle", "code", id));
        return this.entityMapper.fraisCycleToFraisCycleDto(fraisCycle);
    }

    @Override
    public FraisCycleDto save(FraisCycleDto fraisCycleDto) {
        FraisCycle fraisCycle = this.entityMapper.fraisCycleDtoToFraisCycle(fraisCycleDto);
        FraisCycle fraisCycleSaved = this.fraisCycleRepository.save(fraisCycle);

        return this.entityMapper.fraisCycleToFraisCycleDto(fraisCycleSaved);
    }

    @Override
    public FraisCycleDto update(Long id, FraisCycleDto fraisCycleDto) {

        FraisCycle fraisCycle = this.fraisCycleRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("FraisCycle", " code ", id));
        fraisCycle.setLibelle(fraisCycleDto.getLibelle());

        FraisCycle fraisCycleUpdate = this.fraisCycleRepository.save(fraisCycle);
        return this.entityMapper.fraisCycleToFraisCycleDto(fraisCycleUpdate);
    }

    @Override
    public void delete(Long id) {

        FraisCycle fraisCycle = this.fraisCycleRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("FraisCycle", "code", id));
        this.fraisCycleRepository.delete(fraisCycle);

    }
}
