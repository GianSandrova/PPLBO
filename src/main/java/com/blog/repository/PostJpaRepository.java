package com.blog.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.blog.vo.Post;
import java.util.List;


@Repository("PostJpaRepository")
public interface PostJpaRepository extends JpaRepository<Post, Serializable> {
    Post findOneById(Long id);
    List<Post> findAllByOrderByUpdtDateDesc();
    List<Post> findAllByOrderByUpdtDateAsc();
    List<Post> findByTitleContainingOrderByUpdtDateDesc(String query);
    List<Post> findByContentContainingOrderByUpdtDateDesc(String query);  
}