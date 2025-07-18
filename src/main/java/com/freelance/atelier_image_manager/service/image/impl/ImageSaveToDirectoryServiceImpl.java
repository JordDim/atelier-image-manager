package com.freelance.atelier_image_manager.service.image.impl;

import com.freelance.atelier_image_manager.exception.BusinessException;
import com.freelance.atelier_image_manager.exception.enums.AppErrorCode;
import com.freelance.atelier_image_manager.properties.ApplicationProperties;
import com.freelance.atelier_image_manager.service.image.ImageSaveToDirectoryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Slf4j
@Service
@RequiredArgsConstructor
public class ImageSaveToDirectoryServiceImpl implements ImageSaveToDirectoryService {

	private final ApplicationProperties applicationProperties;

	@Override
	public String saveImageToDirectory(MultipartFile image) throws IOException {
		log.info("INIT - ImageService -> saveImageToDirectory()");
		Path uploadDirectoryImage = Paths.get(applicationProperties.getImage().getUpload().getDirectory());
		String imageName = getValidImageName(image);
		if (!Files.exists(uploadDirectoryImage)) {
			Files.createDirectories(uploadDirectoryImage);
		}
		saveImage(image, uploadDirectoryImage.resolve(imageName));
		log.info("END - ImageService -> saveImageToDirectory() - The image was saved successfully");
		return imageName;
	}

	private String getValidImageName(MultipartFile image) {
		String imageName = image.getOriginalFilename();
		if (StringUtils.isEmpty(imageName)) {
			throw new BusinessException(AppErrorCode.ERROR_IMAGE_NAME);
		}
		return imageName;
	}

	private void saveImage(MultipartFile image, Path destination) {
		try (InputStream inputStream = image.getInputStream()) {
			log.info("INIT - ImageService -> saveImage() - Saving image");
			Files.copy(inputStream, destination, StandardCopyOption.REPLACE_EXISTING);
		}
		catch (IOException exception) {
			log.error("The image can not be saved successfully: {}", destination.getFileName());
			throw new BusinessException(AppErrorCode.ERROR_SAVE_IMAGE, exception);
		}
	}

}
