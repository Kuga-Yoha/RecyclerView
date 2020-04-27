package com.example.myrecycle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ExampleAdapter extends RecyclerView.Adapter<ExampleAdapter.ExampleViewHolder> {
    private ArrayList<ExampleItem> mExampleList;
    private OnItemClickListener mListener;// other onitem

    public interface  OnItemClickListener{
        void onItemClick(int position);
        void onDeleteClick(int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener){
        mListener=listener;

    }



    public static class ExampleViewHolder extends RecyclerView.ViewHolder {
        public ImageView mImageView;
        public TextView mTextView1;
        public TextView mTextView2;
        public ImageView mDeleteImageView;


        public ExampleViewHolder(View itemView, final OnItemClickListener listener) {
            super(itemView);

            mImageView= itemView.findViewById(R.id.imageView);
            mTextView1= itemView.findViewById(R.id.textView);
            mTextView2=itemView.findViewById(R.id.textView2);
            mDeleteImageView = itemView.findViewById(R.id.image_delete);

            itemView.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v) {
                    if(listener!=null){
                        int position= getAdapterPosition();
                        if(position!=RecyclerView.NO_POSITION){
                            listener.onItemClick(position);
                        }

                    }
                }
            });

            mDeleteImageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(listener!=null){
                        int position= getAdapterPosition();
                        if(position!=RecyclerView.NO_POSITION){
                            listener.onDeleteClick(position);
                        }

                    }
                }


            });
        }





    }
    public ExampleAdapter (ArrayList<ExampleItem> exampleList){
        mExampleList = exampleList;
    }



    @NonNull
    @Override



    public ExampleViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {
       View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_example_item, parent, false);
       ExampleViewHolder evh=new ExampleViewHolder(v, mListener);
        return  evh;
    }

    @Override
    public void onBindViewHolder(@NonNull ExampleViewHolder holder, int position) { //info about whAT TO store
            ExampleItem currentItem= mExampleList.get(position);

            holder.mImageView.setImageResource(currentItem.getImageResource());
            holder.mTextView1.setText(currentItem.getText1());
            holder.mTextView2.setText(currentItem.getText2());
    }

    @Override
    public int getItemCount() {
        return  mExampleList.size();
    }



}
