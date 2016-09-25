package lowercasewon.oneup;

import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.widget.Toast;
import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import android.widget.TextView;

import android.util.Log;
import com.google.android.gms.location.LocationListener;
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

public class BankATM extends FragmentActivity implements LocationListener, OnMapReadyCallback {
    public NessieClient client = NessieClient.getInstance("88d32ed949123a777cc5763009fbe502");
    private GoogleMap mMap;
    // Declaring a Location Manager
    //protected LocationManager locationManager;
    //private final Context mContext = null;
    public BankATM() {
        getLocation();
    }
    public BankATM(Context context) {
        //this.mContext = context;
        getLocation();
    }

    // flag for GPS status
    boolean isGPSEnabled = false;

    // flag for network status
    boolean isNetworkEnabled = false;

    boolean canGetLocation = false;

    Location location; // location
    double latitude; // latitude
    double longitude; // longitude

    // The minimum distance to change Updates in meters
    private static final long MIN_DISTANCE_CHANGE_FOR_UPDATES = 10; // 10 meters

    // The minimum time between updates in milliseconds
    private static final long MIN_TIME_BW_UPDATES = 1000 * 60 * 1; // 1 minute

    // Declaring a Location Manager
    protected LocationManager locationManager;

    @Override
    protected void onCreate(Bundle  savedInstanceState) {



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
    /**
     * Function to get latitude
     * */
    public double getLatitude(){
        if(location != null){
            latitude = location.getLatitude();
        }

        // return latitude
        return latitude;
    }

    /**
     * Function to get longitude
     * */
    public double getLongitude(){
        if(location != null){
            longitude = location.getLongitude();
        }

        // return longitude
        return longitude;
    }
    public void onMapReady(final GoogleMap googleMap) {


        client.ATM.getATMs((float) getLatitude(), (float)getLongitude(), (float) 100000, new NessieResultsListener() {
            @Override
            public void onSuccess(Object result) {
                PaginatedResponse<ATM> response = (PaginatedResponse<ATM>) result;

                System.out.println(response.getObjectList());
                mMap = googleMap;
                LatLng latlng;
                // Add a marker in Sydney and move the camera
                for(int i = 0; i < response.getObjectList().size(); i++) {
                    System.out.print("got through loop \n");
                    latlng = new LatLng(response.getObjectList().get(i).getGeocode().getLng(),response.getObjectList().get(i).getGeocode().getLat());

                    mMap.addMarker(new MarkerOptions().position(latlng));
                }
                //latlng = new LatLng(response.getObjectList().get(0).getGeocode().getLng(),response.getObjectList().get(0).getGeocode().getLat());
                LatLng herelatlng = new LatLng(33.7784630,-84.3988810);
                mMap.addMarker(new MarkerOptions().position(herelatlng));
                mMap.moveCamera(CameraUpdateFactory.newLatLng(herelatlng));
            }

            @Override
            public void onFailure(NessieError error) {
                System.out.println("u fked up");
            }
        });


    }

    @Override
    public void onLocationChanged(Location location) {

    }

    public Location getLocation() {
        return location;
    }
}
