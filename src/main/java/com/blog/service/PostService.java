package com.blog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blog.repository.PostJpaRepository;
import com.blog.repository.PostRepository;
import com.blog.vo.Post;
import java.util.List;
import io.micrometer.common.util.StringUtils;

@Service
public class PostService {

    // private static List<Post> posts;

    @Autowired
    PostJpaRepository jpaRepository;

    @Autowired
    PostRepository postRepository;

    public Post getPost(Long id) {
        Post post = jpaRepository.findOneById(id);
        return post;
    }

    public List<Post> getPosts() {
        return jpaRepository.findAllByOrderByUpdtDateDesc();
    }


    public List<Post> searchPostByTitle(String query) {
        List<Post> posts = jpaRepository.findByContentContainingOrderByUpdtDateDesc(query);
        return posts;
    }

    public boolean savePost(Post post) {
        Post result = jpaRepository.save(post);
        boolean isSuccess = true;
        if (result == null) {
            isSuccess = false;
        }
        return isSuccess;
    }

    public List<Post> getPostsOrderByUpdtAsc() {
        return jpaRepository.findAllByOrderByUpdtDateAsc();
    }

    public List<Post> getPostsOrderByRegDesc() {
        return jpaRepository.findAllByOrderByUpdtDateDesc();
    }

    public List<Post> searchPostByContent(String query) {
        return jpaRepository.findByContentContainingOrderByUpdtDateDesc(query);
    }

    public boolean deletePost(Long id) {
        Post result = jpaRepository.findOneById(id);
        if (result == null)
            return false;

        jpaRepository.deleteById(id);
        return true;
    }

    public boolean updatePost(Post post) {
        Post result = jpaRepository.findOneById(post.getId());
        if (result == null) {
            return false;
        }
        if (!StringUtils.isEmpty(post.getTitle())) {
            result.setTitle(post.getTitle());
        }

        if (!StringUtils.isEmpty(post.getContent())) {
            result.setContent(post.getContent());
        }
        jpaRepository.save(result);
        return true;
    }
}
