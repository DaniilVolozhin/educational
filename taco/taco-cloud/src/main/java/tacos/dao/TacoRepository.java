package tacos.dao;

import tacos.entity.Taco;

public interface TacoRepository {
    Taco save(Taco ingredient);
}
