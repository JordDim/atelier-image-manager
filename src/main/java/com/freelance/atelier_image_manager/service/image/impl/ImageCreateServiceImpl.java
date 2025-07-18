package com.freelance.atelier_image_manager.service.image.impl;

import com.freelance.atelier_image_manager.domain.vo.ImageResponse;
import com.freelance.atelier_image_manager.exception.BusinessException;
import com.freelance.atelier_image_manager.exception.enums.AppErrorCode;
import com.freelance.atelier_image_manager.model.Image;
import com.freelance.atelier_image_manager.repository.ImageRepository;
import com.freelance.atelier_image_manager.service.image.ImageCreateService;
import com.freelance.atelier_image_manager.service.image.ImageSaveToDirectoryService;
import com.freelance.atelier_image_manager.service.image.factory.ImageFactory;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Slf4j
@Service
@RequiredArgsConstructor
public class ImageCreateServiceImpl implements ImageCreateService {

	private final ImageRepository imageRepository;

	private final ImageSaveToDirectoryService imageSaveToDirectoryService;

	private final ConversionService conversionService;

	@Override
	public ImageResponse createImage(MultipartFile imageRequest) {
		try {
			String imageName = imageSaveToDirectoryService.saveImageToDirectory(imageRequest);
			Image image = ImageFactory.buildImage(imageName);
			imageRepository.save(image);
			return conversionService.convert(image, ImageResponse.class);
		}
		catch (IOException e) {
			throw new BusinessException(AppErrorCode.ERROR_IMAGE_NAME);
		}
	}

}
