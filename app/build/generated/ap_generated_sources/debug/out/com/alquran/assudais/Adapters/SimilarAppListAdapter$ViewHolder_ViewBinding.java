// Generated code from Butter Knife. Do not modify!
package com.alquran.assudais.Adapters;

import android.view.View;
import android.widget.ImageView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.alquran.assudais.R;
import com.alquran.assudais.Utilities.AutoScrollableTextView;
import java.lang.IllegalStateException;
import java.lang.Override;

public class SimilarAppListAdapter$ViewHolder_ViewBinding implements Unbinder {
  private SimilarAppListAdapter.ViewHolder target;

  @UiThread
  public SimilarAppListAdapter$ViewHolder_ViewBinding(SimilarAppListAdapter.ViewHolder target,
      View source) {
    this.target = target;

    target.img_app_icon = Utils.findRequiredViewAsType(source, R.id.img_app_icon, "field 'img_app_icon'", ImageView.class);
    target.txt_app_name = Utils.findRequiredViewAsType(source, R.id.txt_app_name, "field 'txt_app_name'", AutoScrollableTextView.class);
    target.txt_install_app = Utils.findRequiredViewAsType(source, R.id.txt_install_app, "field 'txt_install_app'", AutoScrollableTextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    SimilarAppListAdapter.ViewHolder target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.img_app_icon = null;
    target.txt_app_name = null;
    target.txt_install_app = null;
  }
}
