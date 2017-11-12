package ambe.com.vn.moki.activities;

/**
 * Created by Truong on 11/11/2017.
 */

import android.app.IntentService;
import android.content.Intent;
import android.support.v4.content.LocalBroadcastManager;
import android.widget.Toast;

import com.google.android.gms.gcm.GoogleCloudMessaging;
import com.google.android.gms.iid.InstanceID;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

import ambe.com.vn.moki.R;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Converter;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RegistrationIntentService extends IntentService{

    public RegistrationIntentService() {
        super("RegistrationIntentService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {

        String deviceId = intent.getStringExtra("DEVICE_ID");
        String deviceName = intent.getStringExtra("DEVICE_NAME");
        String id_user = intent.getStringExtra("ID_USER");

        try {
            InstanceID instanceID = InstanceID.getInstance(this);
            String registrationId = instanceID.getToken(getString(R.string.gcm_defaultSenderId), GoogleCloudMessaging.INSTANCE_ID_SCOPE, null);
            registerDeviceProcess(deviceName,deviceId,registrationId,id_user);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void registerDeviceProcess(String deviceName, String deviceId, String registrationId, String id){

        RequestBody requestBody = new RequestBody();
        requestBody.setDeviceId(deviceId);
        requestBody.setDeviceName(deviceName);
        requestBody.setRegistrationId(registrationId);
        requestBody.setId_user(id);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.1.107:8000/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        RequestInterface request = retrofit.create(RequestInterface.class);
        Call<ResponseBody> call = request.registerDevice(requestBody);
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                ResponseBody responseBody = response.body();
//                Intent intent = new Intent(MainActivity.REGISTRATION_PROCESS);
//                intent.putExtra("result", responseBody.getResult());
//                intent.putExtra("message",responseBody.getMessage());
                //LocalBroadcastManager.getInstance(RegistrationIntentService.this).sendBroadcast(intent);

            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Toast.makeText(getApplicationContext(),t.getMessage(),Toast.LENGTH_SHORT).show();
            }
        });

    }
}
