package com.yzq.kotlin_springboot_maven.extend

import com.yzq.kotlin_springboot_maven.constants.RespEnum
import com.yzq.kotlin_springboot_maven.data.base.BaseResp
import com.yzq.kotlin_springboot_maven.exception.BizException
import kotlinx.coroutines.*
import org.springframework.transaction.interceptor.TransactionAspectSupport
import java.lang.reflect.UndeclaredThrowableException

/**
 * 对异常情况的处理
 * @receiver BaseResp<T>
 * @param e Exception
 */
fun <T> BaseResp<T>.error(e: Exception) {
    var code: Int = RespEnum.ERROR.code
    var msg: String = RespEnum.ERROR.msg
    when (e) {
        is BizException -> {
            code = e.code
            msg = e.message
        }

        is UndeclaredThrowableException -> {
            /*处理未声明的异常信息*/
            msg = e.undeclaredThrowable.message ?: msg
        }

        else -> {
            msg = e.message ?: msg
        }
    }

    this.code = code
    this.message = msg
    this.data = null
}

/**
 * 针对try catch 进行封装，减少一些重复代码
 * @receiver Any
 * @param baseResp BaseResp<T>
 * @param transactionAspect Boolean
 * @param block Function0<Unit>
 */
inline fun <T> tryCatchBlock(baseResp: BaseResp<T>, block: () -> Unit) {
    val currentTimeMillis = System.currentTimeMillis()
    try {
        block()
    } catch (e: Exception) {
        baseResp.error(e)
        e.printStackTrace()
    } finally {
        baseResp.time = System.currentTimeMillis() - currentTimeMillis
    }
}


/**
 * 针对事务的处理  不能加inline 不然 spring 找不到代理对象 报错（可能跟服务端的kotlin版本也有关系  本地1.6.10 没问题)
 * @param baseResp BaseResp<T>
 * @param block Function0<Unit>
 */
fun <T> tryCatchBlockTransaction(baseResp: BaseResp<T>, block: () -> Unit) {
    val currentTimeMillis = System.currentTimeMillis()
    try {
        block()
    } catch (e: Exception) {
        TransactionAspectSupport.currentTransactionStatus().setRollbackOnly()
        baseResp.error(e)
    } finally {
        baseResp.time = System.currentTimeMillis() - currentTimeMillis
    }
}
