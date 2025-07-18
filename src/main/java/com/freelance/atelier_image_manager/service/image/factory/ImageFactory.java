package com.freelance.atelier_image_manager.service.image.factory;

import com.freelance.atelier_image_manager.model.Image;

public class ImageFactory {

	private ImageFactory() {
		// You can't use this constructor to instantiate an object of this class
	}

	public static Image buildImage(String imageName) {
		return Image.builder().name(imageName).build();
	}

}
