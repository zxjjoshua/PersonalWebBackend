package com.Dao;

import com.sun.istack.NotNull;
import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Data
@Table(name="blogs")
public class Blog {

    public Blog(){}

    public Blog(String author, String title, String brief,String url, String postdatetime, String content){
        this.author=author;
        this.title=title;
        this.brief=brief;
        this.postdatetime= Timestamp.valueOf(postdatetime);
        this.url=url;
        this.content=content;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    private String author;

    @NotNull
    private String title;
    private Timestamp postdatetime;
    private String brief;
    private String url;
    private String content;



    //
    // ----------  getters and setters  --------
    //
    public int getId(){
        return this.id;
    }

    public void setId(int id){this.id=id;}


    public String getAuthor(){
        return this.author;
    }

    public void setAuthor(String author){this.author=author;}

    public String getTitle(){
        return this.title;
    }

    public void setTitle(String title){this.title=title;}

    public Timestamp getPostdatetime(){return this.postdatetime;}

    public void setPostdatetime(String postdatetime){this.postdatetime=Timestamp.valueOf(postdatetime);}

    public void setPostdatetime(Timestamp postdatetime){this.postdatetime=postdatetime;}

    public void setPostdatetime(Long postdatetime){this.postdatetime=new Timestamp(postdatetime);}

    public String getBrief(){ return this.brief; }

    public void setBrief(String brief){ this.brief=brief; }

    public String getUrl(){ return this.url;}

    public void setUrl(String url){ this.url=url;}


    @Override
    public String toString() {
        return "Blog{" +
                "id=" + id +
                ", author='" + author + '\'' +
                ", title='" + title + '\'' +
                ", postdatetime=" + postdatetime +
                ", brief='" + brief + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
