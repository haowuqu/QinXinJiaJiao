/**
 * FileName:   Parent
 * Author:     O了吗
 * Date:       2019/9/3 0:09
 * Description:
 * History:
 * author:     oleolema
 */
package com.nobug.qingxinjiajiao.bean;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.NonNull;

import java.util.Date;

/**
 * 〈〉
 *
 * @author O了吗
 * @create 2019/9/3
 * @since 1.0.0
 */
@TableName("reserve")
@Data
public class Reserve {
    private int id;
    @NonNull
    private String parentPhone;
    @NonNull
    private String teachPhone;
    @NonNull
    private String teachName;
    @NonNull
    private String subject;
    @NonNull
    private String date;
}