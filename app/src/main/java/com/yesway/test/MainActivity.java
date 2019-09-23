package com.yesway.test;

import android.Manifest;
import android.app.ActivityManager;
import android.app.job.JobScheduler;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Debug;
import android.os.Handler;
import android.os.Messenger;
import android.os.Trace;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;

public class MainActivity extends AppCompatActivity {

  private ImageView mImg;

  @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR2)
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    mImg = findViewById(R.id.img);
    mImg.getLeft();
    mImg.getRight();
    mImg.getBottom();
    int top = mImg.getTop();
    findViewById(R.id.btn).setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        //testLinkList();
        int networkState = NetUtil.getNetworkState(MainActivity.this);
        Log.v("MYTAG","net type:"+networkState);

        String operatorName = NetUtil.getOperatorName(MainActivity.this);
        Log.v("MYTAG","operatorName:"+operatorName);

        boolean netConnected = NetUtil.isNetConnected(MainActivity.this);
        Log.v("MYTAG","netConnected:"+netConnected);
      }
    });

  }

  private void testLinkList() {
    final LinkedList<String> linkedList = new LinkedList<>();
    linkedList.add("a");
    linkedList.add("b");
    linkedList.add("c");
    linkedList.add("d");
    for (int i = 0; i < linkedList.size(); i++) {
      Log.v("MYTAG",linkedList.get(i));
    }

    Handler handler;
    Messenger msg = null;
    //handler.sendMessage()
  }


}
