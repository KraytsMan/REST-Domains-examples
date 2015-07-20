package sales.goods.repository;

import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;
import sales.goods.domain.Goods;
import sales.goods.service.AbstractDao;
import sales.goods.service.GoodsHibernateDAO;

import java.util.List;

@Repository("goodsHiberDAO")
public class GoodsHiberImpl extends AbstractDao implements GoodsHibernateDAO {


    public Goods get(int id) {
        return (Goods) getSession().get(Goods.class, new Integer(id));
    }

    public List<Goods> getAll() {
        return getSession().createCriteria(Goods.class).list();
    }

    public int put(Goods goods) {
        getSession().saveOrUpdate(goods);
        return goods.getId();
    }

    public int delete(Goods goods) {
        getSession().delete(goods);
        return goods.getId();
    }

    public List<Goods> pagination(int page, int amount)
    {
        Criteria criteria = this.getSession().createCriteria(Goods.class);
        criteria.setFirstResult((page - 1) * amount);
        criteria.setMaxResults(amount);
        return criteria.list();
    }
}
