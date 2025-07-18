package com.freelance.atelier_image_manager.controller;

import com.freelance.atelier_image_manager.apifirst.api.ImageApiDelegate;
import com.freelance.atelier_image_manager.domain.vo.ImageResponse;
import com.freelance.atelier_image_manager.service.image.ImageCreateService;
import com.freelance.atelier_image_manager.service.image.ImageDeleteService;
import com.freelance.atelier_image_manager.service.image.ImageFindAllService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@AllArgsConstructor
public class ImageController implements ImageApiDelegate {

	private final ImageCreateService imageCreateService;

	private final ImageDeleteService imageDeleteService;

	private final ImageFindAllService imageFindAllService;

	@Override
	public ResponseEntity<ImageResponse> createImage(MultipartFile image) {
		return ResponseEntity.ok(imageCreateService.createImage(image));
	}

	@Override
	public ResponseEntity<Void> deleteImage(Long imageId) {
		imageDeleteService.deleteImageById(imageId);
		return null;
	}

	@Override
	public ResponseEntity<List<ImageResponse>> getImages() {
		return ResponseEntity.ok(imageFindAllService.findAll());
	}

}
