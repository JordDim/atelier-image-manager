package com.freelance.atelier_image_manager.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
public class SecurityProperties {

	private AuthProperties auth;

	private JWTProperties jwt;

	@Getter
	@Setter
	public static class AuthProperties {

		private String username;

		private String password;

	}

	@Getter
	@Setter
	public static class JWTProperties {

		private String secretKey;

	}

}
