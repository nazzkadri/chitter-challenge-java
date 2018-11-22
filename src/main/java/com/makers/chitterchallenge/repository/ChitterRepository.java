package com.makers.chitterchallenge.repository;

import com.makers.chitterchallenge.model.Chitter;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;



    @Repository
    public interface ChitterRepository extends JpaRepository<Chitter, Long> {
       List<Chitter> findAll();
    }

//

//    Optional<Post> findOne(Long post_id);

        //Post save(Post persisted);

//    @Override
//    Optional<Post> findById(Long aLong);

        //    List<Post> findAllByOrderBycreatedAtAsc(Date created_at);
//    public List<Post> findBy(Date createdAt, Sort sort);
//    Post findBycreatedAt(Date createdAt);
//    List<Date> findBypost_idOrderByDateDesc(Date createdAt);
//
//    @Override
//    @Query("select u from Post u left outer join u.finances.selectedAccount")
//    List<Post> findAll(org.springframework.data.domain.Sort sort);



