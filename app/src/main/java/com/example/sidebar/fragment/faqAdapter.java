package com.example.sidebar.fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sidebar.R;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class faqAdapter extends RecyclerView.Adapter<faqAdapter.faqa> {

    List<faqclass> qlist;

    public faqAdapter(List< faqclass > qlist) {
        this.qlist = qlist;
    }

    @NonNull
    @NotNull
    @Override
    public faqa onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row,parent,false);

        return new faqa(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull faqa holder, int position) {

        faqclass faqclass = qlist.get(position);
        holder.textView1.setText(faqclass.getQuestion());
        holder.expandView.setText(faqclass.getAns());

        boolean isExpand = qlist.get(position).isExpand();
        holder.expandView.setVisibility(isExpand ? View.VISIBLE : View.GONE);

    }

    @Override
    public int getItemCount() {
        return qlist.size();
    }

    public class faqa extends RecyclerView.ViewHolder {

        TextView textView1,expandView;
        LinearLayout linearLayout;
        RelativeLayout relativeLayout;

        public faqa(@NonNull @NotNull View itemView) {
            super(itemView);

            textView1 = itemView.findViewById(R.id.text1);
            expandView = itemView.findViewById(R.id.expandView);
            linearLayout = itemView.findViewById(R.id.layout);
            relativeLayout = itemView.findViewById(R.id.rl1);

            linearLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    faqclass faqclass = qlist.get(getAdapterPosition());
                    faqclass.setExpand(!faqclass.isExpand());
                    notifyItemChanged(getAdapterPosition());
                }
            });
        }
    }
}
