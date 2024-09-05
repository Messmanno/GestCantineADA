package com.example.CANTINE.service.Impl;


import com.example.CANTINE.model.Menu;
import com.example.CANTINE.repositories.MenuRepository;
import com.example.CANTINE.service.Mapper.MenuMapper;
import com.example.CANTINE.service.MenuService;
import com.example.CANTINE.service.dto.MenuDto;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@AllArgsConstructor
@Service
public class MenuServiceImpl implements MenuService {

    private final MenuRepository menuRepository;
    private final MenuMapper menuMapper;

    @Override
    public MenuDto save(MenuDto menuDto) {
        log.debug("Request to save Menu : {}", menuDto);
        Menu menu = menuMapper.toEntity(menuDto);
        menu = menuRepository.save(menu);

        return menuMapper.toDto(menu);
    }




    @Override
    public MenuDto update(MenuDto menuDto) {
        log.debug("Request to update Menu : {}", menuDto);
        Menu existingMenu = menuRepository.findById(menuDto.getId())
                .orElseThrow(() -> new RuntimeException("Menu not found"));

        existingMenu.setPlat(menuDto.getPlat());
        existingMenu.setCreationDate(menuDto.getCreationDate());

        Menu updatedMenu = menuRepository.save(existingMenu);
        return menuMapper.toDto(updatedMenu);
    }


    @Override
    public Optional<MenuDto> findOne(Long id) {
    return menuRepository.findById(id).map(menuMapper::toDto);
    }

    @Override
    public List<MenuDto> findAll() {
        return menuRepository.findAll().stream()
                .map(menuMapper::toDto)
                .toList();
    }

    @Override
    public void delete(Long id) {
        menuRepository.deleteById(id);

    }
}


