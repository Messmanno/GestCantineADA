package com.example.CANTINE.service;


import com.example.CANTINE.service.dto.MenuDto;


import java.util.List;
import java.util.Optional;

public interface MenuService  {

    MenuDto save(MenuDto menuDto);

    MenuDto update(MenuDto MenuDto);

    Optional<MenuDto> findOne(Long id);

    List<MenuDto> findAll();

    void delete(Long id);
}
