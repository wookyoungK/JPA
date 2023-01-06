package hellojpa;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity //JPA가 관리하는 객체
//@Table(name="MBR") Runtime에 영향
public class Member {
    @Id
    private Long id;
//    @Column(nullable = false, length = 10) 실행로직에 영향을 주지않는다 -> DDL생성 기능
    private String name;
    private int age;

    
    public Member (){}
    public Member(Long id, String name) {
        this.id = id;
        this.name = name;
    }
    //Getter, Setter …

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