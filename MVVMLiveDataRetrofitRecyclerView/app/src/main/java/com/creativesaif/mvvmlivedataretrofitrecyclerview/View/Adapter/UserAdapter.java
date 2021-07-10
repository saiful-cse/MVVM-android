package com.creativesaif.mvvmlivedataretrofitrecyclerview.View.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.creativesaif.mvvmlivedataretrofitrecyclerview.Model.User;
import com.creativesaif.mvvmlivedataretrofitrecyclerview.R;

import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.MyViewHolder>{

    private Context mContext;
    private static final String TAG = "Adapter";
    private List<User> userList;

    public UserAdapter(Context mContext, List<User> userList) {
        this.mContext = mContext;
        this.userList = userList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull  ViewGroup parent, int viewType) {
        View view =  LayoutInflater.from(mContext).inflate(R.layout.user_row, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull  UserAdapter.MyViewHolder holder, int position) {

        final User user = userList.get(position);

        if (user.getName() != null) {
            holder.txtName.setText(user.getName());
        }
        if (user.getEmail() != null) {
            holder.txtEmail.setText(user.getEmail());
        }
        if (user.getPhone() != null) {
            holder.txtPhone.setText(user.getPhone());
        }
    }

    @Override
    public int getItemCount() {
        if (userList != null && userList.size() > 0) {
            return userList.size();
        } else {
            return 0;
        }
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView txtName;
        TextView txtEmail;
        TextView txtPhone;

        public MyViewHolder(@NonNull  View itemView) {
            super(itemView);
            txtName = itemView.findViewById(R.id.txt_name);
            txtEmail = itemView.findViewById(R.id.txt_email);
            txtPhone = itemView.findViewById(R.id.txt_phone);
        }
    }
}
