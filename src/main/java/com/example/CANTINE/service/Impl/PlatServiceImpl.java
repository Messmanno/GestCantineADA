package com.example.CANTINE.service.Impl;

import com.example.CANTINE.model.Plat;
import com.example.CANTINE.repositories.MenuRepository;
import com.example.CANTINE.repositories.PlatRepository;
import com.example.CANTINE.service.Mapper.PlatMapper;
import com.example.CANTINE.service.PlatService;
import com.example.CANTINE.service.dto.PlatDto;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@AllArgsConstructor
@Service
public class PlatServiceImpl implements PlatService {

    private final PlatMapper platMapper;
    private final PlatRepository platRepository;
    private final MenuRepository menuRepository;

    @Override
    public PlatDto save(PlatDto platDto) {
        log.debug("Request to save Plat : {}", platDto);
        Plat plat = platMapper.toEntity(platDto);
        plat = platRepository.save(plat);

        return platMapper.toDto(plat);
    }


    @Override
    public PlatDto update(PlatDto platDto) {
        log.debug("Request to update Plat : {}", platDto);
        Plat existingPlat = platRepository.findById(platDto.getId())
                .orElseThrow(() -> new RuntimeException("Plat not found"));

        existingPlat.setName(platDto.getName());
        existingPlat.setSummary(existingPlat.getSummary());
        existingPlat.setMenu(existingPlat.getMenu());

        Plat updatedPlat = platRepository.save(existingPlat);
        return platMapper.toDto(updatedPlat);
    }

    @Override
    public Optional<PlatDto> findOne(Long id) {
        return platRepository.findById(id).map(platMapper::toDto);
    }


    @Override
    public List<PlatDto> findAll() {
        return platRepository.findAll().stream()
                .map(platMapper::toDto)
                .toList();
    }

    @Override
    public void delete(Long id) {
        platRepository.deleteById(id);
    }
}

