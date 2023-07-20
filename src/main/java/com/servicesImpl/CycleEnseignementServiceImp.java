package com.servicesImpl;

import com.dto.CycleEnseignementDto;
import com.entities.CycleEnseignement;
import com.exceptions.ResourceNotFoundException;
import com.mappers.EntityMapper;
import com.services.CycleEnseignementService;
import org.springframework.data.domain.Sort;
import com.repository.CycleEnseignementRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class CycleEnseignementServiceImp implements CycleEnseignementService {

	private final CycleEnseignementRepository cycleEnseignementRepository;

	private final EntityMapper entityMapper;

	public CycleEnseignementServiceImp(CycleEnseignementRepository cycleEnseignementRepository,
			EntityMapper entityMapper) {
		this.cycleEnseignementRepository = cycleEnseignementRepository;
		this.entityMapper = entityMapper;

	}

	@Override
	public List<CycleEnseignementDto> findAll() {
		List<CycleEnseignement> cycleEnseignements = this.cycleEnseignementRepository.findAll(Sort.by("code"));
		return cycleEnseignements.stream().map(p -> this.entityMapper.cycleEnseignementToCycleEnseignementDto(p))
				.collect(Collectors.toList());
	}

	@Override
	public CycleEnseignementDto findById(Long id) {

		CycleEnseignement cycleEnseignement = this.cycleEnseignementRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("CycleEnseignement", " code", id));
		return this.entityMapper.cycleEnseignementToCycleEnseignementDto(cycleEnseignement);
	}

	@Override
	public CycleEnseignementDto save(CycleEnseignementDto cycleEnseignementDto) {

		CycleEnseignement cycleEnseignement = this.entityMapper.cycleEnseignementDtoToCycleEnseignement(cycleEnseignementDto);
		CycleEnseignement cycleEnseignementSaved = this.cycleEnseignementRepository.save(cycleEnseignement);
		return this.entityMapper.cycleEnseignementToCycleEnseignementDto(cycleEnseignementSaved);
	}

	@Override
	public CycleEnseignementDto update(Long id, CycleEnseignementDto cycleEnseignementDto) {
		CycleEnseignement cycleEnseignement = this.cycleEnseignementRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("cycleEnseignement", " code ", id));
		cycleEnseignement.setLibelle(cycleEnseignementDto.getLibelle());

		CycleEnseignement cycleEnseignementUpdate = this.cycleEnseignementRepository.save(cycleEnseignement);
		return this.entityMapper.cycleEnseignementToCycleEnseignementDto(cycleEnseignementUpdate);
	}

	@Override
	public void delete(Long id) {

		CycleEnseignement cycleEnseignement = this.cycleEnseignementRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("CycleEnseignement", "code", id));
		this.cycleEnseignementRepository.delete(cycleEnseignement);

	}
}
