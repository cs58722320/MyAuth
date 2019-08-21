/**
 * Copyright (C), 2015-2019
 * FileName: ResultVo
 * Author:   DUJE003
 * Date:     2019/6/6 18:14
 * Description: 返回结果vo
 * History:
 * <author>          <time>          <version>          <desc>
 */
package com.ugg.authserver.controller.vo;

import lombok.Data;

/**
 * 返回结果vo<br> 
 *
 * @author DUJE003
 * @create 2019/6/6
 * @since 1.0.0
 */
@Data
public class ResultVo<T> {

    /**
     * 返回码
     */
    private String msgCode;

    /**
     * 返回消息
     */
    private String msg;

    /**
     * 返回结果对象
     */
    private T result;

}