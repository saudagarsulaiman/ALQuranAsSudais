// Generated code from Butter Knife. Do not modify!
package com.alquran.assudais.Activities;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.alquran.assudais.R;
import com.alquran.assudais.Utilities.AutoScrollableTextView;
import java.lang.IllegalStateException;
import java.lang.Override;

public class SurahActivity_ViewBinding implements Unbinder {
  private SurahActivity target;

  @UiThread
  public SurahActivity_ViewBinding(SurahActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public SurahActivity_ViewBinding(SurahActivity target, View source) {
    this.target = target;

    target.rview_surah = Utils.findRequiredViewAsType(source, R.id.rview_surah, "field 'rview_surah'", RecyclerView.class);
    target.btn_next = Utils.findRequiredViewAsType(source, R.id.btn_next, "field 'btn_next'", Button.class);
    target.btn_pause = Utils.findRequiredViewAsType(source, R.id.btn_pause, "field 'btn_pause'", Button.class);
    target.btn_play = Utils.findRequiredViewAsType(source, R.id.btn_play, "field 'btn_play'", Button.class);
    target.btn_previous = Utils.findRequiredViewAsType(source, R.id.btn_previous, "field 'btn_previous'", Button.class);
    target.txt_surah_name = Utils.findRequiredViewAsType(source, R.id.txt_surah_name, "field 'txt_surah_name'", AutoScrollableTextView.class);
    target.txt_cur_time = Utils.findRequiredViewAsType(source, R.id.txt_cur_time, "field 'txt_cur_time'", TextView.class);
    target.txt_total_time = Utils.findRequiredViewAsType(source, R.id.txt_total_time, "field 'txt_total_time'", TextView.class);
    target.seekbar = Utils.findRequiredViewAsType(source, R.id.seekbar, "field 'seekbar'", SeekBar.class);
    target.img_tlbr_back = Utils.findRequiredViewAsType(source, R.id.img_tlbr_back, "field 'img_tlbr_back'", ImageView.class);
    target.txt_tlbr_title = Utils.findRequiredViewAsType(source, R.id.txt_tlbr_title, "field 'txt_tlbr_title'", AutoScrollableTextView.class);
    target.lnr_player_info = Utils.findRequiredViewAsType(source, R.id.lnr_player_info, "field 'lnr_player_info'", LinearLayout.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    SurahActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.rview_surah = null;
    target.btn_next = null;
    target.btn_pause = null;
    target.btn_play = null;
    target.btn_previous = null;
    target.txt_surah_name = null;
    target.txt_cur_time = null;
    target.txt_total_time = null;
    target.seekbar = null;
    target.img_tlbr_back = null;
    target.txt_tlbr_title = null;
    target.lnr_player_info = null;
  }
}
