package com.example.CANTINE.service.Mapper.Impl;

import com.example.CANTINE.model.Plat;
import com.example.CANTINE.service.Mapper.PlatMapper;
import com.example.CANTINE.service.dto.PlatDto;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;

@AllArgsConstructor
@Component
public class PlatMapperImpl implements PlatMapper {

    private final ModelMapper modelMapper;



    @Override
    public PlatDto toDto(Plat entity) {
        return modelMapper.map(entity, PlatDto.class);
    }

    @Override
    public Plat toEntity(PlatDto dto) {
        return modelMapper.map(dto, Plat.class);
    }
}
