package com.suqir.library.permissionx

import androidx.fragment.app.FragmentActivity

/**
 * Author: Suqir
 * Date: 2020/8/7 19:53
 * Desc: 对外的接口， 单例类方便调用
 **/
object PermissionX {
    private const val TAG = "InvisibleFragment"

    fun request(
        activity: FragmentActivity,
        vararg permissions: String,
        callback: PermissionCallback
    ) {
        val fragmentManager = activity.supportFragmentManager
        val existedFragmnet = fragmentManager.findFragmentByTag(TAG)
        val fragment = if (existedFragmnet != null) {
            existedFragmnet as InvisibleFragment
        } else {
            val invisibleFragment = InvisibleFragment()
            fragmentManager.beginTransaction().add(invisibleFragment, TAG).commitNow()
            invisibleFragment
        }
        fragment.requestNow(callback, *permissions)
    }
}