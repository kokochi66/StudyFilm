package helloJpa;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name="Member")   // 테이블 이름을 설정하는 부분
public class Member {
    @Id
    private Long id;

    @Column(name="name")    // 테이블의 컬럼값을 설정하는 부분
    private String name;

    private Integer age;

    @Enumerated(EnumType.STRING)
    private RoleType roleType;

    @Temporal(TemporalType.DATE)
    private Date createdDate;

    @Temporal(TemporalType.TIMESTAMP)
    private Date editDate;

    @Lob
    private String description;

    @Transient
    private String temp;        // 테이블에는 반영되지 않는 변수값

    private LocalDate postDate;     // 최신 버전에서는 LocalDate를 지원하며, 이를 사용하면 바로 Date값으로 변환됨.

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
