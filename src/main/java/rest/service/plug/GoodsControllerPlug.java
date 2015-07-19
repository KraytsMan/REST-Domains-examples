package rest.service.plug;

import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.logging.Logger;

@RestController
@RequestMapping("/goods")
public class GoodsControllerPlug {

    @Resource(name = "goodsservice")
    private GoodsService service;

    protected static Logger logger = Logger.getLogger(GoodsControllerPlug.class.getName());


    @RequestMapping(value = "/", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    public
    @ResponseBody
    ArrayList<Goods> getGoods() {
        logger.info("request: get goods by id");
        return service.getAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    public
    @ResponseBody
    Goods getGoodsById(@PathVariable("id") long id) {
        logger.info("request: get goods by id");
        return service.get(id);
    }

    @RequestMapping(value = "/search", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    public
    @ResponseBody
    Goods searchGoodsByName(@RequestParam(value = "name") String name) {
        logger.info("request: get goods by name");
        return service.search(name);
    }

}
