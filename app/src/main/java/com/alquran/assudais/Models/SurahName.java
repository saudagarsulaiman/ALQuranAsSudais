package com.alquran.assudais.Models;

public class SurahName {
    String surahName;
    int surahNum;
    Boolean isSelected = false;

    public String getSurahName() {
        return surahName;
    }

    public void setSurahName(String surahName) {
        this.surahName = surahName;
    }

    public int getSurahNum() {
        return surahNum;
    }

    public void setSurahNum(int surahNum) {
        this.surahNum = surahNum;
    }

    public Boolean getSelected() {
        return isSelected;
    }

    public void setSelected(Boolean selected) {
        isSelected = selected;
    }
}
