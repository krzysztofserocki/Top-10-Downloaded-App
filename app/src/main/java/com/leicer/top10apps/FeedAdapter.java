package com.leicer.top10apps;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

public class FeedAdapter extends ArrayAdapter {
    private static final String TAG = "FeedAdapter";
    private final int layoutResource;
    private final LayoutInflater layoutInflater;
    private List<FeedEntry> applications;

    public FeedAdapter(@NonNull Context context, int resource, List<FeedEntry> applications) {
        super(context, resource);
        this.layoutResource = resource;
        this.layoutInflater = LayoutInflater.from(context);
        this.applications = applications;
    }

    @Override
    public int getCount() {
        return applications.size();
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        ViewHolder viewHolder;

        if (convertView == null) {
            convertView = layoutInflater.inflate(layoutResource, parent, false);

            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

//        TextView txtName = convertView.findViewById(R.id.txtName);
//        TextView txtArtist = convertView.findViewById(R.id.txtArtist);
//        TextView txtSummary = convertView.findViewById(R.id.txtSummary);
//        TextView txtNumber = convertView.findViewById(R.id.txtNumber);

        FeedEntry currentApp = applications.get(position);

        viewHolder.txtName.setText(currentApp.getName());
        viewHolder.txtArtist.setText(currentApp.getArtist());
        viewHolder.txtSummary.setText(currentApp.getSummary());
        viewHolder.txtNumber.setText(String.valueOf(position+1));

        return convertView;
    }

    private class ViewHolder extends RecyclerView.ViewHolder {
        final TextView txtName;
        final TextView txtArtist;
        final TextView txtSummary;
        final TextView txtNumber;

        ViewHolder(View v) {
            super(v);
            this.txtName = v.findViewById(R.id.txtName);
            this.txtArtist = v.findViewById(R.id.txtArtist);
            this.txtSummary = v.findViewById(R.id.txtSummary);
            this.txtNumber = v.findViewById(R.id.txtNumber);
        }
    }
}
