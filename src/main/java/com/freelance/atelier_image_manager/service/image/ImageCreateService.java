package com.freelance.atelier_image_manager.service.image;

import com.freelance.atelier_image_manager.domain.vo.ImageResponse;
import org.springframework.web.multipart.MultipartFile;

public interface ImageCreateService {

	ImageResponse createImage(MultipartFile imageRequest);

}
