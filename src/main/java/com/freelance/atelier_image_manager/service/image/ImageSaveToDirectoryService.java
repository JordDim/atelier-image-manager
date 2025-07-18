package com.freelance.atelier_image_manager.service.image;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface ImageSaveToDirectoryService {

	String saveImageToDirectory(MultipartFile imageRequest) throws IOException;

}
