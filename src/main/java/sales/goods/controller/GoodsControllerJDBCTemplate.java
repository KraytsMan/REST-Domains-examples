package sales.goods.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sales.goods.domain.Goods;
import sales.goods.service.GoodsJDBCTemplateDAO;

import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping("/jdbctemplate")
public class GoodsControllerJDBCTemplate {

    @Autowired
    GoodsJDBCTemplateDAO dao;

    protected static Logger logger = Logger.getLogger(GoodsControllerJDBCTemplate.class.getName());

    @RequestMapping(value = "/goods", method = RequestMethod.GET, produces = "application/json; charset=UTF-8")
    public @ResponseBody
    List<Goods> getAllGoods()
    {
        logger.info("Get all goods");
        return dao.getAll();
    }

    @RequestMapping(value = "/goods/{id}", method = RequestMethod.GET, produces = "application/json; charset=UTF-8")
    public @ResponseBody
    Goods getGoods(@PathVariable int id)
    {
        logger.info("Get goods by id");
        return dao.get(id);
    }

    @RequestMapping(value = "/goods", method = RequestMethod.POST)
    public @ResponseBody int setGoods(@RequestBody String goods) throws IOException {
        logger.info("Goods set goods");
        logger.info(deserialize(goods).toString());
        return dao.put(deserialize(goods));
    }

    @RequestMapping(value = "/goods", method = RequestMethod.PUT)
    public @ResponseBody int updateGoods(@RequestBody String goods) throws IOException {
        logger.info("Goods update goods");
        logger.info(deserialize(goods).toString());
        return dao.update(deserialize(goods));
    }

    @RequestMapping(value = "/goods/{id}", method = RequestMethod.DELETE)
    public @ResponseBody int deleteGoods(@PathVariable int id) throws IOException {
        logger.info("Goods delete goods");
        return dao.delete(id);
    }

    @RequestMapping(value = "/goods/asc", method = RequestMethod.GET)
    public @ResponseBody List<Goods> goodsListByAsc(
            @RequestParam(value = "count") int count,
            @RequestParam(value = "number") int number,
            @RequestParam(value = "field", defaultValue = "id") String field
    ) throws IOException {
        logger.info("Goods get page of goods by asc");
        return dao.getPageByAsc(field, count, number);
    }

    public Goods deserialize(String s) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(s, Goods.class);
    }

}
