package tacos.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import tacos.entity.Ingredient;

import java.util.List;

public interface IngredientRepository extends CrudRepository<Ingredient, String> {
    List<Ingredient> findAll();

    Ingredient findIngredientById(String id);

    Page<Ingredient> findAll(Pageable var1);
}
