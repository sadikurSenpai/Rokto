package com.example.blutspende;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.SimpleDateFormat;
import java.util.Date;

public class PostRequest extends AppCompatActivity {
    private String phone,address,division="",district="",bloodGroup="";
    private EditText contact,add;
    private Spinner divisionSpinner,districtSpinner,bloodGroupSpinner;
    private ArrayAdapter<String> adapterDivision;
    private  ArrayAdapter<String> adapterDistrict;
    private  ArrayAdapter<String> adapterBloodGroup;
    private String[] categoryDivision = {"","Barishal","Chattogram", "Dhaka","Khulna","Mymensingh","Rajshahi","Rangpur", "Sylhet"};

    private String[] categoryDistrictOfDhaka = {"","Dhaka", "Faridpur", "Gazipur",
            "Gopalganj", "Kishoreganj", "Madaripur","Manikganj", "Munshiganj", "Narayanganj"
            , "Narsinghdi", "Rajbari", "Shariatpur", "Tangail"};

    private String[] categoryDistrictOfSylhet = {"","Habiganj", "Moulvibazar", "Sunamganj", "Sylhet"};

    private String[] categoryDistrictOfRangpur = {"","Dinajpur", "Gaibandha", "Kurigram", "Lalmonirhat",
            "Nilphamari", "Panchagar", "Rangpur", "Thakurgaon"};

    private String[] categoryDistrictOfRajshahi={"","Bogura", "Joypurhat", "Naogaon", "Natore",
            "Nawabganj", "Pabna", "Rajshahi", "Sirajganj"};

    private String[] categoryDistrictOfKhulna={"","Bagerhat", "Chuadanga", "Jashore", "Jhenaidah", "Khulna", "Kushtia", "Magura", "Meherpur", "Narail", "Satkhira"};

    private String[] categoryDistrictOfBarishal={"","Barguna", "Barishal", "Bhola", "Jhalakati", "Patuakhali", "Pirojpur"};

    private String[] categoryDistrictOfMymensingh={"","Jamalpur","Mymensingh","Netrokona","Sherpur"};

    private String[] categoryDistrictOfChattogram={"","Bandarban", "Brahmanbaria", "Chandpur", "Chattogram",
            "Cox’s Bazar", "Cumilla", "Feni", "Khagrachhari", "Lakshmipur", "Noakhali", "Rangamati"};
    private String[] categoryBloodGroup = {"","A+","B+","O+","AB+","A-","B-","O-","AB-"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_request);
        contact=findViewById(R.id.postRequestContactNumber);
        add=findViewById(R.id.postRequestAddress);
        divisionSpinner = findViewById(R.id.postRequestDivision);
        districtSpinner = findViewById(R.id.postRequestDistrict);
        bloodGroupSpinner = findViewById(R.id.postRequestBloodGroup);
        adapterDivision = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_spinner_item, categoryDivision);
        adapterDivision.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        divisionSpinner.setAdapter(adapterDivision);

        divisionSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                division = adapterView.getItemAtPosition(i).toString();
                if(division.equals("")){
                    districtSpinner.setEnabled(false);
                }
                if(division.equals("Dhaka")){
                    districtSpinner.setEnabled(true);

                    adapterDistrict = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_spinner_item, categoryDistrictOfDhaka);
                    adapterDistrict.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                }
                if(division.equals("Sylhet")){
                    districtSpinner.setEnabled(true);

                    adapterDistrict = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_spinner_item, categoryDistrictOfSylhet);
                    adapterDistrict.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                }
                if(division.equals("Barishal")){
                    districtSpinner.setEnabled(true);

                    adapterDistrict = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_spinner_item, categoryDistrictOfBarishal);
                    adapterDistrict.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                }if(division.equals("Chattogram")){
                    districtSpinner.setEnabled(true);

                    adapterDistrict = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_spinner_item, categoryDistrictOfChattogram);
                    adapterDistrict.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                }if(division.equals("Khulna")){
                    districtSpinner.setEnabled(true);

                    adapterDistrict = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_spinner_item, categoryDistrictOfKhulna);
                    adapterDistrict.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                }if(division.equals("Mymensingh")){
                    districtSpinner.setEnabled(true);

                    adapterDistrict = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_spinner_item, categoryDistrictOfMymensingh);
                    adapterDistrict.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                }if(division.equals("Rajshahi")){
                    districtSpinner.setEnabled(true);

                    adapterDistrict = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_spinner_item, categoryDistrictOfRajshahi);
                    adapterDistrict.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                }if(division.equals("Rangpur")){
                    districtSpinner.setEnabled(true);

                    adapterDistrict = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_spinner_item, categoryDistrictOfRangpur);
                    adapterDistrict.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                }

                districtSpinner.setAdapter(adapterDistrict);

                districtSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                        district = adapterView.getItemAtPosition(i).toString();
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> adapterView) {

                    }
                });
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        adapterBloodGroup = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_spinner_item, categoryBloodGroup);
        adapterBloodGroup.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        bloodGroupSpinner.setAdapter(adapterBloodGroup);

        bloodGroupSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                bloodGroup = adapterView.getItemAtPosition(i).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    public void PostRequest(View view) {
        phone=contact.getText().toString();
        address=add.getText().toString();
        if(division.isEmpty() || district.isEmpty() || bloodGroup.isEmpty() || phone.isEmpty()|| address.isEmpty())
        {
            Toast.makeText(this, "Please enter every information", Toast.LENGTH_SHORT).show();
            return;
        }
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = new Date();
        System.out.println(formatter.format(date));
        DatabaseReference databaseReference= FirebaseDatabase.getInstance().getReference();
        databaseReference.child("PostRequests").child(division).child(SplashScreen.trimmedMail)
                .setValue(new ModelPostRequest(SplashScreen.name,phone,bloodGroup,address+","+district+","+division,formatter.format(date)+"") );
        databaseReference.child("PostRequests").child("default").child(SplashScreen.trimmedMail)
                .setValue(new ModelPostRequest(SplashScreen.name,phone,bloodGroup,address+","+district+","+division,formatter.format(date)+"") );
        startActivity(new Intent(PostRequest.this,SplashScreen.class) );
    }
}