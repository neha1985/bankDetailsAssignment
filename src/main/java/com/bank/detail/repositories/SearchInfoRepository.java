package com.bank.detail.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.bank.detail.model.SearchInfo;

public interface SearchInfoRepository extends MongoRepository<SearchInfo, String> {

}
