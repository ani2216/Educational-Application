package Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sidebar.R;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class ModelAdapter extends RecyclerView.Adapter<ModelAdapter.MyViewHolder> {

    Context context;
    ArrayList<Model_Chat> list;

    public ModelAdapter(Context context, ArrayList< Model_Chat > list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @NotNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.chatlist,parent,false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull ModelAdapter.MyViewHolder holder, int position) {
        Model_Chat model_chat = list.get(position);
        holder.name.setText(model_chat.getName());
        holder.time.setText("("+model_chat.getTimestamp()+")");
        holder.message.setText(model_chat.getMessage());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView name,time,message;
        public MyViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.usernamemessage);
            time = itemView.findViewById(R.id.timemessage);
            message = itemView.findViewById(R.id.messagegone);


        }
    }
}
