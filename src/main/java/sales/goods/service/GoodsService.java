package sales.goods.service;

import sales.goods.domain.Good;

import java.util.List;

/**
 * Created by volodya on 21.07.15.
 */
public interface GoodsService {

    public Good get(int id);

    public List<Good> getAll();

    public int save(Good goods);

    public int delete(Good goods);

    public List<Good> page(int page, int amount);

}
