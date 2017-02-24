package com.example.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    public String mXmlData;
    public TextView mTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTv = (TextView) findViewById(R.id.tv);
        mXmlData = "<xml><attach><![CDATA[201611181440125756-ODYxMDU0MDM1MTM1NjQ0KjEwMCozKjM=]]></attach><body><![CDATA[4006115396]]></body><mch_create_ip><![CDATA[127.0.0.1]]></mch_create_ip><mch_id><![CDATA[5202000012]]></mch_id><nonce_str><![CDATA[60bb8062ea8e0c7ff17bb2e484cd223a]]></nonce_str><notify_url><![CDATA[ <out_trade_no><![CDATA[RS03_1479451213000]]></out_trade_no><service><![CDATA[pay.weixin.wappay]]></service><sign><![CDATA[C4431EB7F1A1023C8B88D6BE1E99E59C]]></sign><total_fee><![CDATA[100]]></total_fee></xml>";
        if (mTv != null) {
            mTv.setText(mXmlData);
        }

    }

    public void parseXML(View view) {
        Log.e("qw", "MainActivity.parseXML.");

        dealData(mXmlData);


    }

    private void dealData(String data) {
        try {
            Log.e("qw", "MainActivity.dealData.= " + data);
            String out_trade_no = (String) XmlUtil.UnPackageXml(data).get("out_trade_no");
            Log.e("qw", "MainActivity.dealData.out_trade_no= " + out_trade_no);
            if (mTv != null) {
                mTv.setText(out_trade_no);
            }
        } catch (Exception e) {
            Log.e("qw", "MainActivity.dealData.exception= " + e.getMessage());
            e.printStackTrace();
        }
    }
}
