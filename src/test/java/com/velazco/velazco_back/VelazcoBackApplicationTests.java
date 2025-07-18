package com.velazco.velazco_back;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;

@SpringBootTest
@TestPropertySource(properties = {
		"base.url=http://localhost:8080",
		"app.security.jwt.enabled=true",
})
@ActiveProfiles("test")
class VelazcoBackendApplicationTests {

	@Test
	void contextLoads() {
	}

}
