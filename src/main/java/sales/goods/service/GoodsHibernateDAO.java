package sales.goods.service;

import sales.goods.domain.Goods;

import java.util.List;

public interface GoodsHibernateDAO {

    Goods get(int id);

    List<Goods> getAll();

    int put(Goods goods);

    int delete(Goods goods);

    public List<Goods> pagination(int page, int amount);
}
