package bootJpaAws.web;

import lombok.RequiredArgsConstructor;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RequiredArgsConstructor
@RestController
public class ProfileController {
    private final Environment env;

    @GetMapping("/profile")
    public String profile() {
        List<String> profiles = Arrays.asList(env.getActiveProfiles()); // 현재 실행중인 ActiveProfiles 전부 ex.(real, oauth, real-db)
        List<String> realProfiles = Arrays.asList("real", "real1", "real2"); // 이 3개 중 하나라도 있으면 값 반환 (real1,2 모두 배포에 사용될 profile)
        String defaultProfile = profiles.isEmpty() ? "default" : profiles.get(0); // 없으면 디폴트 있으면 0번째

        return profiles.stream()
                .filter(realProfiles::contains)
                .findAny()
                .orElse(defaultProfile);
    }
}