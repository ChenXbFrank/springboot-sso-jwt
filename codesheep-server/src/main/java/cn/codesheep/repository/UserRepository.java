package cn.codesheep.repository;

import cn.codesheep.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author 小石潭记
 * @date 2020/8/23 9:34
 * @Description: ${todo}
 */

public interface UserRepository extends JpaRepository<User,Integer> {

    User findByUsername(String userName);

}
