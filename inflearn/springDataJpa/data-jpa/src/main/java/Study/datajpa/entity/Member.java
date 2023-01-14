package Study.datajpa.entity;

import lombok.*;
import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@ToString(of = {"id", "name", "age"})
public class Member {

    @Id @GeneratedValue
    @Column(name = "member_id")
    private Long id;

    @Column(name = "member_name")
    private String name;

    @Column(name = "member_age")
    private int age;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name ="team_id")
    private Team team;

    public static Member createMember(String name, int age) {
        return Member.builder()
                .name(name)
                .age(age)
                .build();
    }

    public static Member createMember(String name, int age, Team team) {
        return Member.builder()
                .name(name)
                .age(age)
                .team(team)
                .build();
    }

    public void changeTeam(Team team) {
        this.team = team;
        team.getMembers().add(this);
    }
}
