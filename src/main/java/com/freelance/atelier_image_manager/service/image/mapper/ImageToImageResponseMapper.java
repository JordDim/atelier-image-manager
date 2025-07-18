package com.freelance.atelier_image_manager.service.image.mapper;

import com.freelance.atelier_image_manager.domain.vo.ImageResponse;
import com.freelance.atelier_image_manager.model.Image;
import org.mapstruct.Mapper;
import org.springframework.core.convert.converter.Converter;

@Mapper(componentModel = "spring")
public interface ImageToImageResponseMapper extends Converter<Image, ImageResponse> {

	ImageResponse convertToImageResponse(Image image);

}
