package jpaship;

import javax.persistence.*;

//@Entity
//@Inheritance(strategy = InheritanceType.JOINED) // default singleTable
public class Movie extends Item{

//    @Id @GeneratedValue
//    private Long id;
    private String director;
    private String actor;
}
