package bootJpaAws.config.auth;

import bootJpaAws.domain.user.User;
import lombok.Getter;

import java.io.Serializable;

@Getter // SessionUser 에는 인증된 사용자 정보. 만 필요
public class SessionUser implements Serializable {
    private String name;
    private String email;
    private String picture;

    public SessionUser(User user) {
        this.name = user.getName();
        this.email = user.getEmail();
        this.picture = user.getPicture();
    }
}