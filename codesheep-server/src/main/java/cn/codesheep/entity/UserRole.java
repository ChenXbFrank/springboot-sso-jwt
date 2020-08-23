package cn.codesheep.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author 小石潭记
 * @date 2020/8/23 9:41
 * @Description: ${todo}
 */
@Entity(name="user_role")
@Data
public class UserRole {

    @Id
    @GeneratedValue
    private int id;
    private int userId;
    private int roleId;
}
