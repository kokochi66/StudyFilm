package helloJpa;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

/*@Entity
@Table(name="Member")   // 테이블 이름을 설정하는 부분*/
public class Member {
    @Id
    private Long id;

    @Column(name="name")    // 테이블의 컬럼값을 설정하는 부분
    private String name;

    private Integer age;

    @Enumerated(EnumType.STRING)    // String으로 설정하여야 Enum타입이 String값으로 DB에 들어가게 된다. (Integer는 변동에 위험이 있음)
    private RoleType roleType;

    @Temporal(TemporalType.DATE)
    private Date createdDate;

    @Temporal(TemporalType.TIMESTAMP)
    private Date editDate;

    @Lob    // 큰 크기의 텍스트를 사용할 때 사용하는 어노테이션
    private String description;

    @Transient
    private String temp;        // 테이블에는 반영되지 않는 변수값

    private LocalDate postDate;     // 최신 버전에서는 LocalDate를 지원하며, 이를 사용하면 바로 Date값으로 변환됨.

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public RoleType getRoleType() {
        return roleType;
    }

    public void setRoleType(RoleType roleType) {
        this.roleType = roleType;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getEditDate() {
        return editDate;
    }

    public void setEditDate(Date editDate) {
        this.editDate = editDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTemp() {
        return temp;
    }

    public void setTemp(String temp) {
        this.temp = temp;
    }

    public LocalDate getPostDate() {
        return postDate;
    }

    public void setPostDate(LocalDate postDate) {
        this.postDate = postDate;
    }

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
