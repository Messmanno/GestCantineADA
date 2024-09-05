package com.example.CANTINE.service.dto;

import com.example.CANTINE.model.Plat;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class MenuDto {


    private Long id;

    @Temporal(TemporalType.TIMESTAMP)
    private Date creationDate;


    private Plat plat;

}
