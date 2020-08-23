package cn.codesheep.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author 小石潭记
 * @date 2020/8/23 9:40
 * @Description: ${todo}
 */
@Entity(name="role")
@Data
// 在转化成json的时候，fasterxml.jackson将对象转换为json报错，发现有字段为null。
@JsonIgnoreProperties(value = { "hibernateLazyInitializer"})
public class Role {

    @Id
    @GeneratedValue
    private int id;

    private String name;
}
