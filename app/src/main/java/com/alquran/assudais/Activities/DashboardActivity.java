package com.alquran.assudais.Activities;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.alquran.assudais.R;
import com.alquran.assudais.Utilities.AutoScrollableTextView;
import com.alquran.assudais.Utilities.CommonUtilities;
import com.alquran.assudais.Utilities.MyApplication;
import com.hassanjamil.hqibla.CompassActivity;
import com.orhanobut.dialogplus.DialogPlus;
import com.orhanobut.dialogplus.ViewHolder;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DashboardActivity extends AppCompatActivity {
    @BindView(R.id.lnr_listen_quran)
    LinearLayout lnr_listen_quran;
    @BindView(R.id.lnr_other_apps)
    LinearLayout lnr_other_apps;
    @BindView(R.id.lnr_whatsnew)
    LinearLayout lnr_whatsnew;
    @BindView(R.id.lnr_donation)
    LinearLayout lnr_donation;
    @BindView(R.id.lnr_qibla_direction)
    LinearLayout lnr_qibla_direction;
    @BindView(R.id.img_app_info)
    ImageView img_app_info;
    @BindView(R.id.img_share)
    ImageView img_share;
    @BindView(R.id.img_dev_info)
    ImageView img_dev_info;
    @BindView(R.id.img_dua)
    ImageView img_dua;
    @BindView(R.id.cbox_sound)
    CheckBox cbox_sound;


    boolean doubleBackToExitPressedOnce = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        ButterKnife.bind(this);

        if (MyApplication.isSALAAMSOUND()) {
            cbox_sound.setChecked(true);
        } else {
            cbox_sound.setChecked(false);
        }


        lnr_listen_quran.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DashboardActivity.this, SurahActivity.class);
                startActivity(intent);
            }
        });

        lnr_other_apps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DashboardActivity.this, SimilarAppsListActivity.class);
                startActivity(intent);
            }
        });

        lnr_whatsnew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                whatsnewDialog();
            }
        });
        lnr_donation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DashboardActivity.this, DonationActivity.class);
                startActivity(intent);
            }
        });

        img_share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    CommonUtilities.shareAddress(getResources().getText(R.string.app_url), DashboardActivity.this);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        img_app_info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                appInfoDialog();
            }
        });
        img_dua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                duaDialog();
            }
        });
        img_dev_info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                devInfoDialog();
            }
        });

        cbox_sound.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                MyApplication.setSALAAMSOUND(isChecked);
            }
        });

        lnr_qibla_direction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (CommonUtilities.checkPermissions(DashboardActivity.this)) {
                    Intent intent = new Intent(DashboardActivity.this, CompassActivity.class);
/*
                intent.putExtra(Constants.TOOLBAR_TITLE, getResources().getText(R.string.app_name));		// Toolbar Title
                intent.putExtra(Constants.TOOLBAR_BG_COLOR,  getResources().getColor(R.color.colorPrimaryDark));		// Toolbar Background color
                intent.putExtra(Constants.TOOLBAR_TITLE_COLOR,  getResources().getColor(R.color.white));	// Toolbar Title color
                intent.putExtra(Constants.COMPASS_BG_COLOR,  getResources().getColor(R.color.colorPrimaryDark));		// Compass background color
                intent.putExtra(Constants.ANGLE_TEXT_COLOR,  getResources().getColor(R.color.white));		// Angle Text color
                intent.putExtra(Constants.DRAWABLE_DIAL, R.drawable.dial);	// Your dial drawable resource
                intent.putExtra(Constants.DRAWABLE_QIBLA, R.drawable.qibla); 	// Your qibla indicator drawable resource
                intent.putExtra(Constants.FOOTER_IMAGE_VISIBLE, View.VISIBLE*/
                    /*|View.INVISIBLE|View.GONE*//*
);	// Footer World Image visibility
                intent.putExtra(Constants.LOCATION_TEXT_VISIBLE, View.VISIBLE*/
                    /*|View.INVISIBLE|View.GONE*//*
); // Location Text visibility
*/
                    startActivity(intent);
                } else
                    CommonUtilities.getPermissions(DashboardActivity.this, DashboardActivity.this);
            }
        });

    }

    private void whatsnewDialog() {
        ViewHolder viewHolder = new ViewHolder(R.layout.dialog_whatsnew);
        final DialogPlus dialog = DialogPlus.newDialog(DashboardActivity.this)
                .setContentHolder(viewHolder)
                .setGravity(Gravity.CENTER)
                .setCancelable(true)
                .setInAnimation(R.anim.fade_in_center)
                .setOutAnimation(R.anim.fade_out_center)
                .setContentWidth(ViewGroup.LayoutParams.MATCH_PARENT)
                .setContentHeight(ViewGroup.LayoutParams.WRAP_CONTENT)
                .create();

//                Initializing Widgets
        View view = dialog.getHolderView();

        Button btn_close = view.findViewById(R.id.btn_close);

        btn_close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
//                Displaying DialogPlus
        dialog.show();
    }

    private void duaDialog() {
        ViewHolder viewHolder = new ViewHolder(R.layout.dialog_dua);
        final DialogPlus dialog = DialogPlus.newDialog(DashboardActivity.this)
                .setContentHolder(viewHolder)
                .setGravity(Gravity.BOTTOM)
                .setCancelable(false)
                .setInAnimation(R.anim.slide_in_bottom)
                .setOutAnimation(R.anim.slide_out_bottom)
                .setContentWidth(ViewGroup.LayoutParams.MATCH_PARENT)
                .setContentHeight(ViewGroup.LayoutParams.WRAP_CONTENT)
                .create();

//                Initializing Widgets
        View view = dialog.getHolderView();

        Button btn_close = view.findViewById(R.id.btn_close);

        btn_close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
//                Displaying DialogPlus
        dialog.show();
    }

    private void appInfoDialog() {
        ViewHolder viewHolder = new ViewHolder(R.layout.dialog_app_info);
        final DialogPlus dialog = DialogPlus.newDialog(DashboardActivity.this)
                .setContentHolder(viewHolder)
                .setGravity(Gravity.BOTTOM)
                .setCancelable(false)
                .setInAnimation(R.anim.slide_in_bottom)
                .setOutAnimation(R.anim.slide_out_bottom)
                .setContentWidth(ViewGroup.LayoutParams.MATCH_PARENT)
                .setContentHeight(ViewGroup.LayoutParams.WRAP_CONTENT)
                .create();

//                Initializing Widgets
        View view = dialog.getHolderView();

        Button btn_close = view.findViewById(R.id.btn_close);
        TextView txt_privacy_policy = view.findViewById(R.id.txt_privacy_policy);
        TextView txt_website = view.findViewById(R.id.txt_website);


        btn_close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        txt_privacy_policy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    if (CommonUtilities.isConnectionAvailable(DashboardActivity.this)) {
                        Intent intent = new Intent(Intent.ACTION_VIEW);
                        intent.setData(Uri.parse(getResources().getString(R.string.my_privacy_policy)));
                        startActivity(intent);
                    } else {
                        CommonUtilities.ShowToastMessage(DashboardActivity.this, getResources().getString(R.string.internetconnection));
                    }
                } catch (Exception e) {
                    Toast.makeText(DashboardActivity.this, getResources().getString(R.string.pls_try_again), Toast.LENGTH_LONG).show();
                    e.printStackTrace();
                }
            }
        });
        txt_website.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    if (CommonUtilities.isConnectionAvailable(DashboardActivity.this)) {
                        Intent intent = new Intent(Intent.ACTION_VIEW);
                        intent.setData(Uri.parse(getResources().getString(R.string.my_website)));
                        startActivity(intent);
                    } else {
                        CommonUtilities.ShowToastMessage(DashboardActivity.this, getResources().getString(R.string.internetconnection));
                    }
                } catch (Exception e) {
                    Toast.makeText(DashboardActivity.this, getResources().getString(R.string.pls_try_again), Toast.LENGTH_LONG).show();
                    e.printStackTrace();
                }
            }
        });
//                Displaying DialogPlus
        dialog.show();

    }

    private void devInfoDialog() {
        ViewHolder viewHolder = new ViewHolder(R.layout.dialog_dev_info);
        final DialogPlus dialog = DialogPlus.newDialog(DashboardActivity.this)
                .setContentHolder(viewHolder)
                .setGravity(Gravity.BOTTOM)
                .setCancelable(false)
                .setInAnimation(R.anim.slide_in_bottom)
                .setOutAnimation(R.anim.slide_out_bottom)
                .setContentWidth(ViewGroup.LayoutParams.MATCH_PARENT)
                .setContentHeight(ViewGroup.LayoutParams.WRAP_CONTENT)
                .create();

//                Initializing Widgets
        View view = dialog.getHolderView();

        Button btn_close = view.findViewById(R.id.btn_close);
        AutoScrollableTextView atxt_send_mail = view.findViewById(R.id.atxt_send_mail);
        ImageView img_call_dev = view.findViewById(R.id.img_call_dev);
        ImageView img_msg_dev = view.findViewById(R.id.img_msg_dev);
        ImageView img_wtsap_dev = view.findViewById(R.id.img_wtsap_dev);


        btn_close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        img_call_dev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    CommonUtilities.onCall("+917207579969", DashboardActivity.this);
                } catch (Exception e) {
                    Toast.makeText(DashboardActivity.this, getResources().getString(R.string.pls_try_again), Toast.LENGTH_LONG).show();
                    e.printStackTrace();
                }
            }
        });

        img_msg_dev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Uri uri = Uri.parse("smsto:+917207579969");
                    Intent intent = new Intent(Intent.ACTION_SENDTO, uri);
                    intent.putExtra("sms_body", "ٱلسَّلَامُ عَلَيْكُمْ وَرَحْمَةُ ٱللَّٰهِ وَبَرَكَاتُه");
                    startActivity(intent);
                } catch (Exception e) {
                    Toast.makeText(DashboardActivity.this, getResources().getString(R.string.pls_try_again), Toast.LENGTH_LONG).show();
                    e.printStackTrace();
                }
            }
        });

        img_wtsap_dev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Uri uri = Uri.parse("smsto:" + "+917207579969");
                    Intent sendIntent = new Intent(Intent.ACTION_SENDTO, uri);
                    sendIntent.putExtra(Intent.EXTRA_TEXT/*"sms_body"*/, "ٱلسَّلَامُ عَلَيْكُمْ وَرَحْمَةُ ٱللَّٰهِ وَبَرَكَاتُهُ");
                    sendIntent.setPackage("com.whatsapp");
                    if (sendIntent.resolveActivity(getPackageManager()) != null) {
                        startActivity(sendIntent);
                    } else {
                        Toast.makeText(DashboardActivity.this, "Please install Whatsapp", Toast.LENGTH_LONG).show();
                    }
                } catch (Exception e) {
                    Toast.makeText(DashboardActivity.this, getResources().getString(R.string.pls_try_again), Toast.LENGTH_LONG).show();
                    e.printStackTrace();
                }
            }
        });

        atxt_send_mail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    String email = "saudagar.sulaiman@gmail.com";
                    Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri.parse("mailto:" + email));
                    emailIntent.putExtra(Intent.EXTRA_SUBJECT, "AlQuran App Feedback");
                    emailIntent.putExtra(Intent.EXTRA_TEXT, "ٱلسَّلَامُ عَلَيْكُمْ وَرَحْمَةُ ٱللَّٰهِ وَبَرَكَاتُه");
                    startActivity(Intent.createChooser(emailIntent, "Choose Title"));
                } catch (Exception e) {
                    Toast.makeText(DashboardActivity.this, getResources().getString(R.string.pls_try_again), Toast.LENGTH_LONG).show();
                    e.printStackTrace();
                }
            }
        });
//                Displaying DialogPlus
        dialog.show();
    }

    @Override
    public void onBackPressed() {
        if (doubleBackToExitPressedOnce) {
            super.onBackPressed();
            return;
        }
        this.doubleBackToExitPressedOnce = true;
        Toast.makeText(this, "Please click BACK again to exit", Toast.LENGTH_SHORT).show();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                doubleBackToExitPressedOnce = false;
            }
        }, 2000);
    }

}
