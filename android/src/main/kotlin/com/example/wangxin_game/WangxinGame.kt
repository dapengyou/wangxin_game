package com.example.wangxin_game

import android.app.Activity
import android.app.Application
import android.content.Context
import android.util.Log
import android.widget.Toast
import com.starmedia.tinysdk.StarMedia
import io.flutter.app.FlutterApplication

/**
 * @createTime: 5/8/21
 * @author: lady_zhou
 * @Description:
 */
object WangxinGame {
    private val TAG = "WangxinGame"
    var mContext: Context? = null
    var mActivity: Activity? = null

    private var mAppId: String? = null
    var mApplication: Application? = null

    fun init(context: Context, activity: Activity, appId: String) {
        this.mActivity = activity
        this.mContext = context
        this.mAppId = appId
        this.mApplication = mContext as Application

        Log.e("onMethodCall","mAppId = ${mAppId} ")
        StarMedia.init(mApplication!!, "19")
//        StarMedia.setRewardedVideoListener { print("ddd") }
        Log.e("onMethodCall","init之后 ")


        StarMedia.openStarGame(this.mActivity!!) {
            if (!it) {
                Toast.makeText(this.mContext!!, "开发游戏失败", Toast.LENGTH_LONG).show()
            }
        }
    }
}