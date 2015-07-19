package rest.service.hibernate;

import rest.service.plug.Goods;

import java.util.List;

public interface GoodsHiberDAO {

    Goods get(int id);

    List<Goods> getAll();

    int put(Goods goods);

    int delete(Goods goods);

    public List<Goods> pagination(int page, int amount);
}
