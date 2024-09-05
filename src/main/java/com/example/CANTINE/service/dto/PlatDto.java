package com.example.CANTINE.service.dto;

import com.example.CANTINE.model.Menu;

import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PlatDto {


    private Long id;

    private String name;
    private String summary;

    @OneToOne(mappedBy = "plat")
    private Menu menu;
}
