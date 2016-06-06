package com.kevin.summer.wow;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.TextView;

import com.kevin.summer.wow.data.entry.RealmInfo;
import com.kevin.summer.wow.data.remote.BattleAPI;
import com.kevin.summer.wow.data.response.RealmResponse;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.realm.OrderedRealmCollection;
import io.realm.RealmRecyclerViewAdapter;
import io.realm.RealmResults;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;
    @BindView(R.id.drawer_layout)
    DrawerLayout drawer;
    @BindView(R.id.fab)
    FloatingActionButton fab;

    @BindView(R.id.nav_view)
    NavigationView navigationView;

    @OnClick(R.id.fab)
    public void onClick(View view) {
        Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show();
    }

    RealmAdapter adapter;
    io.realm.Realm mRealm;
    RealmResults<RealmInfo> mRealmInfos;
    BattleAPI api;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        navigationView.setNavigationItemSelectedListener(this);

        RecyclerView.LayoutManager layoutManager =
                new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);

        mRealm = io.realm.Realm.getDefaultInstance();
        mRealmInfos = mRealm.where(RealmInfo.class).findAllAsync();

        adapter = new RealmAdapter(this, mRealmInfos,true);
        recyclerView.setAdapter(adapter);

        api = BattleAPI.APIServiceFactory.get();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
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
        } else if (id == R.id.search_bar) {
            loadRealmRemote();
        }

        return super.onOptionsItemSelected(item);
    }

    private void loadRealmRemote() {
        Call<RealmResponse> call = api.getRealms(BattleAPI.APIServiceFactory.defaultMap);
        call.enqueue(new Callback<RealmResponse>() {
            @Override
            public void onResponse(Call<RealmResponse> call, Response<RealmResponse> response) {
                if (response.isSuccessful()) {
                    final List<RealmInfo> list = response.body().getRealmInfos();
                    mRealm.executeTransactionAsync(new io.realm.Realm.Transaction() {
                        @Override
                        public void execute(io.realm.Realm realm) {
                            realm.copyToRealmOrUpdate(list);
                        }
                    });
                }
            }

            @Override
            public void onFailure(Call<RealmResponse> call, Throwable t) {
                Snackbar.make(fab, "请求超时", Snackbar.LENGTH_LONG)
                        .setAction("重试", new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                loadRealmRemote();
                            }
                        }).show();
            }
        });
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private static class RealmAdapter extends RealmRecyclerViewAdapter<RealmInfo, ViewHolder> {
        public RealmAdapter(Context context, OrderedRealmCollection<RealmInfo> data, boolean autoUpdate) {
            super(context, data, autoUpdate);
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new ViewHolder(LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.realm_item, parent, false));
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            RealmInfo realmInfo = getItem(position);
            holder.realmName.setText(realmInfo.getName());
            holder.realmPopul.setText(realmInfo.getPopulation());
            holder.realmState.setText(realmInfo.isStatus()?"在线" : "离线");
        }
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.realm_name)
        TextView realmName;
        @BindView(R.id.realm_popul)
        TextView realmPopul;
        @BindView(R.id.realm_state)
        TextView realmState;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
