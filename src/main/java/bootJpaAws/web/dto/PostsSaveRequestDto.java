package bootJpaAws.web.dto;

import bootJpaAws.domain.posts.Posts;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * Entity(Posts)와 거의 비슷한데도 만드는 이유?
 *
 * 엔티티는 데이터베이스와 맞닿은 핵심 클래스
 * 엔티티가 변경되면 여러 클래스에 영향을 끼친다. 단순 화면 변경을 위해 엔티티를 변경하는건 큰 변경.
 *
 * 리퀘스트, 리스폰스용 dto는 뷰를 위한 클래스라 정말 자주 변경이 필요하다.
 * 즉, 뷰 레이어와 DB 레이어의 역할 분리를 철저하게 하는 것이 좋다.
 *
 * 실제 컨트롤러에서 결과값으로 여러 테이블을 조인해서 반환하는 경우도 빈번한데, 엔티티로만은 표현이 어렵다.
 * dto 사용한다. 가장 변경도 많고.
 */

@Getter
@NoArgsConstructor
public class PostsSaveRequestDto {
    private String title;
    private String content;
    private String author;

    @Builder
    public PostsSaveRequestDto(String title, String content, String author){
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public Posts toEntity(){
        return Posts.builder()
                .title(title)
                .content(content)
                .author(author)
                .build();
    }
}