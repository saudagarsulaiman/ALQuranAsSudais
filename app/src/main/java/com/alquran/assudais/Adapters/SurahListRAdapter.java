package com.alquran.assudais.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.alquran.assudais.Interfaces.SelectSurahListener;
import com.alquran.assudais.Models.SurahName;
import com.alquran.assudais.R;
import com.alquran.assudais.Utilities.CommonUtilities;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SurahListRAdapter extends RecyclerView.Adapter<SurahListRAdapter.ViewHolder> {

    Context context;
    SelectSurahListener selectSurahListener;
    ArrayList<SurahName> allSurahList;

    public SurahListRAdapter(Context context, SelectSurahListener selectSurahListener, ArrayList<SurahName> allSurahList) {
        this.context = context;
        this.selectSurahListener = selectSurahListener;
        this.allSurahList = allSurahList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.surah_lyt, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int i) {

        viewHolder.txt_snum.setText("(" + CommonUtilities.getSurahNumber(i) + ")");
        viewHolder.txt_romanName.setText(CommonUtilities.getSurahRomanTitles(i));
        viewHolder.txt_engName.setText(CommonUtilities.getSurahEnglishTitles(i));
        viewHolder.txt_arabicName.setText(CommonUtilities.getSurahArabicTitles(i));
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectSurahListener.SurahSelected(allSurahList, i);
            }
        });

    }

    public void setSurahNumber(Boolean isSelected, int pos) {
        allSurahList.get(pos).setSelected(isSelected);
        notifyItemChanged(pos);
    }

    @Override
    public int getItemCount() {
        return 114;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.txt_arabicName)
        TextView txt_arabicName;
        @BindView(R.id.txt_romanName)
        TextView txt_romanName;
        @BindView(R.id.txt_engName)
        TextView txt_engName;
        @BindView(R.id.txt_snum)
        TextView txt_snum;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

}
