package com.yzq.kotlin_springboot_maven.handler

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler
import org.apache.ibatis.reflection.MetaObject
import org.springframework.stereotype.Component
import java.time.LocalDateTime


/**
 * @description: 默认数据填充
 * @author : yuzhiqiang (zhiqiang.yu.xeon@gmail.com)
 */

@Component
class FillMetaObjectHandler : MetaObjectHandler {
    override fun insertFill(metaObject: MetaObject) {
        this.strictInsertFill(
            metaObject, "createTime",
            { LocalDateTime.now() },//  ()->LocalDateTime.now()  或  LocalDateTime::now
            LocalDateTime::class.java
        )

        this.strictInsertFill(
            metaObject, "updateTime",
            { LocalDateTime.now() },
            LocalDateTime::class.java
        )

    }

    override fun updateFill(metaObject: MetaObject) {
        /*正常写法*/
        strictInsertFill(
            metaObject, "updateTime",
            { LocalDateTime.now() },
            LocalDateTime::class.java
        )

    }


}
