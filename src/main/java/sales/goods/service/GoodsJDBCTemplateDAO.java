package sales.goods.service;

import sales.goods.domain.Goods;

import java.util.List;

public interface GoodsJDBCTemplateDAO {

    Goods get(int id);

    List<Goods> getAll();

    int put(Goods goods);

    int update(Goods goods);

    int delete(int id);

    List<Goods> getPageByAsc(String name, int count, int page);

}
