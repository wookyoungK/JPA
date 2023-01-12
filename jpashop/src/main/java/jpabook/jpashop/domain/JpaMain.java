package jpabook.jpashop.domain;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaMain {
    public static void main(String[] args) {
        //  persistence.xml의 persistence-unit name을 적어준다

//        • 엔티티 매니저 팩토리는 하나만 생성해서 애플리케이션 전체에서 공유
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        //        • 엔티티 매니저는 쓰레드간에 공유X (사용하고 버려야 한다).
        EntityManager em = emf.createEntityManager();

        //• JPA의 모든 데이터 변경은 트랜잭션 안에서 실행
        //단순조회만 하는것이 아니라면 꼭 필요
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        try {
/*
            현재 데이터 중심 설계를 하면 이렇게 ID를 가져오고 다시 Member에서 찾아야한다. -> 객체지향적이 아니다
            Order order = em.find(Order.class, 1L);
            Long memberId = order.getMemberId();

            Member member = em.find(Member.class, memberId);
*/


        }catch ( Exception e){
            tx.rollback();
        }finally {
            em.close();
        }
        emf.close();
    }
}
