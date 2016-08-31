#Push-Up android SDK Guide

##Step 1 : Interworking adPush_for_china_0.0.7.jar

### Add the adPush_for_china_0.0.7.jar to Libs folder of the project.
  
    Copy the file adPush_for_china_0.0.7.jar to the Libs folder of the project.

 
 
### Add the Manifest of the project as follows:
 
    Android.permission.INTERNET : Add the permission of using internet.
    Add the receiver and activity.
```
<uses-permission android:name="android.permission.INTERNET"/>
 ....
<receiver android:name="co.kr.wcorp.pull.AdReceive" ></receiver>
<activity android:name="co.kr.wcorp.pull.AdWebViewActivity" android:launchMode="singleTask" android:theme="@android:style/Theme.NoTitleBar"/>
```

 
##Step 2 : Information & settings for Ad request
```java

import co.kr.wcorp.pull.AdSDK;  // Library IMPORT (Put ‘adPush.jar’ released in Libs folder of the project.)
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;

public class SampleActivity extends Activity {
	
	/* adPush SDK Start setup */
	AdSDK adSdk; //Declaring and Assigning AdSDK
	Context context = this; 
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		/* adPush SDK Start setup*/
		adSdk = new AdSDK(this);
		adStart();
	}
			
		
	/* Setting AdSDK and calling a function on notification */
	public void adStart() {
	        adSdk.setDevType(true);  // Setting up a test server, Mandatory
		adSdk.setUniqueAppId("Input the name of media app"); // Name of media app, Mandatory
		adSdk.setAdSlotID("Input the given slot number"); // Media’s ID, Mandatory
		adSdk.setInvalidHour(1);// Set the time for excluding any notification, Optional
		adSdk.setUserIcon(co.test.R.drawable.ic_launcher); // Media Icon,Mandatory	
		adSdk.adStart();
	}
	
	@Override
	public void onDestroy() { 
	    super.onDestroy();
	    adSdk.adStop(); // Complete of notification	
}
	
	@Override
    public void onBackPressed() {
		adSdk.adStop(); // Complete of notification
		finish();
	}
}
```

####Source Description

 setDevType() : Specify the development server and managed server (Compulsory, true : development, false : managed), Boolean
 
 setUniqueAppId(): Specify the name of media app (Compulsory), String
 
 setAdSlotID() : Specify the slot number (Compulsory), String
 
 setInvalidHour() : Set the time for excluding any notification (Option), Int
 
 setUserIcon() : Specify the icon of media app (Compulsory), Int. The default Ad calling period is based on 1-hour.
 
 adStop() : Ad closes when user's application closed. adSdk.adStop() is used to force quit. Ad fails to play after this function is used.
