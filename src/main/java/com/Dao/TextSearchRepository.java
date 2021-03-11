package com.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface TextSearchRepository extends CrudRepository<TextSearch, Integer> {

}
