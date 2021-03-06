package com.smartindia.hackathon.biotechnology.home;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.smartindia.hackathon.biotechnology.InstituteFeedBackForm.View.Feedback_Fragment;
import com.smartindia.hackathon.biotechnology.Internship.view.InternshipFragment;
import com.smartindia.hackathon.biotechnology.*;
import com.smartindia.hackathon.biotechnology.MyProfile.view.MyProfileUpload;
import com.smartindia.hackathon.biotechnology.ResearchPaper.View.ResearchPaperFrag;
import com.smartindia.hackathon.biotechnology.SurveyFilling.View.SurveyFragment;
import com.smartindia.hackathon.biotechnology.SurveyUpload.View.Survey_Upload;
import com.smartindia.hackathon.biotechnology.applyInternship.View.GetInternshipFragment;
import com.smartindia.hackathon.biotechnology.helper.SharedPrefs;
import com.smartindia.hackathon.biotechnology.productDesc.view.ProductFragment;
import com.smartindia.hackathon.biotechnology.professor.view.ProfessorFragment;
import com.smartindia.hackathon.biotechnology.request.view.RequestFragment;
import com.smartindia.hackathon.biotechnology.setInternship.view.SetInternshipFragment;


public class Home_page extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener ,
        HomeFragment.OnFragmentInteraction,GetInternshipFragment.OnFragmentInteraction{

private SharedPrefs sharedPrefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//sharedPrefs=new SharedPrefs(this);
  //    if(sharedPrefs.getKeyType().equals("0"))



        //if(user)//isse karna bakki hai

        setContentView(R.layout.activity_home_page);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        sharedPrefs=new SharedPrefs(this);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);


        navigationView.setNavigationItemSelectedListener(this);
        addFragment(new HomeFragment(),"home");

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else if (getSupportFragmentManager().getBackStackEntryCount() > 0){
            super.onBackPressed();
            Toast.makeText(this, "Go back", Toast.LENGTH_SHORT).show();
        }
        else {
            final AlertDialog ad = new AlertDialog.Builder(this)
                    .create();
            ad.setCancelable(false);
            ad.setTitle("Exit ?");
            ad.setMessage("Do you really want to exit ?");
            ad.setButton(DialogInterface.BUTTON_POSITIVE, "yes", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    ad.cancel();
                    finish();
                }
            });
            ad.setButton(DialogInterface.BUTTON_NEGATIVE, "no", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    ad.cancel();

                }
            });
            ad.show();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.home_page, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }



    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.myprofile) {
            Intent welcome = new Intent(Home_page.this, MyProfileUpload.class);
            startActivity(welcome);
            finish();
        }
        else if (id == R.id.incubator) {
            sharedPrefs.setKeyTypeAnalogus("2");
            setFragment(new ProfessorFragment(), "INCUBATORS");

        } else if (id == R.id.equipment) {
            //  setFragment(new ProductFragment(),"product");
            sharedPrefs.setKeyTypeAnalogus("1");
            setFragment(new ProfessorFragment(), "EQUIPMENTS");
        }
        else if (id == R.id.biotechparks) {
            sharedPrefs.setKeyTypeAnalogus("3");
            setFragment(new ProfessorFragment(),"BIOTECH PARKS");
        }
        else if (id == R.id.givesurvey) {
            sharedPrefs.setKeyTypeAnalogus("5");
            setFragment(new ProfessorFragment(),"SURVEY");
        }
        else if (id == R.id.institution) {
            sharedPrefs.setKeyTypeAnalogus("4");
            setFragment(new ProfessorFragment(),"INSTITUTION");
        }
        else if (id == R.id.professor) {
            sharedPrefs.setKeyTypeAnalogus("6");
//            setFragment(new ProfessorFragment(),"PROFESSOR");

        }
        else if (id == R.id.student) {
            sharedPrefs.setKeyTypeAnalogus("6");
//            setFragment(new ProfessorFragment(),"STUDENT");

        }
        else if (id == R.id.takesurvey) {
            Intent welcome = new Intent(Home_page.this, Survey_Upload.class);
            startActivity(welcome);
            }
        else if (id == R.id.setinternship) {
            setFragment(new SetInternshipFragment(),"SET INTERNSHIP");
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
    public void addFragment(Fragment fragment, String title) {
        if (fragment != null) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.home_layout, fragment);
            fragmentTransaction.commit();
            getSupportActionBar().setTitle(title);
        }

    }

    public void setFragment(Fragment fragment, String title) {
        if (fragment != null) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.home_layout, fragment);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
            //     getSupportActionBar().setTitle(title);
        }
    }
    @Override
    public void onHomeFragmentInteraction(Uri uri)
    {

    }

    @Override
    public void onGetInternshipFragmentInteraction(Uri uri) {

    }
}



