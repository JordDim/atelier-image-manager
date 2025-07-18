package com.freelance.atelier_image_manager.properties;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
@AllArgsConstructor
@ConfigurationProperties(prefix = "application")
public class ApplicationProperties {

	private final SecurityProperties security;

	private final ImageProperties image;

}
