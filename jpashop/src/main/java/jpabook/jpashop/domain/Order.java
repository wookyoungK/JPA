package jpabook.jpashop.domain;


import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "ORDERS")
public class Order {
    @Id @GeneratedValue
    @Column(name = "ORDER_ID")
    private Long id;

    /*    @Column(name = "MEMBER_ID") //객체설계를 테이블에 맞춰서 설계한 것(데이터 중심 설계) -> 객체지향적이지 않는다.
    private Long memberId;
*/
    @ManyToOne
    @JoinColumn(name = "MEMBER_ID")
    private Member member;

    @OneToMany(mappedBy = "order")
    private List<OrderItem> orderItems = new ArrayList<>();

/*
    계속 참조해서 가져오도록 설계해야한다.
    private Member meber;

    public Member getMeber() {
        return meber;
    }

    public void setMeber(Member meber) {
        this.meber = meber;
    }
*/

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    private LocalDateTime orderDate; // 보통 관례 ORDER_DATE, order_date(spring boot 기본 값)
    @Enumerated(EnumType.STRING)
    private OrderStatus status;
}
