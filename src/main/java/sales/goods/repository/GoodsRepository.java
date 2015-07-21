package sales.goods.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sales.goods.domain.Good;

/**
 * Created by volodya on 21.07.15.
 */
public interface GoodsRepository extends JpaRepository<Good, Integer>  {
}
