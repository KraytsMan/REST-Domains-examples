package sales.goods.service;

import sales.goods.domain.Goods;

import java.util.List;

public interface GoodsHibernateDAO {

    Goods get(int id);

    List<Goods> getAll();

    int put(Goods goods);

    int delete(Goods goods);

    public List<Goods> pagination(int page, int amount);

    public List<Goods> sortASC(String field);

    public List<Goods> sortDESC(String field);

    public List<Goods> search(String name);

    public List<Goods> searchBetween(int from, int to);

    public List<Goods> searchByNameWithBetween(String name, int from, int to);

}
