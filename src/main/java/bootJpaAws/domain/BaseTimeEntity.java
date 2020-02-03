package bootJpaAws.domain;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Getter
@MappedSuperclass // Jpa 엔티티 클래스들이 BaseTimeEntity 상속할 경우 필드들도 칼럼으로 인식
@EntityListeners(AuditingEntityListener.class) // auditing 기능 포함
public abstract class BaseTimeEntity {

    @CreatedDate // 생성되어 저장될 때 시간 자동 저장
    private LocalDateTime createdDate;

    @LastModifiedDate // 조회한 엔티티의 값을 변경할 때 시간 자동 저장
    private LocalDateTime modifiedDate;

}