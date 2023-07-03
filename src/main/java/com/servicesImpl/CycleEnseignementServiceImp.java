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
	public CycleEnseignementDto findById(String code) {

		CycleEnseignement cycleEnseignement = this.cycleEnseignementRepository.findById(code)
				.orElseThrow(() -> new ResourceNotFoundException("CycleEnseignement", " code", code));
		return this.entityMapper.cycleEnseignementToCycleEnseignementDto(cycleEnseignement);
	}

	@Override
	public CycleEnseignementDto save(CycleEnseignementDto cycleEnseignementDto) {

		CycleEnseignement cycleEnseignement = this.entityMapper
				.cycleEnseignementDtoToCycleEnseignement(cycleEnseignementDto);
		CycleEnseignement cycleEnseignementSaved = this.cycleEnseignementRepository.save(cycleEnseignement);
		return this.entityMapper.cycleEnseignementToCycleEnseignementDto(cycleEnseignementSaved);
	}

	@Override
	public CycleEnseignementDto update(String code, CycleEnseignementDto cycleEnseignementDto) {
		CycleEnseignement cycleEnseignement = this.cycleEnseignementRepository.findById(code)
				.orElseThrow(() -> new ResourceNotFoundException("cycleEnseignement", " code ", code));
		cycleEnseignement.setLibelle(cycleEnseignementDto.getLibelle());

		CycleEnseignement cycleEnseignementUpdate = this.cycleEnseignementRepository.save(cycleEnseignement);
		return this.entityMapper.cycleEnseignementToCycleEnseignementDto(cycleEnseignementUpdate);
	}

	@Override
	public void delete(String code) {

		CycleEnseignement cycleEnseignement = this.cycleEnseignementRepository.findById(code)
				.orElseThrow(() -> new ResourceNotFoundException("CycleEnseignement", "code", code));
		this.cycleEnseignementRepository.delete(cycleEnseignement);

	}
}
