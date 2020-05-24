package com.alquran.assudais.Activities;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.alquran.assudais.R;
import com.alquran.assudais.Utilities.AutoScrollableTextView;
import com.alquran.assudais.Utilities.CommonUtilities;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DonationActivity extends AppCompatActivity {

    @BindView(R.id.img_tlbr_back)
    ImageView img_tlbr_back;
    @BindView(R.id.txt_tlbr_title)
    AutoScrollableTextView txt_tlbr_title;
    @BindView(R.id.img_bank_dropdown)
    ImageView img_bank_dropdown;
    @BindView(R.id.lnr_bank_dropdown)
    LinearLayout lnr_bank_dropdown;
    @BindView(R.id.rltv_bank_dropdown)
    RelativeLayout rltv_bank_dropdown;

    boolean isBankDetailsVisible = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donation);
        ButterKnife.bind(this);

        txt_tlbr_title.setText(getResources().getString(R.string.sadkha_names));
        img_tlbr_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        rltv_bank_dropdown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    if (CommonUtilities.isConnectionAvailable(DonationActivity.this)) {
                        Intent intent = new Intent(Intent.ACTION_VIEW);
                        intent.setData(Uri.parse(getResources().getString(R.string.my_donation_website)));
                        startActivity(intent);
                    } else {
                        CommonUtilities.ShowToastMessage(DonationActivity.this, getResources().getString(R.string.internetconnection));
                    }
                } catch (Exception e) {
                    Toast.makeText(DonationActivity.this, getResources().getString(R.string.pls_try_again), Toast.LENGTH_LONG).show();
                    e.printStackTrace();
                }            }
        });

    }
}
