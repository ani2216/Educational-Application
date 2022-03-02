package com.example.sidebar.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SimpleItemAnimator;

import com.example.jean.jcplayer.JcPlayerManagerListener;
import com.example.jean.jcplayer.general.JcStatus;
import com.example.jean.jcplayer.general.errors.OnInvalidPathListener;
import com.example.jean.jcplayer.model.JcAudio;
import com.example.jean.jcplayer.view.JcPlayerView;
import com.example.sidebar.MainActivity;
import com.example.sidebar.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

import Adapter.AudioAdapter;

public class muscify extends Fragment implements OnInvalidPathListener, JcPlayerManagerListener {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public muscify() {

    }

    public static muscify newInstance(String param1, String param2) {
        muscify fragment = new muscify();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    private static final String TAG = muscify.class.getSimpleName();

    private JcPlayerView player;
    private RecyclerView recyclerView;
    private AudioAdapter audioAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_muscify, container, false);
        recyclerView = view.findViewById(R.id.recyclerView);
        player = view.findViewById(R.id.jcplayer);

        final FloatingActionButton fab = ((MainActivity) getActivity()).getFloatingActionButton();

        if (fab != null) {
            ((MainActivity) getActivity()).hideFloatingActionButton();
        }

        ArrayList< JcAudio > jcAudios = new ArrayList<>();
        jcAudios.add(JcAudio.createFromURL("Bonenkai","https://firebasestorage.googleapis.com/v0/b/content-guru-8d6fd.appspot.com/o/%5BMP3DOWNLOAD.TO%5D%20L'Arc_en_Ciel%20-%20Jojoushi%20(%E5%8F%99%E6%83%85%E8%A9%A9)%20Cover%20by%20naminasae%20at%20Bonenkai%20Festival-64k.mp3?alt=media&token=e2f1661a-977b-4930-a434-af7581dfe5ed"));
        jcAudios.add(JcAudio.createFromURL("Eternal Youth","https://firebasestorage.googleapis.com/v0/b/content-guru-8d6fd.appspot.com/o/%5BMP3DOWNLOAD.TO%5D%20Eternal%20Youth-128k.mp3?alt=media&token=277bf1eb-165b-4f5c-b09c-2faa8e3c7d26"));
        jcAudios.add(JcAudio.createFromURL("Chorr doonga(Sooryavanshi)", "https://firebasestorage.googleapis.com/v0/b/content-guru-8d6fd.appspot.com/o/Duniya%20Chhor%20Doon%20Darshan%20Raval%20128%20Kbps.mp3?alt=media&token=73e8e835-b6d3-40d4-a147-a834a1ac2f62"));
        jcAudios.add(JcAudio.createFromURL("Meri Zindagi hai(Satyamev Jayate-2))", "https://firebasestorage.googleapis.com/v0/b/content-guru-8d6fd.appspot.com/o/Meri%20Zindagi%20Hai%20Tu%20Satyameva%20Jayate%202%20128%20Kbps.mp3?alt=media&token=fda3a1b7-d359-4290-8791-2a63349dc50a"));
        jcAudios.add(JcAudio.createFromURL("Naaja(Sooryavanshi)", "https://firebasestorage.googleapis.com/v0/b/content-guru-8d6fd.appspot.com/o/Najaa%20Sooryavanshi%20128%20Kbps.mp3?alt=media&token=5564df50-dcab-435b-8abd-1692d442c2d4"));
        jcAudios.add(JcAudio.createFromURL("Tumse bhi Zyada(Tadap)", "https://firebasestorage.googleapis.com/v0/b/content-guru-8d6fd.appspot.com/o/Tumse%20Bhi%20Zyada%20Tadap%20128%20Kbps.mp3?alt=media&token=99d4679f-394c-422f-a2b2-9eab61794a53"));

        jcAudios.add(JcAudio.createFromRaw("Title-Song", R.raw.a_203));

        player.initPlaylist(jcAudios, this);
        adapterSetup();

        player.createNotification();

        return view;
    }

    @Override
    public void onStop() {
        super.onStop();
        player.createNotification();
    }

    protected void adapterSetup() {
        audioAdapter = new AudioAdapter(player.getMyPlaylist());
        audioAdapter.setOnItemClickListener(new AudioAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                player.playAudio(player.getMyPlaylist().get(position));
            }

            @Override
            public void onSongItemDeleteClicked(int position) {
                Toast.makeText(getActivity(), "Delete song at position " + position,
                        Toast.LENGTH_SHORT).show();

                removeItem(position);
            }
        });
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(audioAdapter);

        ((SimpleItemAnimator) recyclerView.getItemAnimator()).setSupportsChangeAnimations(false);

    }

    @Override
    public void onPause() {
        super.onPause();
        player.createNotification();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        player.kill();
    }

    @Override
    public void onPathError(JcAudio jcAudio) {
        Toast.makeText(getContext(), jcAudio.getPath() + " with problems", Toast.LENGTH_LONG).show();
    }


    @Override
    public void onPreparedAudio(JcStatus status) {

    }

    @Override
    public void onCompletedAudio() {

    }

    @Override
    public void onPaused(JcStatus status) {

    }

    @Override
    public void onContinueAudio(JcStatus status) {

    }

    @Override
    public void onPlaying(JcStatus status) {

    }

    @Override
    public void onTimeChanged(@NonNull JcStatus status) {
        updateProgress(status);
    }

    @Override
    public void onJcpError(@NonNull Throwable throwable) {
        Toast.makeText(getContext(), throwable.getMessage(), Toast.LENGTH_LONG).show();
    }

    private void updateProgress(final JcStatus jcStatus) {
        Log.d(TAG, "Song duration = " + jcStatus.getDuration()
                + "\n song position = " + jcStatus.getCurrentPosition());

        ((Activity)getContext()).runOnUiThread(new Runnable() {
            @Override
            public void run() {
                float progress = (float) (jcStatus.getDuration() - jcStatus.getCurrentPosition())
                        / (float) jcStatus.getDuration();
                progress = 1.0f - progress;
                audioAdapter.updateProgress(jcStatus.getJcAudio(), progress);
            }
        });
    }

    private void removeItem(int position) {
        ((SimpleItemAnimator) recyclerView.getItemAnimator()).setSupportsChangeAnimations(true);

        player.removeAudio(player.getMyPlaylist().get(position));
        audioAdapter.notifyItemRemoved(position);

        ((SimpleItemAnimator) recyclerView.getItemAnimator()).setSupportsChangeAnimations(false);
    }

    @Override
    public void onStopped(JcStatus status) {

    }
}