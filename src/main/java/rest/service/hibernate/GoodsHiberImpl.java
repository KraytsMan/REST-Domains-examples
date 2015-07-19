package rest.service.hibernate;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.hql.internal.ast.util.SessionFactoryHelper;
import org.springframework.stereotype.Repository;
import rest.service.jdbctemplate.GoodsDAO;
import rest.service.jdbctemplate.GoodsImpl;
import rest.service.plug.Goods;

import java.util.List;

@Repository("goodsHiberDAO")
public class GoodsHiberImpl extends AbstractDao implements GoodsHiberDAO {


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
