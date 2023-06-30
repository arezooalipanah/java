package com.example.springbootmongodb.repository;

import com.example.springbootmongodb.collection.Person;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonRepository extends MongoRepository<Person, String> {
    List<Person> findByFirstNameStartsWith(String name);

    //    List<Person> findByAgeBetween(Integer minAge, Integer maxAge);
    @Query(value = "{'age' : { $gt : ?0, $lt: ?1}}", fields = "{addressList:  0}")
    List<Person> findPersonByAgeBetween(Integer minAge, Integer maxAge);
}
