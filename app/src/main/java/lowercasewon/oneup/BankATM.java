package lowercasewon.oneup;

import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.reimaginebanking.api.nessieandroidsdk.NessieError;
import com.reimaginebanking.api.nessieandroidsdk.NessieResultsListener;
import com.reimaginebanking.api.nessieandroidsdk.models.ATM;
import com.reimaginebanking.api.nessieandroidsdk.models.PaginatedResponse;
import com.reimaginebanking.api.nessieandroidsdk.requestclients.NessieClient;

import static java.lang.reflect.Modifier.FINAL;

public class BankATM extends FragmentActivity implements OnMapReadyCallback {
    public NessieClient client = NessieClient.getInstance("88d32ed949123a777cc5763009fbe502");
    private GoogleMap mMap;
    Location location;
    float latitude; // Latitude
    float longitude; // Longitude

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bank_atm);
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
    public void onMapReady(final GoogleMap googleMap) {
        LocationManager lm = (LocationManager) getSystemService(Context.LOCATION_SERVICE);

        if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        location = lm.getLastKnownLocation(LocationManager.GPS_PROVIDER);
            longitude = (float) location.getLongitude();
            latitude = (float) location.getLatitude();
            client.ATM.getATMs(latitude, longitude, (float) 1000, new NessieResultsListener() {
                @Override
                public void onSuccess(Object result) {
                    PaginatedResponse<ATM> response = (PaginatedResponse<ATM>) result;
                    System.out.println(response.getObjectList());
                    mMap = googleMap;
                    LatLng latlng;
                    // Add a marker in Sydney and move the camera
                    for(int i = 0; i < response.getObjectList().size(); i++) {
                        latlng = new LatLng(response.getObjectList().get(i).getGeocode().getLng(),response.getObjectList().get(i).getGeocode().getLat());

                        mMap.addMarker(new MarkerOptions().position(latlng));
                    }
                    latlng = new LatLng(response.getObjectList().get(0).getGeocode().getLng(),response.getObjectList().get(0).getGeocode().getLat());
                    mMap.moveCamera(CameraUpdateFactory.newLatLng(latlng));
                }

                @Override
                public void onFailure(NessieError error) {
                    System.out.println("u fked up");
                }
            });


    }
}
