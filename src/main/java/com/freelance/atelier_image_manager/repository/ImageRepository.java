package com.freelance.atelier_image_manager.repository;

import com.freelance.atelier_image_manager.model.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImageRepository extends JpaRepository<Image, Long> {

}
