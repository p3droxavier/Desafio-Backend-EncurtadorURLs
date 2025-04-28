package repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import entities.UrlEntitys;

public interface UrlRepository extends MongoRepository<UrlEntitys, String>{
}
