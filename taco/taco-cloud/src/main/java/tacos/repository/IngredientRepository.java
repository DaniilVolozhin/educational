package tacos.repository;

import org.springframework.data.repository.CrudRepository;
import tacos.entity.Ingredient;

import java.util.List;
import java.util.Optional;

public interface IngredientRepository extends CrudRepository<Ingredient, String> {
    List<Ingredient> findAll();
    Ingredient findIngredientById(String id);
}
