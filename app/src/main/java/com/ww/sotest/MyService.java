package com.ww.sotest;

import android.app.Service;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.IBinder;
import android.util.Log;

import androidx.annotation.Nullable;

public class MyService extends Service {
    private static final String AUTHORITY = "com.example.test.provider";
    public static Uri sUri;

    static {
        sUri = Uri.parse("content://" + AUTHORITY + "/f2");
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Intent i = intent;
        i.addFlags(0x01000000);
        Cursor query = getContentResolver().query(sUri, null, null, null, null, null);
        if (query!=null){
            query.moveToNext();
            String s0 = query.getString(0);
            String s1 = query.getString(1);
            Log.e("test","s0"+s0+"    s1"+s1);
        }
        return super.onStartCommand(i, flags, startId);
    }
}
