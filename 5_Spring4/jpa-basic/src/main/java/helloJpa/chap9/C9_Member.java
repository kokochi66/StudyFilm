package helloJpa.chap9;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class C9_Member {

    @Id @GeneratedValue
    @Column(name = "MEMBER_ID")
    private Long id;

    @Column(name = "USERNAME")
    private String username;

    @Embedded
    private C9_Period period;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name="city", column = @Column(name = "WORK_CITY")),
            @AttributeOverride(name="street", column = @Column(name = "WORK_STREET")),
            @AttributeOverride(name="zipcode", column = @Column(name = "WORK_ZIPCODE")),
    })
    private C9_Address address;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public C9_Period getPeriod() {
        return period;
    }

    public void setPeriod(C9_Period period) {
        this.period = period;
    }

    public C9_Address getAddress() {
        return address;
    }

    public void setAddress(C9_Address address) {
        this.address = address;
    }
}
