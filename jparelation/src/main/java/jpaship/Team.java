package jpaship;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Team {
    @Id @GeneratedValue
    @Column(name = "TEAM_ID")
    private Long id;

    public Long getId() {
        return id;
    }
    @OneToMany(mappedBy = "team") //가짜 매핑 - 주인의 반대편(Team.members)
    private List<Member> members = new ArrayList<>();
    public void addMember(Member member) {
        member.setTeam(this);
        members.add(member);
    }
    public void setId(Long id) {
        this.id = id;
    }

    public List<Member> getMembers() {
        return members;
    }

    public void setMembers(List<Member> members) {
        this.members = members;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;

}
