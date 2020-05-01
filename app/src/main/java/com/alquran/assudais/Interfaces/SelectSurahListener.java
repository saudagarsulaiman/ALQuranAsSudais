package com.alquran.assudais.Interfaces;

import com.alquran.assudais.Models.SurahName;

import java.util.ArrayList;

public interface SelectSurahListener {
    public void SurahSelected(ArrayList<SurahName> allSurahList, int pos);
}
