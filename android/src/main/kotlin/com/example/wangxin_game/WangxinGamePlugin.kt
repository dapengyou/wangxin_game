package com.example.wangxin_game

import android.app.Activity
import android.app.Application
import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.annotation.NonNull
import com.starmedia.tinysdk.StarMedia

import io.flutter.embedding.engine.plugins.FlutterPlugin
import io.flutter.embedding.engine.plugins.activity.ActivityAware
import io.flutter.embedding.engine.plugins.activity.ActivityPluginBinding
import io.flutter.plugin.common.MethodCall
import io.flutter.plugin.common.MethodChannel
import io.flutter.plugin.common.MethodChannel.MethodCallHandler
import io.flutter.plugin.common.MethodChannel.Result
import io.flutter.plugin.common.PluginRegistry

/** WangxinGamePlugin */
class WangxinGamePlugin : FlutterPlugin, MethodCallHandler, ActivityAware {
    private var applicationContext: Context? = null
    private var mActivity: Activity? = null
    private lateinit var channel: MethodChannel

    override fun onAttachedToEngine(@NonNull flutterPluginBinding: FlutterPlugin.FlutterPluginBinding) {
        channel = MethodChannel(flutterPluginBinding.binaryMessenger, "wangxin_game")
        channel.setMethodCallHandler(this)
        applicationContext = flutterPluginBinding.applicationContext

    }

    companion object {
        private var channelName = "wangxin_game"
        @JvmStatic
        fun registerWith(registrar: PluginRegistry.Registrar) {
            val channel = MethodChannel(registrar.messenger(), channelName)
            channel.setMethodCallHandler(WangxinGamePlugin())
        }
    }

    //接收flutter传递过来的信息
    override fun onMethodCall(@NonNull call: MethodCall, @NonNull result: Result) {
        if (call.method == "wangxinGame") {
            val appId = call.argument<String>("appId")
//            val gameCode = call.argument<String>("gameCode") as String
//            var debug = call.argument<Boolean>("debug")
            if (appId == null || appId.trim { it <= ' ' }.isEmpty()) {
                result.error("500", "appId can't be null", null)
            } else {
                Log.e("onMethodCall","appId=${appId}")
                WangxinGame.init(applicationContext!!, mActivity!!, appId)
                result.success(true)
            }
        } else {
            result.notImplemented()
        }
    }

    override fun onDetachedFromEngine(@NonNull binding: FlutterPlugin.FlutterPluginBinding) {
        channel.setMethodCallHandler(null)
    }

    override fun onDetachedFromActivity() {
        mActivity = null
    }

    override fun onReattachedToActivityForConfigChanges(binding: ActivityPluginBinding) {
        mActivity = binding.activity
    }

    override fun onAttachedToActivity(binding: ActivityPluginBinding) {
        mActivity = binding.activity
    }

    override fun onDetachedFromActivityForConfigChanges() {
        mActivity = null
    }
}
