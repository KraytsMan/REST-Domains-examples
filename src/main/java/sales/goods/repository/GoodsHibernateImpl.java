package sales.goods.repository;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import sales.goods.domain.Goods;
import sales.goods.service.AbstractDao;
import sales.goods.service.GoodsHibernateDAO;

import java.util.List;

@Repository("goodsHibernateDAO")
public class GoodsHibernateImpl extends AbstractDao implements GoodsHibernateDAO {


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

    public List<Goods> pagination(int page, int amount) {
        Criteria criteria = this.getSession().createCriteria(Goods.class);
        criteria.setFirstResult((page - 1) * amount);
        criteria.setMaxResults(amount);
        return criteria.list();
    }

    public List<Goods> sortASC(String field) {
        Criteria criteria = this.getSession().createCriteria(Goods.class);
        criteria.addOrder(Order.asc(field));
        return criteria.list();
    }

    public List<Goods> sortDESC(String field) {
        Criteria criteria = this.getSession().createCriteria(Goods.class);
        criteria.addOrder(Order.desc(field));
        return criteria.list();
    }

    public List<Goods> search(String name) {
        Criteria criteria = this.getSession().createCriteria(Goods.class);
        criteria.add(Restrictions.ilike("name", "%" + name + "%"));
        return criteria.list();
    }

    public List<Goods> searchBetween(int from, int to) {
        Criteria criteria = this.getSession().createCriteria(Goods.class);
        criteria.add(Restrictions.between("price", from, to));
        return criteria.list();
    }

    public List<Goods> searchByNameWithBetween(String name, int from, int to) {
        Criteria criteria = this.getSession().createCriteria(Goods.class);
        criteria.add(Restrictions.ilike("name", "%" + name + "%"));
        criteria.add(Restrictions.between("price", from, to));
        return criteria.list();
    }

}
