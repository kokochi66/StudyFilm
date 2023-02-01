package Study.datajpa.repository;

import lombok.Getter;

@Getter
public class UserNameOnlyDto {

    private final String name;

    public UserNameOnlyDto(String name) {
        // 파라미터 이름으로 매칭되기 때문에 파라미터 명을 정확하게 기입해야 함
        this.name = name;
    }
}
