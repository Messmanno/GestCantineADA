package com.example.CANTINE.service.Mapper;

public interface EntityMapper<D,E> {

    D toDto(E entity);
    E toEntity(D dto);


}
