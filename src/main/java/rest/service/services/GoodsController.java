package rest.service.services;

import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.logging.Logger;

@RestController
@RequestMapping("/goods")
public class GoodsController {

    @Resource(name="goodsservice")
    private GoodsService service;

    protected static Logger logger = Logger.getLogger(GoodsController.class.getName());


    @RequestMapping(value = "/", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    public @ResponseBody
    String getGoods() {
        logger.info("request: get goods by id");
        return service.getAll().toString();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    public @ResponseBody String getGoodsById(@PathVariable("id") long id)
    {
        logger.info("request: get goods by id");
        return service.get(id).toString();
    }

}
