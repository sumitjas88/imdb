package com.sumit.repository;

import com.sumit.model.Artist;
import org.springframework.data.repository.CrudRepository;

public interface PersonRepository extends CrudRepository<Artist, Long>{

}
