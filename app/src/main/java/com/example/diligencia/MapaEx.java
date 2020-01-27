package com.example.diligencia;


import androidx.fragment.app.FragmentActivity;

import android.graphics.Color;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;

public class MapaEx extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mapa_ex);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);


    }

   /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // marcadores para as cidades
        LatLng caxias = new LatLng(-29.156865, -51.176011);
        mMap.addMarker(new MarkerOptions().position(caxias).title("Caxias do Sul").icon(BitmapDescriptorFactory.fromResource(R.drawable.uva)));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(caxias));

        LatLng gramado = new LatLng(-29.332853, -50.878446);
        mMap.addMarker(new MarkerOptions().position(gramado).title("Gramado").icon(BitmapDescriptorFactory.fromResource(R.drawable.chocolate)));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(gramado));

        LatLng porto = new LatLng(-30.034658, -51.219049);
        mMap.addMarker(new MarkerOptions().position(porto).title("Porto Alegre").icon(BitmapDescriptorFactory.fromResource(R.drawable.town)));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(porto));

        LatLng torres = new LatLng(-29.332143, -49.728341);
        mMap.addMarker(new MarkerOptions().position(torres).title("Torres").icon(BitmapDescriptorFactory.fromResource(R.drawable.beach)));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(torres));

        LatLng marcador = new LatLng(-29.652906, -50.565089);

        //setar zoom e controles do zoom
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(caxias,7.0f));
        mMap.getUiSettings().setZoomControlsEnabled(true);

        //adicionar polyline
        mMap.addPolyline(new PolylineOptions().add(caxias, gramado, torres, porto, caxias).width(5).color(Color.RED));

        //adicionar circulo
        mMap.addCircle(new CircleOptions().center(marcador).radius(90000.0).strokeWidth(3f).strokeColor(Color.BLUE).fillColor(Color.argb(50, 150, 50, 50)));

        //bussola
        mMap.getUiSettings().setMyLocationButtonEnabled(true);
        mMap.getUiSettings().setCompassEnabled(true);
    }
}
