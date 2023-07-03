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

public interface EntityMapper {

    // Agrement

    Agrement agrementDtoToAgrement(AgrementDto agrementDto);
    AgrementDto agrementToAgrementDto(Agrement agrement);

    // AgrementObtenu
    
    AgrementObtenu agrementObtenuDtoToAgrementObtenu(AgrementObtenuDto agrementObtenuDto);
    AgrementObtenuDto agrementObtenuToAgrementObtenuDto(AgrementObtenu agrementObtenu);

    // Canton


    Canton cantonDtoToCanton(CantonDto cantonDto);
    CantonDto cantonToCantonDto(Canton canton);
    
    // Commune 
    
    
    Commune communeDtoToCommune(CommuneDto communeDto);
    CommuneDto communeToCommuneDto(Commune commune);
    
    // CycleEnseignement
    
    CycleEnseignement  cycleEnseignementDtoToCycleEnseignement(CycleEnseignementDto cycleEnseignementDto);
    CycleEnseignementDto cycleEnseignementToCycleEnseignementDto(CycleEnseignement cycleEnseignement);
    
    
    // Etablissement 
    
    Etablissement etablissementDtoToEtablissement(EtablissementDto etablissementDto);
    EtablissementDto etablissementToEtablissementDto(Etablissement etablissement);
    
    
    // FraisCycle 
    
    FraisCycle fraisCycleDtoToFraisCycle(FraisCycleDto fraisCycleDto);
    FraisCycleDto fraisCycleToFraisCycleDto(FraisCycle fraisCycle);
    
    
    // Inspection
    
    Inspection inspectionDtoToInspection(InspectionDto inspectionDto);
    InspectionDto inspectionToInspectionDto(Inspection inspection);
    
    // OrdreEnseignement
    
    OrdreEnseignement ordreEnseignementDtoToOrdreEnseignement(OrdreEnseignementDto ordreEnseignementDto);
    OrdreEnseignementDto ordreEnseignementToOrdreEnseignementDto(OrdreEnseignement ordreEnseignement);
    
    // Penalite
    
    Penalite penaliteDtoToPenalite(PenaliteDto penaliteDto);
    PenaliteDto penaliteToPenaliteDto(Penalite penalite);
    
    // PenaliteObtenu
    
    PenaliteObtenu penaliteObtenuDtoToPenaliteObtenu(PenaliteObtenuDto penaliteObtenuDto);
    PenaliteObtenuDto penaliteObtenuToPenaliteObtenuDto(PenaliteObtenu penaliteObtenu);
    
    // Prefecture
    
    Prefecture prefectureDtoToPrefecture(PrefectureDto prefectureDto);
    PrefectureDto prefectureToPrefectureDto(Prefecture prefecture);
    
    // RegionAdministrative
    
    
    RegionAdministrative regionAdministrativeDtoToRegionAdministrative(RegionAdministrativeDto regionAdministrativeDto);
    RegionAdministrativeDto regionAdministrativeToRegionAdministrativeDto(RegionAdministrative regionAdministrative);
    
    // RegionEducative
    
    RegionEducative regionEducativeDtoToRegionEducative(RegionEducativeDto regionEducativeDto);
    RegionEducativeDto regionEducativeToRegionEducativeDto(RegionEducative regionEducative);
    
    //Sanction
    
    Sanction sanctionDtoToSanction(SanctionDto sanctionDto);
    SanctionDto sanctionToSanctionDto(Sanction sanction);
    
    //SanctionObtenu
    
    SanctionObtenu sanctionObtenuDtoToSanctionObtenu(SanctionObtenuDto sanctionObtenuDto);
    SanctionObtenuDto sanctionObtenuToSanctionObtenuDto(SanctionObtenu sanctionObtenu);
}
