package sales.goods.repository;

import org.springframework.stereotype.Service;
import sales.goods.domain.Goods;

import java.util.ArrayList;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service("goodsService")
public class GoodsService {

    protected static Logger logger = Logger.getLogger(GoodsService.class.getName());

    private ArrayList<Goods> goodsList;

    public GoodsService() {
        logger.info("Create goods list");

        goodsList = new ArrayList<Goods>();

        Goods goods = new Goods.GoodsBuilder()
                .id(1)
                .name("iphone 6")
                .description("can be flexible")
                .amount(2)
                .price(19999)
                .build();

        goodsList.add(goods);

        goods = new Goods.GoodsBuilder()
                .id(2)
                .name("HTC One Max 803n Silver")
                .description("Экран 5.9 (1920x1080, сенсорный)" +
                        " Super LCD3 / моноблок / Qualcomm Snapdragon 600 (1.7 ГГц)" +
                        " / камера 4 Мп + фронтальная 2.1 Мп / Bluetooth 4.0 /" +
                        " Wi-Fi / NFC / MHL / RAM 2 ГБ / 16ГБ встроенной памяти" +
                        " / разъем 3.5 мм / 3G / GPS + GLONASS / Android 4.3 + HTC Sense 5.5" +
                        " / 164.5 x 82.5 x 10.29 мм / 217 г / серебристый")
                .amount(4)
                .price(9784)
                .build();

        goodsList.add(goods);

        goods = new Goods.GoodsBuilder()
                .id(3)
                .name("Dell Venue 8 16GB Black")
                .description("Экран 8 IPS (1280х800), емкостный, Multi-Touch" +
                        " / Intel Atom Z2580 (2 ГГц) / RAM 2 ГБ / 16 ГБ встроенной памяти" +
                        " + поддержка карт памяти microSD / Wi-Fi 802.11b/g/n / Bluetooth 4.0" +
                        " / основная камера 5 Мп, фронтальная - 2 Мп / GPS /" +
                        " ОС Android 4.2 (Jelly Bean) / 372 г / черный")
                .amount(3)
                .price(3699)
                .build();

        goodsList.add(goods);
    }

    public Goods get(long id) {
        logger.info("Get goods by id");
        for (Goods g : goodsList) {
            if (g.getId() == id) {
                return g;
            }
        }
        return null;
    }

    public ArrayList<Goods> getAll() {
        logger.info("Get goods list");
        return goodsList;
    }

    public Goods add(Goods goods) {
        logger.info("Add goods");
        try {
            goodsList.add(goods);
            return goodsList.get(goodsList.size());
        } catch (Exception e) {
            logger.info(e.getMessage());
            return null;
        }
    }

    public Goods update(Goods goods) {
        logger.info("Update goods");
        try {
            for (Goods g : goodsList) {
                if (g.getId() == goods.getId()) {
                    g.setName(goods.getName());
                    g.setDescription(goods.getDescription());
                    g.setAmount(goods.getAmount());
                    g.setPrice(goods.getPrice());
                    return g;
                }
            }
        } catch (Exception e) {
            logger.info(e.getMessage());
            return null;
        }
        return null;
    }

    public Goods delete(Goods goods) {
        logger.info("Delete goods");
        try {
            for (int i = 0; i < goodsList.size(); i++) {
                Goods g = goodsList.get(i);
                if (g.getId() == goods.getId()) {
                    goodsList.remove(i);
                    return g;
                }
            }
        } catch (Exception e) {
            logger.info(e.getMessage());
            return null;
        }
        return null;
    }

    public Goods search(String data) {
        logger.info("Search goods by string fragments");
        try {
            for (Goods g : goodsList) {
                Pattern pattern = Pattern.compile(data, Pattern.CASE_INSENSITIVE);
                Matcher matcher = pattern.matcher(g.getName());
                if (matcher.find()) {
                    return g;
                }
            }
        }catch (Exception e) {
            logger.info(e.getMessage());
            return null;
        }
        return null;
    }


}
