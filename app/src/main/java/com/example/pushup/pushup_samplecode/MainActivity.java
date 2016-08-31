package com.example.pushup.pushup_samplecode;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import co.kr.wcorp.pull.AdSDK;


public class MainActivity extends AppCompatActivity {
    
    AdSDK adSdk;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        adSdk = new AdSDK(this);
		adStart();


    }
    
    public void adStart() {
		adSdk.setDevType(true);   
		adSdk.setUniqueAppId("Media App ID");   
		adSdk.setAdSlotID("Slot ID"); 
		//adSdk.setInvalidHour(13);	      
		adSdk.setUserIcon(co.test.R.drawable.ic_launcher);	 
		adSdk.adStart();
	}
	
	@Override
	public void onDestroy() { 
	    super.onDestroy();
	    adSdk.adStop();	  
	}
	
	@Override
    public void onBackPressed() {
		adSdk.adStop();  
		finish();
	}


    //ettssss
}
