package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;


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
            //회원등록
/*            Member member =new Member();
            member.setId(2L);
            member.setName("HelloA");
            em.persist(member);
*/
            //회원 수정
/*            Member findMember = em.find(Member.class, 1L);
            System.out.println("findMember.getId() = " + findMember.getId());
            System.out.println("findMember.getName() = " + findMember.getName());
*/
            //회원 수정
/*            Member findMember = em.find(Member.class, 1);
            findMember.setName("HelloJPA");
*/
            //JPQL
/*            List<Member> result = em.createQuery("select m from Member as m", Member.class)
                    .setFirstResult(5) //paging
                    .setMaxResults(8)
                    .getResultList();

            for (Member member : result) {
                System.out.println("member = " + member.getName());
            }
*/
            //비영속
            Member member = new Member();
            member.setId(100L);
            member.setName("HelloJPA");

            //영속
            System.out.println("=== BEFORE ===");
            em.persist(member);
            System.out.println("=== AFTER ===");

            //변경(반영)을 하려면 commit 꼭 필요
            tx.commit();
        }catch (Exception e){
            tx.rollback();
        }finally {
            em.close();
        }

        //외부 WAS라면 서버가 내려갈 때 닫아주어야한다. 그래야 connection pool을 없애준다
        emf.close();
    }
}
