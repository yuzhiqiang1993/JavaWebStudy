package com.yzq.bsdiffserver.data

data class BaseResp<T>(
    var code: Int = 200,
    var msg: String = "ok",
    var data: T? = null,
    var time: Long = 0L,

    )
