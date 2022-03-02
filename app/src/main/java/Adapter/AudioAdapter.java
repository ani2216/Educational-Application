package Adapter;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.util.Log;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.jean.jcplayer.model.JcAudio;
import com.example.sidebar.R;

import java.util.List;

public class AudioAdapter extends RecyclerView.Adapter<AudioAdapter.AudioAdapterViewHolder> {
    private static final String TAG = AudioAdapter.class.getSimpleName();
    private static OnItemClickListener mListener;
    private List< JcAudio > jcAudioList;
    private SparseArray<Float> progressMap = new SparseArray<>();

    public AudioAdapter(List<JcAudio> jcAudioList) {
        this.jcAudioList = jcAudioList;
        setHasStableIds(true);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        mListener = listener;
    }

    @Override
    public AudioAdapterViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.songplayer, parent, false);
        return new AudioAdapterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(AudioAdapterViewHolder holder, int position) {
        String title = position + 1 + "    " + jcAudioList.get(position).getTitle();
        holder.audioTitle.setText(title);
        holder.itemView.setTag(jcAudioList.get(position));

        applyProgressPercentage(holder, progressMap.get(position, 0.0f));
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    private void applyProgressPercentage(AudioAdapterViewHolder holder, float percentage) {
        Log.d(TAG, "applyProgressPercentage() with percentage = " + percentage);
        LinearLayout.LayoutParams progress = (LinearLayout.LayoutParams) holder.viewProgress.getLayoutParams();
        LinearLayout.LayoutParams antiProgress = (LinearLayout.LayoutParams) holder.viewAntiProgress.getLayoutParams();

        progress.weight = percentage;
        holder.viewProgress.setLayoutParams(progress);

        antiProgress.weight = 1.0f - percentage;
        holder.viewAntiProgress.setLayoutParams(antiProgress);
    }

    @Override
    public int getItemCount() {
        return jcAudioList == null ? 0 : jcAudioList.size();
    }

    public void updateProgress(JcAudio jcAudio, float progress) {
        int position = jcAudioList.indexOf(jcAudio);
        Log.d(TAG, "Progress = " + progress);


        progressMap.put(position, progress);
        if (progressMap.size() > 1) {
            for (int i = 0; i < progressMap.size(); i++) {
                if (progressMap.keyAt(i) != position) {
                    Log.d(TAG, "KeyAt(" + i + ") = " + progressMap.keyAt(i));
                    notifyItemChanged(progressMap.keyAt(i));
                    progressMap.delete(progressMap.keyAt(i));
                }
            }
        }
        notifyItemChanged(position);
    }

    // Define the mListener interface
    public interface OnItemClickListener {
        void onItemClick(int position);

        void onSongItemDeleteClicked(int position);
    }

    static class AudioAdapterViewHolder extends RecyclerView.ViewHolder {
        private TextView audioTitle;
        private Button btnDelete;
        private View viewProgress;
        private View viewAntiProgress;

        public AudioAdapterViewHolder(View view) {
            super(view);
            this.audioTitle = view.findViewById(R.id.audio_title);
            this.btnDelete = view.findViewById(R.id.btn_delete);
            viewProgress = view.findViewById(R.id.song_progress_view);
            viewAntiProgress = view.findViewById(R.id.song_anti_progress_view);

            btnDelete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (mListener != null) {
                        AlertDialog.Builder alert = new AlertDialog.Builder(view.getContext());
                        alert.setTitle("Delete").setMessage("Want to delete the song?").setCancelable(false)
                                .setPositiveButton("yes", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        mListener.onSongItemDeleteClicked(getAdapterPosition());
                                    }
                                }).setNegativeButton("no", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                return;
                            }
                        });
                        AlertDialog alertDialog = alert.create();
                        alertDialog.show();
                    }
                }
            });

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Triggers click upwards to the adapter on click
                    if (mListener != null) mListener.onItemClick(getAdapterPosition());
                }
            });
        }
    }
}
