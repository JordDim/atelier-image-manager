package com.freelance.atelier_image_manager.service.image.impl;

import com.freelance.atelier_image_manager.exception.BusinessException;
import com.freelance.atelier_image_manager.exception.enums.AppErrorCode;
import com.freelance.atelier_image_manager.properties.ApplicationProperties;
import com.freelance.atelier_image_manager.service.image.ImageDeleteFromDirectoryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Slf4j
@Service
@RequiredArgsConstructor
public class ImageDeleteFromDirectoryServiceImpl implements ImageDeleteFromDirectoryService {

	private final ApplicationProperties applicationProperties;

	@Override
	public void deleteImageFromDirectory(String imageName) {
		Path imageFromPath = Paths.get(applicationProperties.getImage().getUpload().getDirectory(), imageName);

		try {
			Files.delete(imageFromPath);
		}
		catch (IOException exception) {
			log.error("The image can not be deleted successfully: {}", imageName);
			throw new BusinessException(AppErrorCode.ERROR_DELETE_IMAGE, exception);
		}
	}

}
