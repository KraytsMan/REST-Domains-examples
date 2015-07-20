package sales.goods.repository;

import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import sales.goods.domain.Goods;
import sales.goods.service.GoodsJDBCTemplateDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class GoodsTemplateImpl extends JdbcDaoSupport implements GoodsJDBCTemplateDAO {

    public Goods get(int id) {
        String sql = "SELECT * FROM Goods " +
                "Where id=?";
        return getJdbcTemplate().queryForObject(sql, new Object[]{id}, new GoodsRowMaper());
    }

    public List<Goods> getAll() {
        String sql = "SELECT * FROM Goods;";
        return getJdbcTemplate().query(sql, new GoodsRowMaper());
    }

    public int put(final Goods goods) {
        final String sql = "Insert into Goods (name, description, amount, price ) values(?,?,?,?);";
        final KeyHolder holder = new GeneratedKeyHolder();
        getJdbcTemplate().update(new PreparedStatementCreator() {
            public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
                PreparedStatement stmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                stmt.setString(1, goods.getName());
                stmt.setString(2, goods.getDescription());
                stmt.setInt(3, goods.getAmount());
                stmt.setInt(4, goods.getPrice());
                return stmt;
            }
        }, holder);
        return holder.getKey().intValue();
    }

    public int update(final Goods goods) {
        final String sql = "UPDATE Goods SET name=?, description=?, amount=?, price=? WHERE id=?;";
        getJdbcTemplate().update(new PreparedStatementCreator() {
            public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
                PreparedStatement stmt = con.prepareStatement(sql);
                stmt.setString(1, goods.getName());
                stmt.setString(2, goods.getDescription());
                stmt.setInt(3, goods.getAmount());
                stmt.setInt(4, goods.getPrice());
                stmt.setInt(5, goods.getId());
                return stmt;
            }
        });
        return goods.getId();
    }

    public int delete(final int id) {

        final String sql = "DELETE FROM Goods WHERE id=?;";
        getJdbcTemplate().update(new PreparedStatementCreator() {
            public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
                PreparedStatement stmt = con.prepareStatement(sql);
                stmt.setInt(1, id);
                return stmt;
            }
        });
        return id;
    }

    public List<Goods> getPageByAsc(String name, int count, int page) {
        String sql = "SELECT * FROM Goods " +
                "order by "+name+" ASC " +
                "LIMIT "+count+" OFFSET "+(count*page)+";";
        return getJdbcTemplate().query(sql, new GoodsRowMaper());
    }


}
