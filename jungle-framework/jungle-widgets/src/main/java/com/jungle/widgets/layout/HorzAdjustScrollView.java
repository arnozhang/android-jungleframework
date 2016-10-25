/**
 * Android Jungle framework project.
 *
 * Copyright 2016 Arno Zhang <zyfgood12@163.com>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.jungle.widgets.layout;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ScrollView;

public class HorzAdjustScrollView extends ScrollView {

    private float mLastX = 0;
    private float mLastY = 0;


    public HorzAdjustScrollView(Context context) {
        super(context);
        initLayout(context);
    }

    public HorzAdjustScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initLayout(context);
    }

    public HorzAdjustScrollView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initLayout(context);
    }

    private void initLayout(Context context) {
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent event) {
        int action = event.getAction();
        if (action == MotionEvent.ACTION_DOWN) {
            mLastX = event.getX();
            mLastY = event.getY();
        } else if (action == MotionEvent.ACTION_MOVE) {
            if (Math.abs(event.getX() - mLastX) > Math.abs(event.getY() - mLastY)) {
                return false;
            }
        }

        return super.onInterceptTouchEvent(event);
    }
}