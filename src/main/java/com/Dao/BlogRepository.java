package com.Dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;

@Repository
public interface BlogRepository extends PagingAndSortingRepository<Blog, Integer> {

    @Query(value = "select * from blogs b order by b.postdatetime desc",
    nativeQuery = true)
    public List<Blog> readAllBlogsByPostdatetimeDesc();

    @Query(value = "select * from blogs b order by b.postdatetime desc",
            nativeQuery = true)
    public Page<Blog> readAllBlogsByPostdatetimeDescPage(Pageable pageable);

    public Blog readByTitle(String title);

    @Query(
            value = "select * from blogs b where id in (select t.id from textsearch t where plainto_tsquery(:query) @@ t.tsv) order by b.postdatetime desc",
    nativeQuery = true)
    public Page<Blog> readByKeywordByTime(@Param("query") String query, Pageable pageable);

    @Query(
            value = "\n" +
                    "with search_res as ((select t.id, ts_rank(t.tsv, q1) rank from textsearch t, to_tsquery('english', :queryList) q1 where q1 @@ t.tsv) union\n" +
                    " (select t.id, ts_rank(t.tsv, q2) rank from textsearch t, plainto_tsquery('english', :query) q2 where q2 @@ t.tsv))\n" +
                    "select * from blogs join (select id, max(rank) final_score from search_res group by id order by final_score desc) query_res on(blogs.id=query_res.id) order by query_res.final_score",
            countQuery = "with search_res as ((select t.id, ts_rank(t.tsv, q1) rank from textsearch t, to_tsquery('english', :queryList) q1 where q1 @@ t.tsv) union\n" +
                    " (select t.id, ts_rank(t.tsv, q2) rank from textsearch t, plainto_tsquery('english', :query) q2 where q2 @@ t.tsv))\n" +
                    "select count(*) from search_res",
            nativeQuery = true)
    public Page<Blog> readByKeywordsByTime(@Param("query") String query, @Param("queryList") String queryList, Pageable pageable);

    @Query(
            value = "with searchRes as ((select t.id, ts_rank(t.tsv, q1) rank from textsearch t, to_tsquery('english', :queryList) q1 where q1 @@ t.tsv) union\n" +
                    " (select t.id, ts_rank(t.tsv, q2) rank from textsearch t, plainto_tsquery('english', :query) q2 where q2 @@ t.tsv) union\n" +
                    " (select t.id, ts_rank(t.tsv, q3) rank from textsearch t, phraseto_tsquery('english', :query) q3 where q3 @@ t.tsv)) \n" +
                    "select b.id, b.author, b.title, b.brief, b.postdatetime, b.url, queryRes.finalScore, b.content from \n" +
                    "blogs b join (select id, max(rank) finalScore from searchRes group by id) queryRes on(b.id=queryRes.id) order by queryRes.finalScore desc",
            countQuery = "with searchRes as ((select t.id, ts_rank(t.tsv, q1) rank from textsearch t, to_tsquery('english', :queryList) q1 where q1 @@ t.tsv) union\n" +
                    " (select t.id, ts_rank(t.tsv, q2) rank from textsearch t, plainto_tsquery('english', :query) q2 where q2 @@ t.tsv) union\n" +
                    " (select t.id, ts_rank(t.tsv, q3) rank from textsearch t, phraseto_tsquery('english', :query) q3 where q3 @@ t.tsv)) \n" +
                    "select count(*) searchRes",
            nativeQuery = true)
    public Page<Blog> readByKeyPhaseByTime(@Param("query") String query, @Param("queryList") String queryList, Pageable pageable);


}
