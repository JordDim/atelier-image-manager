package com.freelance.atelier_image_manager.service.image.impl;

import com.freelance.atelier_image_manager.domain.vo.ImageResponse;
import com.freelance.atelier_image_manager.repository.ImageRepository;
import com.freelance.atelier_image_manager.service.image.ImageFindAllService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class ImageFindAllServiceImpl implements ImageFindAllService {

	private final ImageRepository imageRepository;

	private final ConversionService conversionService;

	@Override
	public List<ImageResponse> findAll() {

		return imageRepository.findAll()
			.stream()
			.map(image -> conversionService.convert(image, ImageResponse.class))
			.toList();
	}

}
