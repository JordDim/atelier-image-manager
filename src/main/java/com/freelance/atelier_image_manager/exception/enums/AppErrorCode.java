package com.freelance.atelier_image_manager.exception.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum AppErrorCode {

	ERROR_UNEXPECTED("An unexpected error occurred."), ERROR_IMAGE_NAME("The file name is null or empty."),
	ERROR_SAVE_IMAGE("Failed to save the image."), ERROR_DELETE_IMAGE("Error while attempting to delete the image.");

	private final String message;

}