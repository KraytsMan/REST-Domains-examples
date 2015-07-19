package rest.service.hibernate;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import rest.service.plug.Goods;

import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping("/hibernate")
@Transactional
public class GoodsHiberController {

    protected static Logger logger = Logger.getLogger(GoodsHiberController.class.getName());

    @Autowired
    GoodsHiberDAO dao;

    @RequestMapping(value = "/goods/{id}", method = RequestMethod.GET, produces = "application/json; charset=UTF-8")
    public
    @ResponseBody
    Goods getGoods(@PathVariable int id) {
        logger.info("Goods: get by id using hibernate");
        return dao.get(id);
    }

    @RequestMapping(value = "/goods", method = RequestMethod.GET, produces = "application/json; charset=UTF-8")
    public
    @ResponseBody
    List<Goods> getAllGoods() {
        logger.info("Goods: get all by id using hibernate");
        return dao.getAll();
    }

    @RequestMapping(value = "/goods", method = RequestMethod.POST, produces = "application/json; charset=UTF-8")
    public
    @ResponseBody
    int putGoods(@RequestBody String s) throws IOException {
        logger.info("Goods: save or update using hibernate");
        return dao.put(deserialize(s));
    }

    @RequestMapping(value = "/goods", method = RequestMethod.DELETE, produces = "application/json; charset=UTF-8")
    public
    @ResponseBody
    int removeGoods(@RequestBody String s) throws IOException {
        logger.info("Goods: save or update using hibernate");
        return dao.delete(deserialize(s));
    }

    @RequestMapping(value = "/goods/page", method = RequestMethod.GET, produces = "application/json; charset=UTF-8")
    public
    @ResponseBody
    List<Goods> goodsPagination(
            @RequestParam(value = "page") int page,
            @RequestParam(value = "amount") int amount) throws IOException {
        logger.info("Goods: save or update using hibernate");
        return dao.pagination(page, amount);
    }

    public Goods deserialize(String s) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(s, Goods.class);
    }


}
