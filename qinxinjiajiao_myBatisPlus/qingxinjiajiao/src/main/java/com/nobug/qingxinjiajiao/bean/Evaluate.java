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

import java.util.Date;

/**
 * 〈〉
 *
 * @author O了吗
 * @create 2019/9/3
 * @since 1.0.0
 */
@TableName("evaluate")
@Data
public class Evaluate {
    private int id;
    private String parentPhone;
    private String teachPhone;
    private String content;
    private String date;
    private String subject;
}