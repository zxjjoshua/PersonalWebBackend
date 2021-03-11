package com.Dao;

import lombok.Data;
import org.hibernate.dialect.PostgreSQL9Dialect;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Array;
import java.util.List;


@Entity
@Data
@Table(name="textSearch")
public class TextSearch {
    @Id
    private int id;
    TextSearch(){}
}
