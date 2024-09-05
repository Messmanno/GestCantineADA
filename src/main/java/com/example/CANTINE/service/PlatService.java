package com.example.CANTINE.service;

import com.example.CANTINE.service.dto.PlatDto;


import java.util.List;
import java.util.Optional;

public interface PlatService {

    PlatDto save(PlatDto platDto);

    PlatDto update(PlatDto platDto);

    Optional<PlatDto> findOne(Long id);

    List<PlatDto> findAll();

    void delete(Long id);
}
