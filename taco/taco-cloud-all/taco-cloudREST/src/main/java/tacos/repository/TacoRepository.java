package tacos.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import tacos.entity.Taco;

public interface TacoRepository extends PagingAndSortingRepository<Taco, Long> {

    Page<Taco> findAll(Pageable var1);

}
