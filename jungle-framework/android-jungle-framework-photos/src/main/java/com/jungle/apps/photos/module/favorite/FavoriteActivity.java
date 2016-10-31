/**
 * Android photos application project.
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

package com.jungle.apps.photos.module.favorite;

import android.os.Bundle;
import com.jungle.apps.photos.R;
import com.jungle.apps.photos.base.app.PhotoBaseActivity;
import com.jungle.apps.photos.module.favorite.widget.FavoriteLayoutView;

public class FavoriteActivity extends PhotoBaseActivity {

    FavoriteLayoutView mFavoriteView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_favorite);

        mFavoriteView = (FavoriteLayoutView) findViewById(R.id.favorite_view);
        mFavoriteView.setFavoriteLayoutListener(
                new FavoriteLayoutView.FavoriteLayoutListener() {
                    @Override
                    public void onFavoriteChanged() {
                        updateTitle();
                    }
                });

        updateTitle();
    }

    private void updateTitle() {
        int count = mFavoriteView.getFavoriteCount();
        if (count == 0) {
            setTitle(R.string.my_favorite);
        } else {
            setTitle(String.format(getString(R.string.my_favorite_with_count), count));
        }
    }
}
