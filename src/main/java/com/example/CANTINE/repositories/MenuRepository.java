package com.example.CANTINE.repositories;

import com.example.CANTINE.model.Menu;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MenuRepository extends JpaRepository<Menu, Long> {
}
