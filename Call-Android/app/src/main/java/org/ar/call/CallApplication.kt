package org.ar.call

import android.annotation.SuppressLint
import android.app.Activity
import android.app.Application
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.ContentResolver
import android.content.Context
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import androidx.lifecycle.*
import com.kongzue.dialogx.DialogX
import org.ar.call.utils.SpUtil
import kotlin.properties.Delegates
import android.media.AudioAttributes
import android.net.Uri
import com.kongzue.dialogx.style.IOSStyle
//import com.tencent.bugly.crashreport.CrashReport


class CallApplication :Application(), ViewModelStoreOwner,Application.ActivityLifecycleCallbacks{

    private val appViewModel by lazy { ViewModelStore() }
    var curActivity:Activity? = null

    companion object{
        var callApp : CallApplication by Delegates.notNull()
//        @SuppressLint("StaticFieldLeak")
//        lateinit var  callApp : CallApplication
    }

    override fun onCreate() {
        super.onCreate()
        callApp = this
        SpUtil.init(this)//kv存储
        DialogX.init(this)
        DialogX.cancelButtonText="取消"
        DialogX.globalStyle = IOSStyle.style();
        registerActivityLifecycleCallbacks(this)
//        CrashReport.initCrashReport(this.applicationContext, "939abb0f89", BuildConfig.DEBUG)
    }

    override fun getViewModelStore(): ViewModelStore {
        return appViewModel
    }


    override fun onActivityCreated(activity: Activity, savedInstanceState: Bundle?) {
    }

    override fun onActivityStarted(activity: Activity) {
        curActivity = activity
    }

    override fun onActivityResumed(activity: Activity) {
    }

    override fun onActivityPaused(activity: Activity) {
    }

    override fun onActivityStopped(activity: Activity) {
    }

    override fun onActivitySaveInstanceState(activity: Activity, outState: Bundle) {
    }

    override fun onActivityDestroyed(activity: Activity) {
    }


}