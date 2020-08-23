package cn.codesheep.repository;

import cn.codesheep.entity.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author 小石潭记
 * @date 2020/8/23 9:34
 * @Description: ${todo}
 */

public interface UserRoleRepository extends JpaRepository<UserRole,Integer> {

    List<UserRole> findByUserId(int userId);

}
