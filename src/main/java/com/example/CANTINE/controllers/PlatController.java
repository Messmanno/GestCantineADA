package com.example.CANTINE.controllers;



import com.example.CANTINE.service.PlatService;
import com.example.CANTINE.service.dto.PlatDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/plats")
@RequiredArgsConstructor
@Slf4j
public class PlatController {
    private final PlatService platService;

    @GetMapping()
    public String showPlatPage(Model model)
    {
        model.addAttribute("plats", platService.findAll());
        return "plats/plat";
    }



    @GetMapping("/add")
    public String showAddPlatPage(Model model) {
        model.addAttribute("plat", new PlatDto());
        return "plats/forms";
    }


    @PostMapping
    public String savePlat(PlatDto platDto) {

        platService.save(platDto);
        return "redirect:/plats";
    }


    @GetMapping("/{id}")
    public String showUpdatePlatForm(@PathVariable Long id, Model model) {
        Optional<PlatDto> plat = platService.findOne(id);
        if(plat.isPresent()) {
            model.addAttribute("plat", plat.get());
            return "plats/forms";
        }else{
            return "redirect:/plats";
        }
    }

    @PostMapping("/{id}/update")
    public String updatePlat(@PathVariable Long id, @ModelAttribute PlatDto platDto) {
        platDto.setId(id);
        platDto.setName(platDto.getName());
        platDto.setSummary(platDto.getSummary());
        platDto.setMenu(platDto.getMenu());
        platService.update(platDto);
        return "redirect:/plats";
    }

    @GetMapping("/delete/{id}")
    public ResponseEntity<String> deleteMenu(@PathVariable Long id) {
        try {
            platService.delete(id); // Appelle la méthode de suppression dans le service
            return new ResponseEntity<>("Menu deleted successfully", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error deleting menu", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }









}
