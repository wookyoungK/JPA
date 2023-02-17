package jpaship;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;


public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {
/*
            팀 저장®
            Team team = new Team();
            team.setName("TeamA");
            em.persist(team);

            연관관계의 주인에 값 설정
            방법1. 연관관계 편의 메소드를 생성하자 -> member set에 선언
            member.changeTeam(team);

            방법2. 연관관계 편의 메소드를 생성하자
            team.addMember(member);

            양뱡향 매핑시 순수한 객체 관계를 고려하면 항상 양쪽다 값을 입력해야 한다.
            team.getMembers().add(member);

            깔끔하게 가져오기 위해서 캐쉬(영속성) 삭제 후 clear
            em.flush();
            em.clear();
*/

            
            tx.commit();
        }catch (Exception e){
            tx.rollback();
        }finally {
            em.close();
        }
        emf.close();
    }
}
