package org.ar.call.ui

import android.content.Intent
import android.os.Build
import android.os.Bundle
import androidx.activity.contextaware.withContextAvailable
import androidx.core.app.ActivityOptionsCompat
import androidx.core.util.Pair
import androidx.core.view.ViewCompat
import com.drake.statusbar.immersive
import com.permissionx.guolindev.PermissionX
import kotlinx.coroutines.Dispatchers
import org.ar.call.R
import org.ar.call.databinding.ActivitySplashBinding
import org.ar.call.utils.launch
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext

/**
 * 启动页
 * 1.权限获取
 */
class SplashActivity : BaseActivity() {

    private val permissions = arrayListOf(
        android.Manifest.permission.RECORD_AUDIO,
        android.Manifest.permission.CAMERA,
        android.Manifest.permission.WRITE_EXTERNAL_STORAGE
    )
    private val binding by lazy { ActivitySplashBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //
        setContentView(R.layout.activity_splash)
        //权限
        PermissionX.init(this).permissions(permissions)
            .onExplainRequestReason { scope, deniedList ->
                scope.showRequestReasonDialog(deniedList, "请同意所有权限", "好的", "取消")
            }
            .request { allGranted, grantedList, deniedList ->
                if (allGranted) {
                    launch({
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                            ViewCompat.setTransitionName(binding.ivLogo, "logo")
                        }
                        //这里在主线程做延时肯定就是怪怪的
                        withContext(Dispatchers.IO) {
                            delay(3000)
                        }
                        val optionsCompat = ActivityOptionsCompat.makeSceneTransitionAnimation(
                            this, Pair(binding.ivLogo, "logo")
                        )
                        val i = Intent(this, MainActivity::class.java)
                        this.startActivity(i, optionsCompat.toBundle())
                        finish()
                    })
//
                }
            }


    }
}