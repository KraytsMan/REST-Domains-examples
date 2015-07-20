package sales.goods.repository;

import org.springframework.jdbc.core.RowMapper;
import sales.goods.domain.Goods;

import java.sql.ResultSet;
import java.sql.SQLException;

public class GoodsRowMaper implements RowMapper<Goods>
{

    public Goods mapRow(ResultSet resultSet, int i) throws SQLException {
        return new Goods.GoodsBuilder()
                .id(resultSet.getInt("id"))
                .name(resultSet.getString("name"))
                .description(resultSet.getString("description"))
                .amount(resultSet.getInt("amount"))
                .price(resultSet.getInt("price"))
                .build();
    }
}
