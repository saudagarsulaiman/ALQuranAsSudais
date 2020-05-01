// Generated code from Butter Knife. Do not modify!
package com.alquran.assudais.Activities;

import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.alquran.assudais.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class DashboardActivity_ViewBinding implements Unbinder {
  private DashboardActivity target;

  @UiThread
  public DashboardActivity_ViewBinding(DashboardActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public DashboardActivity_ViewBinding(DashboardActivity target, View source) {
    this.target = target;

    target.lnr_listen_quran = Utils.findRequiredViewAsType(source, R.id.lnr_listen_quran, "field 'lnr_listen_quran'", LinearLayout.class);
    target.lnr_other_apps = Utils.findRequiredViewAsType(source, R.id.lnr_other_apps, "field 'lnr_other_apps'", LinearLayout.class);
    target.lnr_whatsnew = Utils.findRequiredViewAsType(source, R.id.lnr_whatsnew, "field 'lnr_whatsnew'", LinearLayout.class);
    target.img_app_info = Utils.findRequiredViewAsType(source, R.id.img_app_info, "field 'img_app_info'", ImageView.class);
    target.img_share = Utils.findRequiredViewAsType(source, R.id.img_share, "field 'img_share'", ImageView.class);
    target.img_dev_info = Utils.findRequiredViewAsType(source, R.id.img_dev_info, "field 'img_dev_info'", ImageView.class);
    target.img_dua = Utils.findRequiredViewAsType(source, R.id.img_dua, "field 'img_dua'", ImageView.class);
    target.cbox_sound = Utils.findRequiredViewAsType(source, R.id.cbox_sound, "field 'cbox_sound'", CheckBox.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    DashboardActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.lnr_listen_quran = null;
    target.lnr_other_apps = null;
    target.lnr_whatsnew = null;
    target.img_app_info = null;
    target.img_share = null;
    target.img_dev_info = null;
    target.img_dua = null;
    target.cbox_sound = null;
  }
}
