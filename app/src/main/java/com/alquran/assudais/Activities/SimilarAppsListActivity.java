package com.alquran.assudais.Activities;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.alquran.assudais.Adapters.SimilarAppListAdapter;
import com.alquran.assudais.Models.SimilarAppsList;
import com.alquran.assudais.R;
import com.alquran.assudais.Utilities.AutoScrollableTextView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SimilarAppsListActivity extends AppCompatActivity {

    @BindView(R.id.img_tlbr_back)
    ImageView img_tlbr_back;
    @BindView(R.id.rview_similar_apps)
    RecyclerView rview_similar_apps;
    @BindView(R.id.txt_tlbr_title)
    AutoScrollableTextView txt_tlbr_title;

    LinearLayoutManager linearLayoutManager;
    SimilarAppListAdapter paraListRAdapter;
    ArrayList<SimilarAppsList> allAppsList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_similar_apps_list);
        ButterKnife.bind(this);

        txt_tlbr_title.setText(getResources().getString(R.string.similar_apps));

        setAppList();

        img_tlbr_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        linearLayoutManager = new LinearLayoutManager(SimilarAppsListActivity.this,RecyclerView.VERTICAL,false);
        rview_similar_apps.setLayoutManager(linearLayoutManager);

    }

    private void setAppList() {
        allAppsList = new ArrayList<>();

        allAppsList.add(new SimilarAppsList("Islam 360 - Prayer Times, Quran , Azan & Qibla", "https://play.google.com/store/apps/details?id=com.islam360&hl=en_IN", R.drawable.islam360));
        allAppsList.add(new SimilarAppsList("Al Quran MP3 - Quran Reading", "https://play.google.com/store/apps/details?id=com.QuranReading.qurannow", R.drawable.alquranmp3));
        allAppsList.add(new SimilarAppsList("iQuran Lite", "https://play.google.com/store/apps/details?id=com.guidedways.iQuran", R.drawable.iquranlite));
        allAppsList.add(new SimilarAppsList("Quran for Android", "https://play.google.com/store/apps/details?id=com.quran.labs.androidquran", R.drawable.quranforandroid));
        allAppsList.add(new SimilarAppsList("Surah Yasin", "https://play.google.com/store/apps/details?id=com.QuranReading.SurahYaseen", R.drawable.surahyasin));
        allAppsList.add(new SimilarAppsList("Hadith Collection - Sahih Bukhari , Muslim & More", "https://play.google.com/store/apps/details?id=com.quarterpi.hadithcollection", R.drawable.hadithcollection));
        allAppsList.add(new SimilarAppsList("Life of Prophet Muhammad PBUH", "https://play.google.com/store/apps/details?id=com.quranreading.lifeofprophet", R.drawable.lifeofprophet));
        allAppsList.add(new SimilarAppsList("Athan: Ramadan 2020, Prayer Times, Azan & Al Quran", "https://play.google.com/store/apps/details?id=com.athan", R.drawable.athan));
        allAppsList.add(new SimilarAppsList("Haramain", "https://play.google.com/store/apps/details?id=com.quranicaudio.haramain", R.drawable.haramain));
//        allAppsList.add(new SimilarAppsList("","",R.drawable));
//        allAppsList.add(new SimilarAppsList("","",R.drawable));
//        allAppsList.add(new SimilarAppsList("","",R.drawable));
//        allAppsList.add(new SimilarAppsList("","",R.drawable));
//        allAppsList.add(new SimilarAppsList("","",R.drawable));
//        allAppsList.add(new SimilarAppsList("","",R.drawable));

        paraListRAdapter= new SimilarAppListAdapter(SimilarAppsListActivity.this,allAppsList);
        rview_similar_apps.setAdapter(paraListRAdapter);

    }
}
