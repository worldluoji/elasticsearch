package com.example.elasticsearch.repository;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import com.example.elasticsearch.model.User;

/*
* 实际上是使用了JAP的PagingAndSortingRepository
* */
public interface UserRepository extends ElasticsearchRepository<User, Long> {

}
