package com.htcursos.bancocombiblioteca.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.htcursos.bancocombiblioteca.R;
import com.htcursos.bancocombiblioteca.model.User;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Vinicius on 26/11/2016.
 */

public class UserListAdapter extends ArrayAdapter<User> {
    public UserListAdapter(Context context, List<User> userList) {
        super(context, R.layout.activity_item_list, userList);
    }

    class ViewHolder{
        @BindView(R.id.txt_nome)
        TextView name;
        @BindView(R.id.txt_email)
        TextView email;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final ViewHolder holder;
        if (convertView == null){
            convertView = View.inflate(getContext(), R.layout.activity_item_list, null);
            holder = new ViewHolder();
            ButterKnife.bind(holder, convertView);
            convertView.setTag(holder);
        }else {
            holder = (ViewHolder) convertView.getTag();
        }
        final User user = getItem(position);
        holder.name.setText(user.getName());
        holder.email.setText(user.getEmail());
        return convertView;
    }
}
