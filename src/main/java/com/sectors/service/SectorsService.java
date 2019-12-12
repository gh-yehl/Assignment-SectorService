package com.sectors.service;

import com.sectors.domain.Sectors;
import com.sectors.model.SectorsDTO;
import com.sectors.repository.SectorsRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SectorsService {

    @Autowired
    private SectorsRepository sectorsRepository;

    public SectorsDTO findSectorBySectorName(String sectorName) {
        SectorsDTO sectorsDTO = new SectorsDTO();
        Sectors sectors = sectorsRepository.findSectorsBySectorName(sectorName);
        BeanUtils.copyProperties(sectors, sectorsDTO);
        return sectorsDTO;
    }
    public List<SectorsDTO> findAll() {
        List<Sectors> list = sectorsRepository.findAll();
        List<SectorsDTO> dtoList = new ArrayList<SectorsDTO>();
        for (Sectors sectors: list) {
            SectorsDTO sectorsDTO = new SectorsDTO();
            BeanUtils.copyProperties(sectors, sectorsDTO);
            dtoList.add(sectorsDTO);
        }
        return dtoList;
    }

}
