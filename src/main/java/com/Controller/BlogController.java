package com.Controller;

import com.Dao.*;
import com.sun.xml.bind.v2.runtime.unmarshaller.XsiNilLoader;
import lombok.Data;
import org.apache.tomcat.jni.Time;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;
import sun.jvm.hotspot.oops.Array;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequestMapping("/api/blogs")
@Component
@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class BlogController {

    private static Logger logger= LoggerFactory.getLogger(BlogController.class);

    @Autowired
    private BlogRepository blogRepository;

    @Autowired
    private ArticleRepository articleRepository;


    // article operation

    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping("/getBlog/{id}")
    public Optional<Blog> getBlog(@PathVariable("id") int id){
        logger.info("getBlog received", id);
        Optional<Blog> blog = blogRepository.findById(id);
        return blog;
    }

    @RequestMapping(method = RequestMethod.POST, path = "/getBlogByTitle")
    public Blog getBlogByTitle(@RequestBody Blog blog){
        logger.info("getBlogByTitle received");
        logger.info(blog.toString());
        blog = blogRepository.readByTitle(blog.getTitle());
        return blog;
    }

    // page requests

    @RequestMapping(method = RequestMethod.GET, path = "/getBlogByQuery")
    public Page<Blog> getBlogByQuery(@RequestParam(value = "q", required = true) String query,
                                     @RequestParam(value = "p", defaultValue = "0") int page,
                                     @RequestParam(value = "s", defaultValue = "5") int size){
        logger.info("getBlogByQuery received");

        logger.info(query);

        String[] queryList=query.split(" ", 10);

        logger.info(Arrays.toString(queryList));

        Pageable pageable=PageRequest.of(page,size);
        Page<Blog> blogs;
        if (queryList.length>2){
            // if multiple words are there, then we do search with
            // 1. whole sentence search, every word should appear for at least once.
            // 2. word search, as long as one word is matched.
            // and then sort by relevancy.
            String queryListStr= Arrays.stream(queryList).map(n->String.valueOf(n)).collect(Collectors.joining(" | "));
            blogs=blogRepository.readByKeywordsByTime(query, queryListStr, pageable);
        }else if(queryList.length==2){
            String queryListStr= Arrays.stream(queryList).map(n->String.valueOf(n)).collect(Collectors.joining(" | "));
            blogs=blogRepository.readByKeyPhaseByTime(query, queryListStr, pageable);
        }else{
            blogs=blogRepository.readByKeywordByTime(query, pageable);
        }
        logger.info(blogs.toString());

        return blogs;
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping("/getAllBlogList")
    public Page<Blog> getAllBlogList(@RequestParam(value = "p", defaultValue = "0") int page,
                                     @RequestParam(value = "s", defaultValue = "5") int size){
        logger.info("getBlogList received");
        Timestamp ts=Timestamp.from(Instant.now());
        Pageable pageable= PageRequest.of(page,size);
        Page<Blog> blogList=blogRepository.readAllBlogsByPostdatetimeDescPage(pageable);
        return blogList;
    }




    // blog operation

    @PostMapping("/addBlog")
    public Blog addBlog(@RequestBody Blog blog){
        logger.info("new blog");
        blogRepository.save(blog);
        logger.info("new blog is"+blog.toString());
        return blog;
    }







}
