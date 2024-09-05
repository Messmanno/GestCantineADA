package com.example.CANTINE.controllers;



import com.example.CANTINE.service.MenuService;
import com.example.CANTINE.service.dto.MenuDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/menus")
@RequiredArgsConstructor
@Slf4j
public class MenuController {
    private final MenuService menuService;

    @GetMapping()
    public String showMenuPage(Model model)
    {
        model.addAttribute("menus", menuService.findAll());
        return "menus/menu";
    }



    @GetMapping("/add")
    public String showAddMenuPage(Model model) {
        model.addAttribute("menu", new MenuDto());
        return "menus/forms";
    }


    @PostMapping
    public String saveMenu(MenuDto menuDto) {

        menuService.save(menuDto);
        return "redirect:/menus";
    }


    @GetMapping("/{id}")
    public String showUpdateMenuForm(@PathVariable Long id, Model model) {
        Optional<MenuDto> menu = menuService.findOne(id);
        if(menu.isPresent()) {
            model.addAttribute("menu", menu.get());
            return "menus/forms";
        }else{
            return "redirect:/menus";
        }
    }

    @PostMapping("/{id}/update")
    public String updateMenu(@PathVariable Long id, @ModelAttribute MenuDto menuDto) {
        menuDto.setId(id);
        menuDto.setCreationDate(menuDto.getCreationDate());
        menuDto.setPlat(menuDto.getPlat());
        menuService.update(menuDto);
        return "redirect:/menus";
    }

    @GetMapping("/delete/{id}")
    public ResponseEntity<String> deleteMenu(@PathVariable Long id) {
        try {
            menuService.delete(id); // Appelle la méthode de suppression dans le service
            return new ResponseEntity<>("Menu deleted successfully", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error deleting menu", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }









}
