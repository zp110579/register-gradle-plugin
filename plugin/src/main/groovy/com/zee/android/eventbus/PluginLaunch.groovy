package com.zee.android.eventbus


import com.android.build.gradle.AppExtension
import com.android.build.gradle.AppPlugin
import com.zee.android.eventbus.utils.Logger
import com.zee.android.eventbus.utils.ScanSetting
import org.gradle.api.Plugin
import org.gradle.api.Project

/**
 * Simple version of AutoRegister plugin for ZxRouter
 * @author billy.qi email: qiyilike@163.com
 */
public class PluginLaunch implements Plugin<Project> {

    @Override
    public void apply(Project project) {
        def isApp = project.plugins.hasPlugin(AppPlugin)
        //only application module needs this plugin to generate register code
        if (isApp) {
            Logger.make(project)

            Logger.i('Project enable ZxAutoCreate plugin')

            def android = project.extensions.getByType(AppExtension)
            def transformImpl = new RegisterTransform(project)

            //init arouter-auto-register settings
            ArrayList<ScanSetting> list = new ArrayList<>(2)
            //路由
            list.add(new ScanSetting('IRoute'))
            //Eventbus
            list.add(new ScanSetting('SubscriberInfoIndex'))

            list.add(new ScanSetting('IRunApplicationOnCreate'))
            RegisterTransform.registerList = list
            //register this plugin
            android.registerTransform(transformImpl)
        }
    }

}
