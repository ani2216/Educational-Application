package com.example.sidebar;


import android.app.AlertDialog;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.ProgressDialog;
import android.app.SearchManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.sidebar.databinding.ActivityMainBinding;
import com.example.sidebar.ui.slideshow.networkcheck;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.jetbrains.annotations.NotNull;


public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;
    private ActivityMainBinding binding;
    FirebaseAuth firebaseAuth;
    DatabaseReference databaseReference;
    FirebaseUser firebaseUser;
    FirebaseDatabase firebaseDatabase;
    ProgressDialog progressDialog;
    FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            NotificationChannel channel = new NotificationChannel("Notification","Notification", NotificationManager.IMPORTANCE_DEFAULT);
            NotificationManager manager = getSystemService(NotificationManager.class);
            manager.createNotificationChannel(channel);
        }

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setNavigationBarColor(getResources().getColor(R.color.lightblack));
        }

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        fab = findViewById(R.id.fab);

//        fab = getFloatingActionButton();
//        if(fab!=null){
//            showFloatingActionButton();
//        }

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent emailIntent = new Intent(Intent.ACTION_SEND);
                emailIntent.setData(Uri.parse("mailto:"));
                emailIntent.setType("text/plain");
                emailIntent.putExtra(Intent.EXTRA_EMAIL,new String[] {"contentguru724@gmail.com"});

                try {
                    startActivity(emailIntent);
                } catch (Exception e){
                    Snackbar snackbar=Snackbar.make(view,"Can't access Email from this device.",Snackbar.LENGTH_LONG);
                    snackbar.show();
                }

            }
        });

        DrawerLayout drawer = binding.drawerLayout;
        NavigationView navigationView = binding.navView;
        View view1 = navigationView.getHeaderView(0);
        TextView textViews = view1.findViewById(R.id.namechange);
        firebaseAuth = FirebaseAuth.getInstance();
        firebaseUser = firebaseAuth.getCurrentUser();
        String id = firebaseUser.getUid();
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference("content").child(id);
        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull @NotNull DataSnapshot snapshot) {
                String value = snapshot.child("name").getValue(String.class);
                String firstName = "";
                if(value.split("\\w+").length>1){
                    firstName = value.substring(0, value.lastIndexOf(' '));
                }
                else{
                    firstName = value;
                }
                textViews.setText(firstName.toUpperCase());

                NotificationCompat.Builder builder = new NotificationCompat.Builder(MainActivity.this,"Notification");
                builder.setContentTitle("Content Guru");
                builder.setContentText("Hello "+firstName.toUpperCase()+", happy to see you.If you are enjoying our app then please give feedback.");
                builder.setSmallIcon(R.drawable.logocg);
                builder.setAutoCancel(true);

                NotificationManagerCompat managerCompat = NotificationManagerCompat.from(MainActivity.this);
                managerCompat.notify(1,builder.build());
            }

            @Override
            public void onCancelled(@NonNull @NotNull DatabaseError error) {

            }
        });
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.home, R.id.changePassword,R.id.texttodetect,R.id.Song,R.id.ChangeProfile,
                R.id.news,R.id.application,R.id.CustomerService,R.id.FAQ,R.id.Setting,
                R.id.groupchat,R.id.chatbot)
                .setDrawerLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        SearchManager searchManager =
                (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        SearchView searchView = (SearchView) menu.findItem(R.id.search).getActionView();
        searchView.setSearchableInfo(
                searchManager.getSearchableInfo(getComponentName()));
        searchView.setQueryHint("Type here to search");

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                String url = "https://www.google.com/search?q="+query;
                Intent intent = new Intent(MainActivity.this,search.class);
                intent.putExtra("SearchKey",url);
                startActivity(intent);
                query = "";
                return true;
            }
            @Override
            public boolean onQueryTextChange(String newText) {

                return false;
            }
        });
        return true;
    }

    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if(id == R.id.ShareApp){
            Intent intent = new Intent(Intent.ACTION_SEND);
            intent.setType("text/plain");
            String s = "www.google.com";
            intent.putExtra(Intent.EXTRA_TEXT,s);
            startActivity(Intent.createChooser(intent,"share via"));
        }


        if(id == R.id.Logout){
            press();
        }
        return false;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }

    public void press(){
        firebaseAuth = FirebaseAuth.getInstance();
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Want to LogOut?").setCancelable(false).setPositiveButton("Yes"
                , new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        progressDialog = new ProgressDialog(MainActivity.this);
                        progressDialog.show();
                        progressDialog.setContentView(R.layout.progress);
                        progressDialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
                        firebaseAuth.signOut();
                        Intent intent = new Intent(MainActivity.this,login.class);
                        startActivity(intent);
                        finish();
                    }
                }).setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        AlertDialog alertDialog = builder.create();
        alertDialog.show();

    }

    public FloatingActionButton getFloatingActionButton() {
        return fab;
    }

    public void hideFloatingActionButton() {
        fab.hide();
    }

    public void showFloatingActionButton(){
        fab.show();
    }

    networkcheck networkcheck = new networkcheck();
    @Override
    protected void onStart() {
        IntentFilter intentFilter = new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION);
        registerReceiver(networkcheck,intentFilter);
        super.onStart();
    }

    @Override
    protected void onStop() {
        unregisterReceiver(networkcheck);
        super.onStop();
    }
}