package com.chlang.common.annotation;

import java.lang.annotation.*;

/**
 * 控制层日志注解
 *
 * @author chenlang
 * @date 2020/6/4 11:15 上午
 **/
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface ControllerWebLog {
    /**
     * 接口名称
     * @return
     */
    String apiName();

    /**
     * 是否插入到数据库
     * @return
     */
    boolean intoDb() default false;
}
