/*
 * Copyright 2020 Clifford Liu
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

package com.madness.collision.unit.audio_timer

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import com.madness.collision.databinding.AtUpdatesBinding
import com.madness.collision.unit.Updatable
import com.madness.collision.util.TaggedFragment
import kotlinx.coroutines.launch

internal class MyUpdatesFragment : TaggedFragment(), Updatable {

    override val category: String = "AT"
    override val id: String = "MyUpdates"

    private var mCallback: AudioTimerService.Callback? = null
    private lateinit var viewBinding: AtUpdatesBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        viewBinding = AtUpdatesBinding.inflate(inflater, container, false)
        return viewBinding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mCallback = object : AudioTimerService.Callback {
            override fun onTick(targetTime: Long, duration: Long, leftTime: Long) {
            }

            override fun onTick(displayText: String) {
                lifecycleScope.launch {
                    viewBinding.atUpdatesStatus.text = displayText
                }
            }
        }
    }

    override fun onResume() {
        super.onResume()
        AudioTimerService.removeCallback(mCallback)
        AudioTimerService.addCallback(mCallback)
    }

    override fun onPause() {
        AudioTimerService.removeCallback(mCallback)
        super.onPause()
    }

    override fun onHiddenChanged(hidden: Boolean) {
        if (hidden) {
            AudioTimerService.removeCallback(mCallback)
        } else {
            AudioTimerService.removeCallback(mCallback)
            AudioTimerService.addCallback(mCallback)
        }
    }

}
