package hellojpa;
import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Entity //JPA가 관리하는 객체
//@Table(name="MBR") Runtime에 영향
public class Member {
    //    @Column(nullable = false, length = 10) 실행로직에 영향을 주지않는다 -> DDL생성 기능
    @Id
    private Long id;
    @Column(name = "name", nullable = false)
    private String username;
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
    public Member(){}

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

    public Date getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(Date lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    public LocalDate getTestLocalDate() {
        return testLocalDate;
    }

    public void setTestLocalDate(LocalDate testLocalDate) {
        this.testLocalDate = testLocalDate;
    }

    public LocalDateTime getTestLocalDateTime() {
        return testLocalDateTime;
    }

    public void setTestLocalDateTime(LocalDateTime testLocalDateTime) {
        this.testLocalDateTime = testLocalDateTime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}