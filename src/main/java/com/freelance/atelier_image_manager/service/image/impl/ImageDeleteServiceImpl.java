package com.freelance.atelier_image_manager.service.image.impl;

import com.freelance.atelier_image_manager.exception.BusinessException;
import com.freelance.atelier_image_manager.exception.enums.AppErrorCode;
import com.freelance.atelier_image_manager.model.Image;
import com.freelance.atelier_image_manager.repository.ImageRepository;
import com.freelance.atelier_image_manager.service.image.ImageDeleteFromDirectoryService;
import com.freelance.atelier_image_manager.service.image.ImageDeleteService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class ImageDeleteServiceImpl implements ImageDeleteService {

	private final ImageRepository imageRepository;

	private final ImageDeleteFromDirectoryService imageDeleteFromDirectoryService;

	@Override
	public void deleteImageById(Long id) {
		try {
			Image image = imageRepository.findById(id)
				.orElseThrow(() -> new BusinessException(AppErrorCode.ERROR_DELETE_IMAGE));

			imageDeleteFromDirectoryService.deleteImageFromDirectory(image.getName());

			imageRepository.deleteById(id);

		}
		catch (BusinessException e) {
			throw new BusinessException(AppErrorCode.ERROR_DELETE_IMAGE, e);
		}
	}

}
