package com.mappers;

import com.dto.AgrementDto;
import com.dto.AgrementObtenuDto;
import com.dto.CantonDto;
import com.dto.CommuneDto;
import com.dto.CycleEnseignementDto;
import com.dto.EtablissementDto;
import com.dto.FraisCycleDto;
import com.dto.InspectionDto;
import com.dto.OrdreEnseignementDto;
import com.dto.PenaliteDto;
import com.dto.PenaliteObtenuDto;
import com.dto.PrefectureDto;
import com.dto.RegionAdministrativeDto;
import com.dto.RegionEducativeDto;
import com.dto.SanctionDto;
import com.dto.SanctionObtenuDto;
import com.entities.Agrement;
import com.entities.AgrementObtenu;
import com.entities.Canton;
import com.entities.Commune;
import com.entities.CycleEnseignement;
import com.entities.Etablissement;
import com.entities.FraisCycle;
import com.entities.Inspection;
import com.entities.OrdreEnseignement;
import com.entities.Penalite;
import com.entities.PenaliteObtenu;
import com.entities.Prefecture;
import com.entities.RegionAdministrative;
import com.entities.RegionEducative;
import com.entities.Sanction;
import com.entities.SanctionObtenu;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EntityMapperImpl implements EntityMapper {
	@Autowired
    private final ModelMapper modelMapper;


    // Agrement

    @Override
    public Agrement agrementDtoToAgrement(AgrementDto agrementDto) {
        if (agrementDto == null) {
            return null;
        }
        return this.modelMapper.map(agrementDto, Agrement.class);
    }

    @Override
    public AgrementDto agrementToAgrementDto(Agrement agrement) {
        if (agrement == null) {
            return null;
        }
        return this.modelMapper.map(agrement, AgrementDto.class);
    }

    //AgrementObtenu

	@Override
	public AgrementObtenu agrementObtenuDtoToAgrementObtenu(AgrementObtenuDto agrementObtenuDto) {
		// TODO Auto-generated method stub
		
		if (agrementObtenuDto == null) {
			
			return null;
				}
		return this.modelMapper.map(agrementObtenuDto, AgrementObtenu.class);
	}


	@Override
	public AgrementObtenuDto agrementObtenuToAgrementObtenuDto(AgrementObtenu agrementObtenu) {
		// TODO Auto-generated method stub
		
		if (agrementObtenu == null) {
			
		return null;
	}
		
		 return this.modelMapper.map(agrementObtenu, AgrementObtenuDto.class);
	}
	
	
	// Canton


	@Override
	public Canton cantonDtoToCanton(CantonDto cantonDto) {
		// TODO Auto-generated method stub
		if (cantonDto == null) {
		return null;
		}
		
		 return this.modelMapper.map(cantonDto,  Canton.class);
	}


	@Override
	public CantonDto cantonToCantonDto(Canton canton) {
		// TODO Auto-generated method stub
		
		if (canton == null) {
		return null;
		}
		
		return this.modelMapper.map(canton,  CantonDto.class);
		
	}

	//Commune

	@Override
	public Commune communeDtoToCommune(CommuneDto communeDto) {
		// TODO Auto-generated method stub
		
		if (communeDto == null) {
		return null;
		}
		
		return this.modelMapper.map(communeDto,  Commune.class);
	}


	@Override
	public CommuneDto communeToCommuneDto(Commune commune) {
		// TODO Auto-generated method stub
		if (commune == null) {
		
		return null;
		}
		
		return this.modelMapper.map(commune,  CommuneDto.class);	
	}

   //CycleEnseignement
	
	@Override
	public CycleEnseignement cycleEnseignementDtoToCycleEnseignement(CycleEnseignementDto cycleEnseignementDto) {
		// TODO Auto-generated method stub
		
		if (cycleEnseignementDto == null) {
		return null;
		}
		return this.modelMapper.map(cycleEnseignementDto,  CycleEnseignement.class);
	}


	@Override
	public CycleEnseignementDto cycleEnseignementToCycleEnseignementDto(CycleEnseignement cycleEnseignement) {
		// TODO Auto-generated method stub
		if (cycleEnseignement == null) {
		return null;
		}
		return this.modelMapper.map(cycleEnseignement,  CycleEnseignementDto.class);
	}

	//Etablissement 
	
	@Override
	public Etablissement etablissementDtoToEtablissement(EtablissementDto etablissementDto) {
		// TODO Auto-generated method stub
		if ( etablissementDto == null) {
		return null;
		}
		
		return this.modelMapper.map(etablissementDto,  Etablissement.class);
	}


	@Override
	public EtablissementDto etablissementToEtablissementDto(Etablissement etablissement) {
		// TODO Auto-generated method stub
		if(etablissement ==null) {
		return null;
		}
		return this.modelMapper.map(etablissement,  EtablissementDto.class);
		
	}

	//FraisCycle
	
	@Override
	public FraisCycle fraisCycleDtoToFraisCycle(FraisCycleDto fraisCycleDto) {
		// TODO Auto-generated method stub
		if(fraisCycleDto == null) {
		return null;
		}
		return this.modelMapper.map(fraisCycleDto,  FraisCycle.class);
	}


	@Override
	public FraisCycleDto fraisCycleToFraisCycleDto(FraisCycle fraisCycle) {
		// TODO Auto-generated method stub
		if (fraisCycle == null) {
		return null;
		}
		return this.modelMapper.map(fraisCycle,  FraisCycleDto.class);
	}

	//Inspection

	@Override
	public Inspection inspectionDtoToInspection(InspectionDto inspectionDto) {
		// TODO Auto-generated method stub
		if (inspectionDto == null) {
		return null;
		}
		return this.modelMapper.map(inspectionDto,  Inspection.class);
	}


	@Override
	public InspectionDto inspectionToInspectionDto(Inspection inspection) {
		// TODO Auto-generated method stub
		if (inspection == null) {
		return null;
		}
		
		return this.modelMapper.map(inspection,  InspectionDto.class);
	}

	//OrdreEnseignement

	@Override
	public OrdreEnseignement ordreEnseignementDtoToOrdreEnseignement(OrdreEnseignementDto ordreEnseignementDto) {
		// TODO Auto-generated method stub
		if (ordreEnseignementDto == null) {
		return null;
		}
		return this.modelMapper.map(ordreEnseignementDto,  OrdreEnseignement.class);
	}

	@Override
	public OrdreEnseignementDto ordreEnseignementToOrdreEnseignementDto(OrdreEnseignement ordreEnseignement) {
		if(ordreEnseignement == null) {
			return null;
		}
		return this.modelMapper.map(ordreEnseignement,  OrdreEnseignementDto.class);
	}


	//  Penalite
	
	@Override
	public Penalite penaliteDtoToPenalite(PenaliteDto penaliteDto) {
		// TODO Auto-generated method stub
		if(penaliteDto == null) {
		return null;
		}
		return this.modelMapper.map(penaliteDto,  Penalite.class);

	}


	@Override
	public PenaliteDto penaliteToPenaliteDto(Penalite penalite) {
		// TODO Auto-generated method stub
		if(penalite == null) {
		return null;
		}
		return this.modelMapper.map( penalite,  PenaliteDto.class);
	}

	//PenaliteObtenu
	
	@Override
	public PenaliteObtenu penaliteObtenuDtoToPenaliteObtenu(PenaliteObtenuDto penaliteObtenuDto) {
		// TODO Auto-generated method stub
		if (penaliteObtenuDto == null) {
		return null;
		}
		return this.modelMapper.map( penaliteObtenuDto,  PenaliteObtenu.class);
	}


	@Override
	public PenaliteObtenuDto penaliteObtenuToPenaliteObtenuDto(PenaliteObtenu penaliteObtenu) {
		// TODO Auto-generated method stub
		if( penaliteObtenu== null) {
		return null;
		}
		return this.modelMapper.map( penaliteObtenu, PenaliteObtenuDto.class);
	}

	//Prefecture
	
	@Override
	public Prefecture prefectureDtoToPrefecture(PrefectureDto prefectureDto) {
		// TODO Auto-generated method stub
		if (prefectureDto== null) {
		return null;
		}
		return this.modelMapper.map( prefectureDto, Prefecture.class);
	}


	@Override
	public PrefectureDto prefectureToPrefectureDto(Prefecture prefecture) {
		// TODO Auto-generated method stub
		if( prefecture == null) {
		return null;
		}
		return this.modelMapper.map( prefecture,  PrefectureDto.class);
	}

	//RegionAdministrative
	
	@Override
	public RegionAdministrative regionAdministrativeDtoToRegionAdministrative(
			RegionAdministrativeDto regionAdministrativeDto) {
		// TODO Auto-generated method stub
		if(regionAdministrativeDto == null) {
		return null;
		}
		return this.modelMapper.map(regionAdministrativeDto,  RegionAdministrative.class);
	}


	@Override
	public RegionAdministrativeDto regionAdministrativeToRegionAdministrativeDto(
			RegionAdministrative regionAdministrative) {
		// TODO Auto-generated method stub
		if(regionAdministrative == null) {
		return null;
		}
		return this.modelMapper.map(regionAdministrative, RegionAdministrativeDto.class);
	}

	//RegionEducative
	
	@Override
	public RegionEducative regionEducativeDtoToRegionEducative(RegionEducativeDto regionEducativeDto) {
		// TODO Auto-generated method stub
		if(regionEducativeDto == null) {
			return null;
			
		}
		return this.modelMapper.map(regionEducativeDto, RegionEducative.class);
	}


	@Override
	public RegionEducativeDto regionEducativeToRegionEducativeDto(RegionEducative regionEducative) {
		// TODO Auto-generated method stub
		if( regionEducative == null) {
		return null;
		}
		return this.modelMapper.map(regionEducative, RegionEducativeDto.class);
		
	}

	//Sanction

	@Override
	public Sanction sanctionDtoToSanction(SanctionDto sanctionDto) {
		// TODO Auto-generated method stub
		if(sanctionDto == null) {
		return null;
		}
		return this.modelMapper.map(sanctionDto, Sanction.class);
	}


	@Override
	public SanctionDto sanctionToSanctionDto(Sanction sanction) {
		// TODO Auto-generated method stub
		if(sanction == null) {
		return null;
		}
		return this.modelMapper.map(sanction, SanctionDto.class);
	}


	//SanctionObtenu
	
	@Override
	public SanctionObtenu sanctionObtenuDtoToSanctionObtenu(SanctionObtenuDto sanctionObtenuDto) {
		// TODO Auto-generated method stub
		if(sanctionObtenuDto == null) {
		return null;
		}
		return this.modelMapper.map(sanctionObtenuDto, SanctionObtenu.class);
	}


	@Override
	public SanctionObtenuDto sanctionObtenuToSanctionObtenuDto(SanctionObtenu sanctionObtenu) {
		// TODO Auto-generated method stub
		if(sanctionObtenu == null) {
		return null;
		}
		return this.modelMapper.map(sanctionObtenu, SanctionObtenuDto.class);
	}
}

