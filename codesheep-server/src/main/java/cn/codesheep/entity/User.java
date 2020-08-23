package cn.codesheep.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author 小石潭记
 * @date 2020/8/23 9:33
 * @Description: ${todo}
 */
@Entity(name="user")
@Data
public class User implements Serializable {

    @Id
    @GeneratedValue
    private int id;

    private String username;

    private String password;

}