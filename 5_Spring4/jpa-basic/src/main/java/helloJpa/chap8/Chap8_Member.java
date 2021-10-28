package helloJpa.chap8;

import javax.persistence.*;

@Entity
public class Chap8_Member {

    @Id @GeneratedValue
    @Column(name = "MEMBER_ID")
    private Long id;
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "TEAM_ID")
    private Chap8_Team team;

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

    public Chap8_Team getTeam() {
        return team;
    }

    public void setTeam(Chap8_Team team) {
        this.team = team;
    }
}

