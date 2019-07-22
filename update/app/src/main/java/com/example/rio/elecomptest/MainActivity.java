package com.example.rio.elecomptest;

import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.rio.elecomptest.Rest.ApiClient;
import com.example.rio.elecomptest.Rest.ApiInterface;
import com.example.rio.elecomptest.model.GetSlider;
import com.example.rio.elecomptest.model.Slider;
import com.squareup.picasso.Picasso;
import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageClickListener;
import com.synnapps.carouselview.ImageListener;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "LOL";
    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mToogle;
    ApiInterface mApiInterface;
    TextView textSlider;
    private String[] arraygambar,arraytitle;
    private List<Slider> sliderList;

    private int[] mImages = new int[] {
        R.drawable.slider1, R.drawable.slider2, R.drawable.slider3
    };
//
//    private String[] mImagesTitle = new String[] {
//            "Slider 1", "Slider 2", "Slider 3"
//    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textSlider = findViewById(R.id.tvslider);

//        //api interface
//        mApiInterface = ApiClient.getClient().create(ApiInterface.class);
//        Call<GetSlider> sliderCall = mApiInterface.getSlider();
//        sliderCall.enqueue(new Callback<GetSlider>() {
//            @Override
//            public void onResponse(Call<GetSlider> call, Response<GetSlider> response) {
//                sliderList = response.body().getDataSlider();
//                loadData(sliderList);
//                Log.d(TAG, "onResponse: "+String.valueOf(sliderList.size()));
//            }
//
//            @Override
//            public void onFailure(Call<GetSlider> call, Throwable t) {
//                Log.e(TAG,"Retrofit Get"+t.toString());
//            }
//        });

        //drawer
        mDrawerLayout = findViewById(R.id.drawer);
        mToogle = new ActionBarDrawerToggle(this,mDrawerLayout,R.string.open,R.string.close);
        mDrawerLayout.addDrawerListener(mToogle);
        mToogle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        setCarousel();
    }

    private void setCarousel() {
        //carousel
        CarouselView carouselView = findViewById(R.id.carousel);
        carouselView.setPageCount(4);
        carouselView.setImageListener(il);

//        carouselView.setImageListener(new ImageListener() {
//            @Override
//            public void setImageForPosition(int position,ImageView imageView) {
////                imageView.setImageResource(mImages[position]);
//                Picasso.get()
//                        .load("file:///images/"+arraygambar[position])
//                        .into(imageView);
//
//
////                        File imgFile = new File("/sdcard/Images/test_image.jpg");
////                        if(imgFile.exists()){
////                            Bitmap myBitmap = BitmapFactory.decodeFile(imgFile.getAbsolutePath());
////                            imageView.setImageBitmap(myBitmap);
////
////                        }
////                        imageView.setImageResource(arraygambar[position]);
//            }
//        });

        carouselView.setImageClickListener(new ImageClickListener() {
            @Override
            public void onClick(int position) {
                Toast.makeText(MainActivity.this, arraytitle[position], Toast.LENGTH_SHORT).show();
            }
        });

    }

    private ImageListener il = new ImageListener() {
        String[] ag = new String[4];
        String[] at = new String[4];

        @Override
        public void setImageForPosition(int position, ImageView imageView) {
            if (position == 0){
                //api interface
                mApiInterface = ApiClient.getClient().create(ApiInterface.class);
                Call<GetSlider> sliderCall = mApiInterface.getSlider();
                sliderCall.enqueue(new Callback<GetSlider>() {
                    @Override
                    public void onResponse(Call<GetSlider> call, Response<GetSlider> response) {
                        List<Slider> sliderList = response.body().getDataSlider();
                        loadData(sliderList);
                        Log.d(TAG, "onResponse: "+response.body().getDataSlider().get(0).getSlider_judul());
                    }

                    @Override
                    public void onFailure(Call<GetSlider> call, Throwable t) {
                        Log.e(TAG,"Retrofit Get"+t.toString());
                    }
                });
            }
//            File f = new File("./images/slider1.jpg");

//            Log.d(TAG, "setImageForPosition: arraygambar = "
// + ag.get(0));

            Picasso.get()
//                    .load("file:///images/"+arraygambar[position])
//                    .load("http://10.42.0.107/android_api/images/"+ ag.get(position))
                    .load("http://10.42.0.107/android_api/images/slider1.jpg")
                    .into(imageView);
        }
    };

    private void loadData(List<Slider> slider) {
        Log.d(TAG, "loadData: jumlah slider ="+slider.size());
        Log.d(TAG, "loadData: gambar slider ="+slider.get(0).getSlider_gambar());
        arraygambar = new String[4];
        arraytitle = new String[4];

        for(int i=0;i<4;i++){
            arraygambar[i] = slider.get(i).getSlider_gambar();
            arraytitle[i] = slider.get(i).getSlider_judul();
        }
//        for (Slider data : slider) {
//            textSlider.append();
//        }

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(mToogle.onOptionsItemSelected(item)){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
