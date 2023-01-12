package jpabook.jpashop.domain;


import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "ORDERS")
public class Order {
    @Id @GeneratedValue
    @Column(name = "ORDER_ID")
    private Long id;
    @Column(name = "MEMBER_ID") //객체설계를 테이블에 맞춰서 설계한 것(데이터 중심 설계) -> 객체지향적이지 않는다.
    private Long memberId;

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

    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
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
