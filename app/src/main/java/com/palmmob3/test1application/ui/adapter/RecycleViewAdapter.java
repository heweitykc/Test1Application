package com.palmmob3.test1application.ui.adapter;

import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.palmmob3.test1application.R;
import com.palmmob3.test1application.bean.User;

import java.util.List;

public class RecycleViewAdapter extends RecyclerView.Adapter<RecycleViewAdapter.MyViewHolder> {

   public List<User> users;

   public RecycleViewAdapter(List<User> users){
      this.users = users;
   }

   public void setUsers(List<User> users){
      this.users = users;
   }

   @NonNull
   @Override
   public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
      View root = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycle_item, parent, false);
      return new MyViewHolder(root);
   }

   @Override
   public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
      User user = users.get(position);
      holder.txtUsername.setText(user.userName);
   }

   @Override
   public int getItemCount() {
      return users == null ? 0 :users.size();
   }

   public class MyViewHolder extends RecyclerView.ViewHolder {
      private TextView txtUsername;

      public MyViewHolder(View view){
         super(view);
         txtUsername = view.findViewById(R.id.txt_username);
      }
   }

}
