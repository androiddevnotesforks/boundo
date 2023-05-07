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

package com.madness.collision.diy

import android.content.Context
import android.view.ViewGroup
import android.widget.Space
import androidx.recyclerview.widget.RecyclerView
import com.madness.collision.R

/**
 * adapter that allow easy blank space at both the top and the bottom of the list
 */
abstract class SandwichAdapter<VH : RecyclerView.ViewHolder>(override val context: Context)
    : RecyclerView.Adapter<RecyclerView.ViewHolder>(), SpanAdapter {

    companion object {
        private val TYPE_TOP_COVER = R.bool.diySandwichTopCover
        private val TYPE_BOTTOM_COVER = R.bool.diySandwichBottomCover
        private val TYPE_FILL_IN = R.bool.diySandwichFillIn
    }

    abstract val listCount: Int
    open var topCover: Int = 0
    open var bottomCover: Int = 0

    /**
     * count of items to fill the span
     */
    private val rearFillCount: Int
        get() = if (spanCount == 1) 0 else ((spanCount - (listCount % spanCount)) % spanCount)
    protected val rearCount: Int
        get() = rearFillCount + 1
    protected val frontCount: Int
        get() = spanCount
    private val indexBodyStart: Int
        get() = frontCount
    private val indexFillInStart: Int
        get() = frontCount + listCount
    private val indexBottom: Int
        get() = frontCount + listCount + rearFillCount

    fun notifyListItemChanged(index: Int) {
        notifyItemChanged(index + frontCount)
    }

    override fun getItemViewType(position: Int): Int {
        return when (position) {
            in 0 until indexBodyStart -> TYPE_TOP_COVER
            in indexBodyStart until indexFillInStart -> getBodyItemViewType(position - frontCount)
            in indexFillInStart until indexBottom -> TYPE_FILL_IN
            in indexBottom until itemCount -> TYPE_BOTTOM_COVER
            else -> super.getItemViewType(position)
        }
    }

    protected open fun getBodyItemViewType(index: Int): Int {
        return 0
    }

    class SpaceHolder(itemView: Space) : RecyclerView.ViewHolder(itemView) {
        val space: Space = itemView
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            TYPE_TOP_COVER, TYPE_BOTTOM_COVER, TYPE_FILL_IN -> SpaceHolder(Space(context))
            else -> onCreateBodyItemViewHolder(parent, viewType)
        }
    }

    abstract fun onCreateBodyItemViewHolder(parent: ViewGroup, viewType: Int): VH

    private fun onMakeTopCover(holder: RecyclerView.ViewHolder) {
        if (holder !is SpaceHolder) return
        holder.space.minimumHeight = topCover
    }

    protected open fun onMakeBody(holder: VH, index: Int) {}

    protected open fun onMakeBody(holder: VH, index: Int, payloads: MutableList<Any>) {
        onMakeBody(holder, index)
    }

    private fun onMakeFillIn(holder: RecyclerView.ViewHolder) {
        if (holder !is SpaceHolder) return
        holder.space.minimumHeight = 0
    }

    private fun onMakeBottomCover(holder: RecyclerView.ViewHolder) {
        if (holder !is SpaceHolder) return
        holder.space.minimumHeight = bottomCover
    }

    override fun getItemCount(): Int {
        if (listCount == 0) return 0
        return listCount + frontCount + rearCount
    }

    @Suppress("UNCHECKED_CAST")
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (getItemViewType(position)) {
            TYPE_TOP_COVER -> onMakeTopCover(holder)
            TYPE_FILL_IN -> onMakeFillIn(holder)
            TYPE_BOTTOM_COVER -> onMakeBottomCover(holder)
            else -> onMakeBody(holder as VH, position - frontCount)
        }
    }

    @Suppress("UNCHECKED_CAST")
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int, payloads: MutableList<Any>) {
        when (getItemViewType(position)) {
            TYPE_TOP_COVER -> onMakeTopCover(holder)
            TYPE_FILL_IN -> onMakeFillIn(holder)
            TYPE_BOTTOM_COVER -> onMakeBottomCover(holder)
            else -> onMakeBody(holder as VH, position - frontCount, payloads)
        }
    }
}
