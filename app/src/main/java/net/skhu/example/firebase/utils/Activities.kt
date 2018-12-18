package net.skhu.example.firebase.utils

import android.app.Activity
import android.content.Intent
import kotlin.reflect.KClass

fun KClass<out Activity>.startActivity(activity: Activity): Boolean =
        activity.startActivity(Intent(activity, this.java)).let { true }