package com.example.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.squareup.okhttp.Request;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    public TextView mTv;
    public String mXmlData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTv = (TextView) findViewById(R.id.tv);
        mXmlData = "<xml><attach><![CDATA[201611181440125756-ODYxMDU0MDM1MTM1NjQ0KjEwMCozKjM=]]></attach><body><![CDATA[4006115396]]></body><mch_create_ip><![CDATA[127.0.0.1]]></mch_create_ip><mch_id><![CDATA[5202000012]]></mch_id><nonce_str><![CDATA[60bb8062ea8e0c7ff17bb2e484cd223a]]></nonce_str><notify_url><![CDATA[ <out_trade_no><![CDATA[RS03_1479451213000]]></out_trade_no><service><![CDATA[pay.weixin.wappay]]></service><sign><![CDATA[C4431EB7F1A1023C8B88D6BE1E99E59C]]></sign><total_fee><![CDATA[100]]></total_fee></xml>";
        mXmlData = "<xml><appid><![CDATA[wx97ddd9adb38a76f2]]></appid>" +
                "<attach><![CDATA[话费充值]]></attach>" +
                "<bank_type><![CDATA[CFT]]></bank_type>" +
                "<cash_fee><![CDATA[1]]></cash_fee>" +
                "<fee_type><![CDATA[CNY]]></fee_type>" +
                "<is_subscribe><![CDATA[Y]]></is_subscribe>" +
                "<mch_id><![CDATA[1424564502]]></mch_id>" +
                "<nonce_str><![CDATA[sobrjbox6c40tizpahxs6hw1d0r9koc3]]></nonce_str>" +
                "<openid><![CDATA[oY-3Dw75PuRRZVDovZsTm5nGS0l0]]></openid>" +
                "<out_trade_no><![CDATA[201702131813368352]]></out_trade_no>" +
                "<result_code><![CDATA[SUCCESS]]></result_code>" +
                "<return_code><![CDATA[SUCCESS]]></return_code>" +
                "<sign><![CDATA[C83B2B3743110501C9279E6F1671A9D0]]></sign>" +
                "<time_end><![CDATA[20170213181411]]></time_end>" +
                "<total_fee>1</total_fee>" +
                "<trade_type><![CDATA[JSAPI]]></trade_type>" +
                "<transaction_id><![CDATA[4003662001201702139805522696]]></transaction_id>" +
                "</xml>";

    }

    public void parseXML(View view) {
        //getDataFromNet();
        dealData(mXmlData);
    }

    private void getDataFromNet() {
        String url = "http://www.huangmengxia.cn/json/test/?id=1";
        try {
            OkHttpUtils.get().url(url).build().execute(new StringCallback() {
                @Override
                public void onError(Request request, Exception e) {

                }

                @Override
                public void onResponse(String response) {
                    dealData(response);
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void dealData(String data) {
        try {
            String out_trade_no = (String) XmlUtil.UnPackageXml(data).get("sign");
            if (mTv != null) {
                mTv.setText("解析正确"+out_trade_no);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
