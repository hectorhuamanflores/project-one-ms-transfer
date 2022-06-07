package pe.com.bootcamp.microservice.transfer.kafka.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import pe.com.bootcamp.microservice.transfer.kafka.redis.model.BootcoinCache;

@Repository
public interface BootcoinRepository extends CrudRepository<BootcoinCache, String> {
}
