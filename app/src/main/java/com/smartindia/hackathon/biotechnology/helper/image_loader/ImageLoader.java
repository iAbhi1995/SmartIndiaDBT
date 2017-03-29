package com.smartindia.hackathon.biotechnology.helper.image_loader;

import android.widget.ImageView;
import android.widget.ProgressBar;

/**
 * Created by aman on 28/3/17.
 */

public interface ImageLoader {
    void loadImage(String url, ImageView imageView, ProgressBar progressBar);
}
