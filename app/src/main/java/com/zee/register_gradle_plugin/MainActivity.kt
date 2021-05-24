package com.zee.register_gradle_plugin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.zee.extendobject.eventBusPostTagNoParam
import com.zee.extendobject.eventBus_RegisterThis
import com.zee.extendobject.showToastShort
import com.zee.utils.ZLibrary
import kotlinx.android.synthetic.main.activity_main.*
import org.greenrobot.eventbus.SubscribeSimple

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ZLibrary.init(application, true)
        setContentView(R.layout.activity_main)
        eventBus_RegisterThis()
        tv_click.setOnClickListener {
            eventBusPostTagNoParam("oncreate")
        }
    }

    @SubscribeSimple("oncreate")
    fun viewCreate() {
        showToastShort("点击成功")
    }
}
