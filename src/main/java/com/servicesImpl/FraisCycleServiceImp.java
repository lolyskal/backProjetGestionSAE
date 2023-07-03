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
    public FraisCycleDto findById(Integer code) {

        FraisCycle fraisCycle = this.fraisCycleRepository.findById(code)
                .orElseThrow(() -> new ResourceNotFoundException("FraisCycle", "code", code));
        return this.entityMapper.fraisCycleToFraisCycleDto(fraisCycle);
    }

    @Override
    public FraisCycleDto save(FraisCycleDto fraisCycleDto) {
        FraisCycle fraisCycle = this.entityMapper.fraisCycleDtoToFraisCycle(fraisCycleDto);
        FraisCycle fraisCycleSaved = this.fraisCycleRepository.save(fraisCycle);

        return this.entityMapper.fraisCycleToFraisCycleDto(fraisCycleSaved);
    }

    @Override
    public FraisCycleDto update(Integer code, FraisCycleDto fraisCycleDto) {

        FraisCycle fraisCycle = this.fraisCycleRepository.findById(code)
                .orElseThrow(() -> new ResourceNotFoundException("FraisCycle", " code ", code));
        fraisCycle.setLibelle(fraisCycleDto.getLibelle());

        FraisCycle fraisCycleUpdate = this.fraisCycleRepository.save(fraisCycle);
        return this.entityMapper.fraisCycleToFraisCycleDto(fraisCycleUpdate);
    }

    @Override
    public void delete(Integer code) {

    }
}
