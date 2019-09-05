/**
 * FileName:   Parent
 * Author:     O了吗
 * Date:       2019/9/3 0:09
 * Description:
 * History:
 * author:     oleolema
 */
package com.nobug.qingxinjiajiao.bean;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.NonNull;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;

/**
 * 〈〉
 *
 * @author O了吗
 * @create 2019/9/3
 * @since 1.0.0
 */
@TableName("parent")
@Data
@Validated
public class Parent {
    private int id;
    @NotNull
    @NonNull
    private String phoneNum;
    @NotNull
    @NonNull
    private String password;
    private String icon;
    private String address;

}