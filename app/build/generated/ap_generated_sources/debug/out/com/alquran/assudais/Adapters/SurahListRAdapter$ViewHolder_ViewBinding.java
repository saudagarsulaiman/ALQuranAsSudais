// Generated code from Butter Knife. Do not modify!
package com.alquran.assudais.Adapters;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.alquran.assudais.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class SurahListRAdapter$ViewHolder_ViewBinding implements Unbinder {
  private SurahListRAdapter.ViewHolder target;

  @UiThread
  public SurahListRAdapter$ViewHolder_ViewBinding(SurahListRAdapter.ViewHolder target,
      View source) {
    this.target = target;

    target.txt_arabicName = Utils.findRequiredViewAsType(source, R.id.txt_arabicName, "field 'txt_arabicName'", TextView.class);
    target.txt_romanName = Utils.findRequiredViewAsType(source, R.id.txt_romanName, "field 'txt_romanName'", TextView.class);
    target.txt_engName = Utils.findRequiredViewAsType(source, R.id.txt_engName, "field 'txt_engName'", TextView.class);
    target.txt_snum = Utils.findRequiredViewAsType(source, R.id.txt_snum, "field 'txt_snum'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    SurahListRAdapter.ViewHolder target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.txt_arabicName = null;
    target.txt_romanName = null;
    target.txt_engName = null;
    target.txt_snum = null;
  }
}
