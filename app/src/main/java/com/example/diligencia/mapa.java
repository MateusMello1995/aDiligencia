package com.example.diligencia;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentActivity;

import android.Manifest;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;

public class mapa extends AppCompatActivity implements OnMapReadyCallback {

    private DrawerLayout drawer;
    private GoogleMap mMap;

    //declara variaveis para permissão location
    private static final String[] LOCATION_PERMS={

            Manifest.permission.ACCESS_FINE_LOCATION
    };
    private static final int INITIAL_REQUEST=1337;
    private static final int LOCATION_REQUEST=INITIAL_REQUEST+3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mapa);
        // Obtenha o SupportMapFragment e seja notificado quando o mapa estiver pronto para ser usado.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        //adicionar menu drawer
        drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, myToolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
    }

    @Override
    public void onBackPressed() {

        if(drawer.isDrawerOpen(GravityCompat.START)){

            drawer.closeDrawer(GravityCompat.START);

        }else {
            super.onBackPressed();
        }
    }



    @Override
    public void onMapReady(GoogleMap googleMap) {

        mMap = googleMap;

        // Adicione um marcador em "casa" e mova a câmera
        LatLng casa = new LatLng(-29.756316, -51.092518);
        mMap.addMarker(new MarkerOptions().position(casa).title("Casa").icon(BitmapDescriptorFactory.fromResource(R.drawable.casa)));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(casa));

        LatLng shopping = new LatLng(-29.769068, -51.145938);
        mMap.addMarker(new MarkerOptions().position(shopping).title("shopping").icon(BitmapDescriptorFactory.fromResource(R.drawable.loja)));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(shopping));

        //setar o zoom no mapa
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(casa, 12.0f));
        //mostra controles de zoom
        mMap.getUiSettings().setZoomControlsEnabled(true);

        //verifica se é permitido ao aplicativo pegar a localização atual do dispositivo
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED){

            mMap.setMyLocationEnabled(true);
        }else {

            //caso ainda não tenha sido dada a permissão, solicitar a permissão
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){

                requestPermissions(LOCATION_PERMS, LOCATION_REQUEST);
            }
        }

        //adiciona linha reta entre dois pontos
        mMap.addPolyline(new PolylineOptions().add(casa, shopping).width(5).color(Color.RED));

        //adiciona circulo em torno do marcador
        mMap.addCircle(new CircleOptions().center(casa).radius(1000.0).strokeWidth(3f).strokeColor(Color.BLUE).fillColor(Color.argb(50, 150, 50, 50)));

        //setar bussola no mapa
        mMap.getUiSettings().setMyLocationButtonEnabled(true);
        mMap.getUiSettings().setCompassEnabled(true);

        //setar botão de localização no mapa
        mMap.getUiSettings().setMyLocationButtonEnabled(true);
        mMap.getUiSettings().setMyLocationButtonEnabled(true);



    }



}
