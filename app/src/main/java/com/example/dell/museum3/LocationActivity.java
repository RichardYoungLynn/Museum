package com.example.dell.museum3;

import android.Manifest;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.baidu.location.BDLocation;
import com.baidu.location.BDLocationListener;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;
import com.baidu.mapapi.SDKInitializer;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.MapStatusUpdate;
import com.baidu.mapapi.map.MapStatusUpdateFactory;
import com.baidu.mapapi.map.MapView;
import com.baidu.mapapi.map.MyLocationData;
import com.baidu.mapapi.model.LatLng;

import java.util.ArrayList;
import java.util.List;

public class LocationActivity extends AppCompatActivity {
    private MapView mapview;
    private BaiduMap baiduMap;
    private LocationClient mLocationClient;
    private TextView tv_show_location;// 显示当前位置信息
    private boolean isFirstLocate=true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 构建 LocationClient 实例
        mLocationClient = new LocationClient(getApplicationContext());
        // 注册一个定位监听器
        mLocationClient.registerLocationListener(new MyLocationListener());
        SDKInitializer.initialize(getApplicationContext());
        setContentView(R.layout.activity_location);
        mapview=(MapView)findViewById(R.id.bmapView);
        baiduMap=mapview.getMap();
        baiduMap.setMyLocationEnabled(true);
        tv_show_location = (TextView) findViewById(R.id.position_text_view);
        // 声明权限，将权限添加到list集合中再一次性申请
        List<String> permissionList = new ArrayList<>();
        if (ActivityCompat.checkSelfPermission(LocationActivity.this,
                Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            permissionList.add(Manifest.permission.ACCESS_FINE_LOCATION);
        }
        if (ActivityCompat.checkSelfPermission(LocationActivity.this,
                Manifest.permission.READ_PHONE_STATE) != PackageManager.PERMISSION_GRANTED) {
            permissionList.add(Manifest.permission.READ_PHONE_STATE);
        }
        if (ActivityCompat.checkSelfPermission(LocationActivity.this,
                Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            permissionList.add(Manifest.permission.WRITE_EXTERNAL_STORAGE);
        }
        if (!permissionList.isEmpty()) {
            String[] permissions = permissionList.toArray(new String[permissionList.size()]);
            ActivityCompat.requestPermissions(LocationActivity.this,permissions,1);
        }else {
            requestLocation();
        }
    }

    private void navigateTo(BDLocation location){
        if (isFirstLocate){
            LatLng ll = new LatLng(location.getLatitude(),location.getLongitude());
            MapStatusUpdate update = MapStatusUpdateFactory.newLatLng(ll);
            baiduMap.animateMapStatus(update);
            update = MapStatusUpdateFactory.zoomTo(16f);
            baiduMap.animateMapStatus(update);
            isFirstLocate = false;
        }
        MyLocationData.Builder locationBuilder=new MyLocationData.Builder();
        locationBuilder.latitude(location.getLatitude());
        locationBuilder.longitude(location.getLongitude());
        MyLocationData locationData=locationBuilder.build();
        baiduMap.setMyLocationData(locationData);
    }
    /**
     * 开始地理位置定位
     */
    private void requestLocation() {
        mLocationClient.start();
        initLocation();
        mLocationClient.start();
    }
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults)
    { switch (requestCode){
        case 1:
            if (grantResults.length > 0 ){
                for (int result : grantResults){
                    if (result != PackageManager.PERMISSION_GRANTED){
                        Toast.makeText(this,"必须同意所有权限才能使用本程序",Toast.LENGTH_LONG).show();
                        finish();
                        return;
                    }
                }
                requestLocation();
            }else {
                Toast.makeText(this,"发生未知错误",Toast.LENGTH_LONG).show();
                finish();
            }
            break;
        default:
            break;
    }

    }

    // 监听器

    public class MyLocationListener implements BDLocationListener {
        @Override

        public void onReceiveLocation(BDLocation bdLocation) {
            if(bdLocation.getLocType()==BDLocation.TypeGpsLocation
                    ||bdLocation.getLocType()==BDLocation.TypeNetWorkLocation){
                navigateTo(bdLocation);
            }
            StringBuilder currentLocation = new StringBuilder();

            currentLocation.append("纬度：").append(bdLocation.getLatitude()).append("\n");

            currentLocation.append("经线：").append(bdLocation.getLongitude()).append("\n");

            currentLocation.append("国家：").append(bdLocation.getCountry()).append("\n");

            currentLocation.append("省：").append(bdLocation.getProvince()).append("\n");

            currentLocation.append("市：").append(bdLocation.getCity()).append("\n");

            currentLocation.append("区：").append(bdLocation.getDistrict()).append("\n");

            currentLocation.append("街道：").append(bdLocation.getStreet()).append("\n");

            currentLocation.append("定位方式：");

            if (bdLocation.getLocType() == BDLocation.TypeGpsLocation) {

                currentLocation.append("GPS");

            } else if (bdLocation.getLocType() == BDLocation.TypeNetWorkLocation) {

                currentLocation.append("网络");

            }

            tv_show_location.setText(currentLocation);

        }


    }

    private void initLocation() {
        // 创建LocationClientOption 对象
        LocationClientOption option = new LocationClientOption();
        option.setScanSpan(5000);  //5秒钟更新下当前位置
        option.setIsNeedAddress(true);
        mLocationClient.setLocOption(option);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mapview.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mapview.onPause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mLocationClient.stop();//停止定位
        mapview.onDestroy();
        baiduMap.setMyLocationEnabled(false);
    }
}

