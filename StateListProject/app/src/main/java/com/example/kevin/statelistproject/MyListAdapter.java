package com.example.kevin.statelistproject;

import android.net.sip.SipSession;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class MyListAdapter extends RecyclerView.Adapter<MyListAdapter.MyViewHolder>{

    public interface ListItemClickListener{
        void onListItemClick(int position);
    }

    private String[] stateLists;
    ListItemClickListener itemClickListener;

    public MyListAdapter(String[] stateLists,ListItemClickListener itemClickListener) {

        this.stateLists = stateLists;
        this.itemClickListener = itemClickListener;

    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {


        Boolean attachViewImmediatelyToParent = false;
        View singleItemLayout = LayoutInflater.from(parent.getContext()).inflate(R.layout.my_text_view,parent,attachViewImmediatelyToParent);
        MyViewHolder myViewHolder = new MyViewHolder(singleItemLayout);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.textToShow.setText(stateLists[position]);
    }

    @Override
    public int getItemCount() {
        return stateLists.length;
    }

    class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView textToShow;


        public MyViewHolder(View itemView) {
            super(itemView);
            textToShow = (TextView) itemView.findViewById(R.id.text_view);
            textToShow.setOnClickListener(this);

        }


        @Override
        public void onClick(View v) {
            itemClickListener.onListItemClick(getAdapterPosition());
        }
    }
}
