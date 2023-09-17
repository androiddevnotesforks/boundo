/*
 * Copyright 2023 Clifford Liu
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.madness.collision.chief.auth

import android.app.AppOpsManager
import android.os.Process
import androidx.core.content.getSystemService
import com.madness.collision.BuildConfig
import com.madness.collision.chief.chiefContext
import com.madness.collision.chief.os.MiuiDistro
import com.madness.collision.chief.os.distro
import com.madness.collision.util.os.OsUtils

object AppOpsMaster {
    fun isDynamicWallpaperAllowed(): Boolean {
        kotlin.run op@{
            if (distro !is MiuiDistro) return@op
            val opsMan = chiefContext.getSystemService<AppOpsManager>() ?: return@op
            val f = when {
                OsUtils.satisfy(OsUtils.Q) -> AppOpsManager::unsafeCheckOpNoThrow
                else -> ::checkOpLegacy
            }
            try {
                val pkg = BuildConfig.APPLICATION_ID
                return f(opsMan, "MIUI:10045", Process.myUid(), pkg) == AppOpsManager.MODE_ALLOWED
            } catch (e: IllegalArgumentException) {
                e.printStackTrace()
                return@op
            }
        }
        return true
    }

    @Suppress("deprecation")
    private fun checkOpLegacy(manager: AppOpsManager, op: String, uid: Int, pkg: String): Int {
        return manager.checkOpNoThrow(op, uid, pkg)
    }
}