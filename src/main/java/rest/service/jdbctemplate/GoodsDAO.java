package rest.service.jdbctemplate;

import rest.service.plug.Goods;

import java.util.List;

public interface GoodsDAO {

    Goods get(int id);

    List<Goods> getAll();

    int put(Goods goods);

    int update(Goods goods);

    int delete(int id);

    List<Goods> getPageByAsc(String name, int count, int page);

}
