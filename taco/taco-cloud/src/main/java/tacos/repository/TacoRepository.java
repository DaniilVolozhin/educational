package tacos.repository;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.repository.CrudRepository;
import tacos.entity.Taco;

import java.net.ContentHandler;
import java.util.Optional;

public interface TacoRepository extends CrudRepository<Taco, Long> {
}
