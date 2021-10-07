package helloJpa;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Member")   // 테이블 이름을 설정하는 부분
public class Member {
    @Id
    private Long id;
    @Column(name="name")    // 테이블의 컬럼값을 설정하는 부분
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
