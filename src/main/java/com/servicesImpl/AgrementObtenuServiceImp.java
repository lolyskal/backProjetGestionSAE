package com.servicesImpl;

import com.dto.AgrementObtenuDto;
import com.entities.AgrementObtenu;
import com.exceptions.ResourceNotFoundException;
import com.mappers.EntityMapper;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import com.repository.AgrementObtenuRepository;
import com.services.AgrementObtenuService;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class AgrementObtenuServiceImp implements AgrementObtenuService {


    private AgrementObtenuRepository agrementObtenuRepository;

    private EntityMapper entityMapper;


    public AgrementObtenuServiceImp(AgrementObtenuRepository agrementObtenuRepository, EntityMapper entityMapper) {
        this.agrementObtenuRepository = agrementObtenuRepository;
        this.entityMapper = entityMapper;
    }
    @Override
    public List<AgrementObtenuDto> findAll () {
        List<AgrementObtenu> agrementObtenus = this.agrementObtenuRepository.findAll(Sort.by("numero"));
        return agrementObtenus.stream().map(p -> this.entityMapper.agrementObtenuToAgrementObtenuDto(p)).collect(Collectors.toList());
    }

    @Override
    public AgrementObtenuDto findById(Long id) {
        AgrementObtenu agrementObtenu = this.agrementObtenuRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("AgrementObtenu", " numero", id));
        return this.entityMapper.agrementObtenuToAgrementObtenuDto(agrementObtenu);

    }

    @Override
    public AgrementObtenuDto save(AgrementObtenuDto agrementObtenuDto) {

        AgrementObtenu agrementObtenu = this.entityMapper.agrementObtenuDtoToAgrementObtenu(agrementObtenuDto);
        AgrementObtenu agrementObtenuSaved = this.agrementObtenuRepository.save(agrementObtenu);

        return this.entityMapper.agrementObtenuToAgrementObtenuDto(agrementObtenuSaved);
    }

    @Override
    public AgrementObtenuDto update(Long id, AgrementObtenuDto agrementObtenuDto) {

        AgrementObtenu agrementObtenu = this.agrementObtenuRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("AgrementObtenu", " numero ", id));
        agrementObtenu.setDate(agrementObtenuDto.getDate());

        AgrementObtenu  agrementObtenuUpdate = this.agrementObtenuRepository.save(agrementObtenu);
        return this.entityMapper.agrementObtenuToAgrementObtenuDto(agrementObtenuUpdate);
    }

    @Override
    public void delete(Long id) {

        AgrementObtenu agrementObtenu = this.agrementObtenuRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("AgrementObtenu", "numero", id));
        this.agrementObtenuRepository.delete(agrementObtenu);

    }
}
