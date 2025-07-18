package com.freelance.atelier_image_manager.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
public class ImageProperties {

	private UploadProperties upload;

	@Getter
	@Setter
	public static class UploadProperties {

		private String directory;

		private String baseUrl;

		private String localDirectory;

	}

}
