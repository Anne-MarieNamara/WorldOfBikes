package com.example.annemarie.worldofbikesdublin;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Context;
import android.content.res.TypedArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.Toast;

public class GalleryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);

        Gallery g = (Gallery) findViewById(R.id.gallery);

        // Create a new ImageAdapter and set in as the Adapter for the Gallery
        g.setAdapter(new ImageAdapter(this));

        // Set an setOnItemClickListener on the Gallery
        g.setOnItemClickListener(new OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {
                // Display a Toast message indicate the selected item
                Toast.makeText(GalleryActivity.this, "" + position,
                        Toast.LENGTH_SHORT).show();
            }
        });
    }

    // The Adapter class used with the Gallery
    public class ImageAdapter extends BaseAdapter {

        private static final int IMAGE_DIM = 800;

        private int mGalleryItemBackground;
        private Context mContext;

        // List of IDs corresponding to the images
        private Integer[] mImageIds = { R.drawable.oconnellst,
                R.drawable.smithfield, R.drawable.templebar, R.drawable.customhousequay,};

        public ImageAdapter(Context c) {
            mContext = c;
            TypedArray a = c.obtainStyledAttributes(R.styleable.GalleryActivity);
            //mGalleryItemBackground = a.getResourceId(R.styleable.GalleryActivity_android_galleryItemBackground, 0);
            a.recycle();
        }



        public int getCount() {
            return mImageIds.length;
        }

        public Object getItem(int position) {
            return mImageIds[position];
        }

        public long getItemId(int position) {
            return position;
        }

        public View getView(int position, View convertView, ViewGroup parent) {

            ImageView imageView = (ImageView) convertView;

            // If convertView is not recycled set it up now
            if (null == imageView) {
                imageView = new ImageView(mContext);

                imageView.setLayoutParams(new Gallery.LayoutParams(IMAGE_DIM,
                        IMAGE_DIM));
                imageView.setScaleType(ImageView.ScaleType.FIT_XY);
                imageView.setBackgroundResource(mGalleryItemBackground);

            }

            // Set the image for the imageView
            imageView.setImageResource(mImageIds[position]);

            return imageView;
        }
    }

}

