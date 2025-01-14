package org.ar.call.utils

import android.annotation.SuppressLint
import android.content.Context
import android.content.SharedPreferences

/**
 * 建议使用mmkv解决
 */
@SuppressLint("StaticFieldLeak")
object SpUtil {

    private lateinit var context:Context
    private const val SP_FILE_NAME = "ARCall"

    fun init(context: Context){
        SpUtil.context = context
    }

    fun edit(holdEdit:(SharedPreferences.Editor)->Unit){
        val edit = context.getSharedPreferences(SP_FILE_NAME,Context.MODE_PRIVATE).edit()
        holdEdit(edit)
        edit.commit()
    }

    fun get(): SharedPreferences {
        return context.getSharedPreferences(SP_FILE_NAME,Context.MODE_PRIVATE)
    }
}