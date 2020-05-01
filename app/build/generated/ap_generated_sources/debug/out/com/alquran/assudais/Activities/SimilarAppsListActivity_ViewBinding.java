// Generated code from Butter Knife. Do not modify!
package com.alquran.assudais.Activities;

import android.view.View;
import android.widget.ImageView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.alquran.assudais.R;
import com.alquran.assudais.Utilities.AutoScrollableTextView;
import java.lang.IllegalStateException;
import java.lang.Override;

public class SimilarAppsListActivity_ViewBinding implements Unbinder {
  private SimilarAppsListActivity target;

  @UiThread
  public SimilarAppsListActivity_ViewBinding(SimilarAppsListActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public SimilarAppsListActivity_ViewBinding(SimilarAppsListActivity target, View source) {
    this.target = target;

    target.img_tlbr_back = Utils.findRequiredViewAsType(source, R.id.img_tlbr_back, "field 'img_tlbr_back'", ImageView.class);
    target.rview_similar_apps = Utils.findRequiredViewAsType(source, R.id.rview_similar_apps, "field 'rview_similar_apps'", RecyclerView.class);
    target.txt_tlbr_title = Utils.findRequiredViewAsType(source, R.id.txt_tlbr_title, "field 'txt_tlbr_title'", AutoScrollableTextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    SimilarAppsListActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.img_tlbr_back = null;
    target.rview_similar_apps = null;
    target.txt_tlbr_title = null;
  }
}
