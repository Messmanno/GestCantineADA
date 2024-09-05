package com.example.CANTINE.service.Mapper.Impl;

import com.example.CANTINE.model.Menu;
import com.example.CANTINE.service.Mapper.MenuMapper;
import com.example.CANTINE.service.dto.MenuDto;
import lombok.AllArgsConstructor;
import org.apache.catalina.mapper.Mapper;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class MenuMapperImpl implements MenuMapper{

    private final ModelMapper modelMapper;

    @Override
    public MenuDto toDto(Menu entity) {
        return null;
    }

    @Override
    public Menu toEntity(MenuDto dto) {
        return null;
    }
}
