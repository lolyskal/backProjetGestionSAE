package com.servicesImpl;

import com.dto.PrefectureDto;
import com.entities.Prefecture;
import com.exceptions.ResourceNotFoundException;
import com.mappers.EntityMapper;
import org.springframework.data.domain.Sort;
import com.repository.PrefectureRepository;
import com.services.PrefectureService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service

public class PrefectureServiceImp implements PrefectureService {

    private PrefectureRepository prefectureRepository;
    private EntityMapper entityMapper ;

    public PrefectureServiceImp(PrefectureRepository prefectureRepository, EntityMapper entityMapper ){
        this.prefectureRepository = prefectureRepository;
        this.entityMapper = entityMapper;
    }

    @Override
    public List<PrefectureDto> findAll() {
        List<Prefecture>prefectures = this.prefectureRepository.findAll(Sort.by("code"));
        return prefectures.stream().map(p -> this.entityMapper.prefectureToPrefectureDto(p)).collect(Collectors.toList());
    }

    @Override
    public PrefectureDto findById(Long id) {
        Prefecture prefecture = this.prefectureRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Prefecture ", " code", id));
        return this.entityMapper.prefectureToPrefectureDto(prefecture);
    }

    @Override
    public PrefectureDto save(PrefectureDto prefectureDto) {

        Prefecture prefecture = this.entityMapper.prefectureDtoToPrefecture( prefectureDto);
        Prefecture  prefectureSaved = this.prefectureRepository.save(prefecture);

        return this.entityMapper.prefectureToPrefectureDto(prefectureSaved);
    }

    @Override
    public PrefectureDto update(Long id, PrefectureDto prefectureDto) {

        Prefecture prefecture  = this.prefectureRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(" Prefecture", "code ", id));
        prefecture.setLibelle(prefectureDto.getLibelle());

        Prefecture prefectureUpdate = this.prefectureRepository.save(prefecture );
        return this.entityMapper.prefectureToPrefectureDto(prefectureUpdate);
    }

    @Override
    public void delete(Long id) {

        Prefecture prefecture = this.prefectureRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(" Prefecture ", "code", id));
        this.prefectureRepository.delete(prefecture );

    }
}
