package com.servicesImpl;

import com.dto.EtablissementDto;
import com.entities.Etablissement;
import com.exceptions.ResourceNotFoundException;
import com.mappers.EntityMapper;
import com.services.EtablissementService;
import org.springframework.data.domain.Sort;
import com.repository.EtablissementRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class EtablissementServiceImp implements EtablissementService {

    private final EtablissementRepository etablissementRepository;
    private final EntityMapper entityMapper;

    public EtablissementServiceImp (EtablissementRepository etablissementRepository , EntityMapper entityMapper){
        this.etablissementRepository = etablissementRepository;
        this.entityMapper = entityMapper;

    }

    @Override
    public List<EtablissementDto> findAll() {
        List<Etablissement>etablissements = this.etablissementRepository.findAll(Sort.by("nom_Etablissement"));
        return etablissements.stream().map(p -> this.entityMapper.etablissementToEtablissementDto(p)).collect(Collectors.toList());
    }

    @Override
    public EtablissementDto findById(String nom_Etablissement) {
        Etablissement etablissement = this.etablissementRepository.findById(nom_Etablissement)
                .orElseThrow(() -> new ResourceNotFoundException("Etablissement", "nom_Etablissement", nom_Etablissement));
        return this.entityMapper.etablissementToEtablissementDto(etablissement);
    }

    @Override
    public EtablissementDto save(EtablissementDto etablissementDto) {

        Etablissement etablissement = this.entityMapper.etablissementDtoToEtablissement(etablissementDto);
        Etablissement etablissementSaved = this.etablissementRepository.save(etablissement);

        return this.entityMapper.etablissementToEtablissementDto(etablissementSaved);
    }

    @Override
    public EtablissementDto update(String nom_Etablissement, EtablissementDto etablissementDto) {
        Etablissement etablissement = this.entityMapper.etablissementDtoToEtablissement(etablissementDto);
        Etablissement etablissementSaved = this.etablissementRepository.save(etablissement);

        return this.entityMapper.etablissementToEtablissementDto(etablissementSaved);
    }

    @Override
    public void delete(String nom_Etablissement) {

        Etablissement etablissement = this.etablissementRepository.findById(nom_Etablissement)
                .orElseThrow(() -> new ResourceNotFoundException("Etablissement", "nom_Etablissement", nom_Etablissement));
        this.etablissementRepository.delete(etablissement);

    }
}
