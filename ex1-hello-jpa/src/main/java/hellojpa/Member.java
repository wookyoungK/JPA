package hellojpa;
import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Entity //JPA가 관리하는 객체
//@Table(name="MBR") Runtime에 영향
@SequenceGenerator(
        name = "MEMBER_SEQ_GENERATOR",
        sequenceName = "MEMBER_SEQ", //매핑할 데이터베이스 시퀀스 이름
        initialValue = 1, allocationSize = 1)
public class Member {
    //    @Column(nullable = false, length = 10) 실행로직에 영향을 주지않는다 -> DDL생성 기능
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "MEMBER_SEQ_GENERATOR")
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name", nullable = false)
    private String username;

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

    /*
        private Integer age;
        @Enumerated(EnumType.STRING)//기본이 ORDINAL 사용X
        private RoleType roleType;
        @Temporal(TemporalType.TIMESTAMP)
        private Date createdDate;
        @Temporal(TemporalType.TIMESTAMP)
        private Date lastModifiedDate;
        private LocalDate testLocalDate;
        private LocalDateTime testLocalDateTime;
        @Lob
        private String description;
    */
    public Member(){}

}