package sales.goods.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import sales.goods.domain.Goods;
import sales.goods.service.GoodsHibernateDAO;

import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping("/hibernate")
@Transactional
public class GoodsControllerHibernate {

    protected static Logger logger = Logger.getLogger(GoodsControllerHibernate.class.getName());

    @Autowired(required = true)
    GoodsHibernateDAO dao;

    @RequestMapping(value = "/goods/{id}",
            method = RequestMethod.GET,
            produces = "application/json; charset=UTF-8")
    public
    @ResponseBody
    Goods getGoods(@PathVariable int id) {
        logger.info("Goods: get by id using hibernate");
        return dao.get(id);
    }

    @RequestMapping(value = "/goods",
            method = RequestMethod.GET,
            produces = "application/json; charset=UTF-8")
    public
    @ResponseBody
    List<Goods> getAllGoods() {
        logger.info("Goods: get all by id using hibernate");
        return dao.getAll();
    }

    @RequestMapping(value = "/goods",
            method = RequestMethod.POST,
            produces = "application/json; charset=UTF-8")
    public
    @ResponseBody
    int putGoods(@RequestBody Goods goods) throws IOException {
        logger.info("Goods: save or update using hibernate");
        return dao.put(goods);
    }

    @RequestMapping(value = "/goods",
            method = RequestMethod.DELETE,
            produces = "application/json; charset=UTF-8")
    public
    @ResponseBody
    int removeGoods(@RequestBody Goods goods) throws IOException {
        logger.info("Goods: save or update using hibernate");
        return dao.delete(goods);
    }

    @RequestMapping(value = "/goods/page",
            method = RequestMethod.GET,
            produces = "application/json; charset=UTF-8")
    public
    @ResponseBody
    List<Goods> goodsPagination(
            @RequestParam(value = "page") int page,
            @RequestParam(value = "amount") int amount) throws IOException {
        logger.info("Goods: pagination using hibernate");
        return dao.pagination(page, amount);
    }

    @RequestMapping(value = "/goods/asc",
            method = RequestMethod.GET,
            produces = "application/json; charset=UTF-8")
    public
    @ResponseBody
    List<Goods> goodsASC(
            @RequestParam(value = "field") String field) throws IOException {
        logger.info("Goods: sort by asc using hibernate");
        return dao.sortASC(field);
    }

    @RequestMapping(value = "/goods/desc",
            method = RequestMethod.GET,
            produces = "application/json; charset=UTF-8")
    public
    @ResponseBody
    List<Goods> goodsDESC(
            @RequestParam(value = "field") String field) throws IOException {
        logger.info("Goods: sort by desc using hibernate");
        return dao.sortDESC(field);
    }

    @RequestMapping(value = "/goods/search/{name}",
            method = RequestMethod.GET,
            produces = "application/json; charset=UTF-8")
    public
    @ResponseBody
    List<Goods> goodsSearchByName(
            @PathVariable String name) throws IOException {
        logger.info("Goods: search by name using hibernate");
        return dao.search(name);
    }

    @RequestMapping(value = "/goods/search",
            method = RequestMethod.GET,
            produces = "application/json; charset=UTF-8")
    public
    @ResponseBody
    List<Goods> goodsSearchPriceBetween(
            @RequestParam(value = "from") int from,
            @RequestParam(value = "to") int to) throws IOException {
        logger.info("Goods: search by price using between, using hibernate");
        return dao.searchBetween(from, to);
    }

    @RequestMapping(value = "/goods/search/{name}/scope",
            method = RequestMethod.GET,
            produces = "application/json; charset=UTF-8")
    public
    @ResponseBody
    List<Goods> goodsSearchByNameBetweenPrice(
            @PathVariable String name,
            @RequestParam(value = "from") int from,
            @RequestParam(value = "to") int to) throws IOException {
        logger.info("Goods: search by price using between, using hibernate");
        return dao.searchByNameWithBetween(name, from, to);
    }
}
