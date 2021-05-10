package com.example.pasajito

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class Rutas : AppCompatActivity(), OnMapReadyCallback {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rutas)

        val mapFragment : SupportMapFragment? =
            supportFragmentManager.findFragmentById(R.id.map) as? SupportMapFragment
        mapFragment?.getMapAsync(this)

    }

    override fun onMapReady(googleMap: GoogleMap?) {
        googleMap ?: return
        with(googleMap) {
            val markerColor= BitmapDescriptorFactory
                .defaultMarker(BitmapDescriptorFactory.HUE_RED)
            moveCamera(CameraUpdateFactory.newLatLngZoom(LatLng(-16.509269, -68.127361),14f))
            addMarker(MarkerOptions().icon(markerColor).title("Parada minibus 335").position(LatLng(-16.509269, -68.127361)))
        }

    }


}