package bootJpaAws.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

// 테스트 코드를 위해 분리

@Configuration
@EnableJpaAuditing // JPA Auditing 활성화
public class JpaConfig {
}
