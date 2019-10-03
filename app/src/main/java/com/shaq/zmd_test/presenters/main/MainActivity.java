package com.shaq.zmd_test.presenters.main;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;


import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;


import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.shaq.zmd_test.R;
import com.shaq.zmd_test.presenters.cats.CatsFragment;
import com.shaq.zmd_test.presenters.dogs.DogsFragment;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView mBottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initTabs();

    }

    private void initTabs() {
        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottom_navigation);
        if (bottomNavigationView != null) {

            Menu menu = bottomNavigationView.getMenu();
            selectFragment(menu.getItem(0));

            bottomNavigationView.setOnNavigationItemSelectedListener(
                    new BottomNavigationView.OnNavigationItemSelectedListener() {
                        @Override
                        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                            selectFragment(item);
                            return false;
                        }
                    });
        }
    }

    protected void selectFragment(MenuItem item) {

        item.setChecked(true);

        switch (item.getItemId()) {
            case R.id.nav_menu_cats:
                pushFragment(new CatsFragment());
                break;
            case R.id.nav_menu_dogs:
                pushFragment(new DogsFragment());
                break;
        }
    }

    protected void pushFragment(Fragment fragment) {
        if (fragment == null)
            return;

        FragmentManager fragmentManager = getSupportFragmentManager();
        if (fragmentManager != null) {
            FragmentTransaction ft = fragmentManager.beginTransaction();
            if (ft != null) {
                ft.replace(R.id.root_layout, fragment);
                ft.commit();
            }
        }
    }

}
