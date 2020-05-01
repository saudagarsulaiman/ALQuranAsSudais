package com.alquran.assudais.Activities;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.alquran.assudais.Adapters.SurahListRAdapter;
import com.alquran.assudais.Interfaces.SelectSurahListener;
import com.alquran.assudais.Models.SurahName;
import com.alquran.assudais.R;
import com.alquran.assudais.Utilities.AutoScrollableTextView;
import com.alquran.assudais.Utilities.CommonUtilities;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SurahActivity extends AppCompatActivity {


    @BindView(R.id.rview_surah)
    RecyclerView rview_surah;
    //DEMO
    @BindView(R.id.btn_next)
    Button btn_next;
    @BindView(R.id.btn_pause)
    Button btn_pause;
    @BindView(R.id.btn_play)
    Button btn_play;
    @BindView(R.id.btn_previous)
    Button btn_previous;
    @BindView(R.id.txt_surah_name)
    AutoScrollableTextView txt_surah_name;
    @BindView(R.id.txt_cur_time)
    TextView txt_cur_time;
    @BindView(R.id.txt_total_time)
    TextView txt_total_time;
    @BindView(R.id.seekbar)
    SeekBar seekbar;
    @BindView(R.id.img_tlbr_back)
    ImageView img_tlbr_back;
    @BindView(R.id.txt_tlbr_title)
    AutoScrollableTextView txt_tlbr_title;
    @BindView(R.id.lnr_player_info)
    LinearLayout lnr_player_info;

    LinearLayoutManager linearLayoutManager;
    SurahListRAdapter surahListRAdapter;
    SelectSurahListener selectSurahListener;
    ArrayList<SurahName> allSurahList;
    String selectedSurahName = "s1";
    int selectedSurahNum = 0;
    private double startTime = 0;
    private double finalTime = 0;
    private Handler myHandler = new Handler();
    private int forwardTime = 5000;
    private int backwardTime = 5000;
    public static int oneTimeOnly = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_surah);
        ButterKnife.bind(this);

        img_tlbr_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        txt_tlbr_title.setText(getResources().getText(R.string.listen_quran));
        if (CommonUtilities.mediaPlayer == null) {
            CommonUtilities.mediaPlayer = MediaPlayer.create(this, R.raw.s1);
        }
        allSurahList = new ArrayList<>();
   /*     for (int i = 1; i < 115; i++) {
            SurahName surahName = new SurahName();
            surahName.setSurahName("s" + i);
            surahName.setSurahNum(i);
            allSurahList.add(surahName);
        }*/
        for (int i = 0; i < 69; i++) {
            SurahName surahName = new SurahName();
            surahName.setSurahName("s" + CommonUtilities.getSurahNumber(i));
            surahName.setSurahNum(CommonUtilities.getSurahNumber(i));
            allSurahList.add(surahName);
        }
        linearLayoutManager = new LinearLayoutManager(SurahActivity.this, LinearLayoutManager.VERTICAL, false);
        rview_surah.setLayoutManager(linearLayoutManager);
        selectSurahListener = new SelectSurahListener() {
            @Override
            public void SurahSelected(ArrayList<SurahName> allSurahList, int pos) {
                int i = 0;
                for (SurahName surahName : allSurahList) {
                    if (surahName.getSelected() != null)
                        if (surahName.getSelected()) {
                            surahName.setSelected(false);
                            surahListRAdapter.notifyDataSetChanged();
                        }
                    i++;
                }
                surahListRAdapter.setSurahNumber(!allSurahList.get(pos).getSelected(), pos);
                if (allSurahList.get(pos).getSelected()) {
                    selectedSurahNum = pos;
                    selectedSurahName = allSurahList.get(pos).getSurahName();
                    Toast.makeText(SurahActivity.this, getResources().getText(R.string.playing) + " : " + CommonUtilities.getSurahArabicTitles(selectedSurahNum), Toast.LENGTH_SHORT).show();

                    if (CommonUtilities.mediaPlayer.isPlaying()) /*{*/
                        CommonUtilities.mediaPlayer.stop();

                    CommonUtilities.mediaPlayer = CommonUtilities.getSurah(SurahActivity.this, selectedSurahName);
                    lnr_player_info.setVisibility(View.VISIBLE);
                    media();
                }
                CommonUtilities.mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        btn_pause.setEnabled(false);
                        btn_play.setEnabled(true);
                        btn_pause.setBackgroundResource(R.drawable.rec_green_grey_c10);
                        btn_play.setBackgroundResource(R.drawable.rec_green_white_c10);


                    }
                });
            }
        };
        surahListRAdapter = new SurahListRAdapter(SurahActivity.this, selectSurahListener, allSurahList);
        rview_surah.setAdapter(surahListRAdapter);
//        DEMO
        txt_surah_name.setText("(" + CommonUtilities.getSurahArabicTitles(selectedSurahNum) + ")-\t(" + CommonUtilities.getSurahRomanTitles(selectedSurahNum) + ")-\t(" + CommonUtilities.getSurahEnglishTitles(selectedSurahNum) + ")");
//        CommonUtilities.mediaPlayer = MediaPlayer.create(this, R.raw.s1);
        seekbar.setClickable(false);
        btn_pause.setEnabled(false);
        btn_pause.setBackgroundResource(R.drawable.rec_green_grey_c10);
        btn_play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (CommonUtilities.mediaPlayer.isPlaying())
                    CommonUtilities.mediaPlayer.stop();
                media();
            }
        });
        btn_pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(getApplicationContext(), getResources().getText(R.string.paused), Toast.LENGTH_SHORT).show();
                CommonUtilities.mediaPlayer.pause();
                btn_pause.setEnabled(false);
                btn_play.setEnabled(true);
                btn_pause.setBackgroundResource(R.drawable.rec_green_grey_c10);
                btn_play.setBackgroundResource(R.drawable.rec_green_white_c10);
            }
        });
        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int temp = (int) startTime;

                if ((temp + forwardTime) <= finalTime) {
                    startTime = startTime + forwardTime;
                    CommonUtilities.mediaPlayer.seekTo((int) startTime);
//                    Toast.makeText(getApplicationContext(), getResources().getText(R.string.frwd5sec), Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getApplicationContext(), getResources().getText(R.string.cant_frwd5sec), Toast.LENGTH_SHORT).show();
                }
            }
        });
        btn_previous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int temp = (int) startTime;

                if ((temp - backwardTime) > 0) {
                    startTime = startTime - backwardTime;
                    CommonUtilities.mediaPlayer.seekTo((int) startTime);
//                    Toast.makeText(getApplicationContext(), getResources().getText(R.string.bkwd5sec), Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getApplicationContext(), getResources().getText(R.string.cant_bkwd5sec), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void media() {
        txt_surah_name.setText("(" + CommonUtilities.getSurahArabicTitles(selectedSurahNum) + ")-\t(" + CommonUtilities.getSurahRomanTitles(selectedSurahNum) + ")-\t(" + CommonUtilities.getSurahEnglishTitles(selectedSurahNum) + ")");
        CommonUtilities.mediaPlayer.start();
        finalTime = CommonUtilities.mediaPlayer.getDuration();
        startTime = CommonUtilities.mediaPlayer.getCurrentPosition();
        seekbar.setMax((int) finalTime);
        txt_total_time.setText(String.format("%d:%d",
                TimeUnit.MILLISECONDS.toMinutes((long) finalTime),
                TimeUnit.MILLISECONDS.toSeconds((long) finalTime) -
                        TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes((long)
                                finalTime)))
        );
        txt_cur_time.setText(String.format("%d:%d",
                TimeUnit.MILLISECONDS.toMinutes((long) startTime),
                TimeUnit.MILLISECONDS.toSeconds((long) startTime) -
                        TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes((long)
                                startTime)))
        );
        seekbar.setProgress((int) startTime);
        myHandler.postDelayed(UpdateSongTime, 100);
        btn_pause.setEnabled(true);
        btn_play.setEnabled(false);
        btn_pause.setBackgroundResource(R.drawable.rec_green_white_c10);
        btn_play.setBackgroundResource(R.drawable.rec_green_grey_c10);
    }

    private Runnable UpdateSongTime = new Runnable() {
        public void run() {
            startTime = CommonUtilities.mediaPlayer.getCurrentPosition();
            finalTime = CommonUtilities.mediaPlayer.getDuration();
            txt_cur_time.setText(String.format("%d:%d",
                    TimeUnit.MILLISECONDS.toMinutes((long) startTime),
                    TimeUnit.MILLISECONDS.toSeconds((long) startTime) -
                            TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.
                                    toMinutes((long) startTime)))
            );
            seekbar.setProgress((int) startTime);
            myHandler.postDelayed(this, 100);
        }
    };

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        if (CommonUtilities.mediaPlayer.isPlaying()) /*{*/
            CommonUtilities.mediaPlayer.stop();
    }
}
