package com.zee.register_gradle_plugin

import com.zee.annotation.RunApplicationOnCreate
import com.zee.log.ZLog

/**
 *created by zee on 2021/5/24.
 *
 */
@RunApplicationOnCreate
class RunMainApplication {
    init {
        ZLog.i("初始化")
    }
}