package com.Dao;

public class BlogArticle{
    private Blog blog;
    private Article article;
    BlogArticle(){}
    BlogArticle(Blog blog, Article article){
        this.blog=blog;
        this.article=article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }

    public void setBlog(Blog blog) {
        this.blog = blog;
    }

    public Article getArticle() {
        return article;
    }

    public Blog getBlog() {
        return blog;
    }

    @Override
    public String toString() {
        return "BlogArticle{" +
                "blog=" + blog +
                ", article=" + article +
                '}';
    }
}
