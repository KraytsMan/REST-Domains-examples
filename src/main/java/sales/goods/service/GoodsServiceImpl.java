package sales.goods.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sales.goods.domain.Good;
import sales.goods.repository.GoodsRepository;

import java.util.List;

@Service("goodsService")
@Transactional
public class GoodsServiceImpl implements GoodsService {

    @Autowired
    private GoodsRepository repository;

    public Good get(int id) {
        return repository.getOne(id);
    }

    public List<Good> getAll() {
        return repository.findAll();
    }

    public int save(Good good) {
        repository.save(good);
        return good.getId();
    }

    public int delete(Good goods) {
        repository.delete(goods);
        return goods.getId();
    }

    public List<Good> page(int page, int amount) {
        Page<Good> goodsPage = repository.findAll(new PageRequest(page, amount));
        return goodsPage.getContent();
    }
}
