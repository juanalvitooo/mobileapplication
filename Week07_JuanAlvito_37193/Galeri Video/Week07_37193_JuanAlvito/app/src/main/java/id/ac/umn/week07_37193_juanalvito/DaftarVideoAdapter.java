package id.ac.umn.week07_37193_juanalvito;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.VideoView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.LinkedList;

class DaftarVideoAdapater extends RecyclerView.Adapter<DaftarVideoAdapater.ItemVideoViewHolder> {

    private LinkedList<SumberVideo> mDaftarVideo;
    private LayoutInflater mInflater;
    private Context mContext;

    public DaftarVideoAdapater(Context context, LinkedList<SumberVideo> daftarVideo){
        this.mContext = context;
        this.mDaftarVideo = daftarVideo;
        this.mInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public ItemVideoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.video_item_layout, parent, false);
        return new ItemVideoViewHolder(view, this);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemVideoViewHolder holder, int position) {
        SumberVideo mSumberVideo = mDaftarVideo.get(position);
        holder.tvJudul.setText(mSumberVideo.getJudul());
        holder.tvKeterangan.setText(mSumberVideo.getKeterangan());
        holder.tvUri.setText(mSumberVideo.getVideoURI());
        holder.kotakVideo.setVideoURI(Uri.parse(mSumberVideo.getVideoURI()));
        holder.kotakVideo.seekTo(100);
    }

    @Override
    public int getItemCount() {
        return mDaftarVideo.size();
    }

    public class ItemVideoViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        private VideoView kotakVideo;
        private TextView tvJudul, tvKeterangan, tvUri;
        private DaftarVideoAdapater mAdapter;
        private int mPosisi;
        private SumberVideo mSumberVideo;

        public ItemVideoViewHolder(@NonNull View itemView, DaftarVideoAdapater adapater) {
            super(itemView);

            mAdapter = adapater;
            kotakVideo = (VideoView) itemView.findViewById(R.id.kotakVideo);
            tvJudul = (TextView) itemView.findViewById(R.id.tvJudul);
            tvKeterangan = (TextView) itemView.findViewById(R.id.tvKeterangan);
            tvUri = (TextView) itemView.findViewById(R.id.tvUri);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            mPosisi = getLayoutPosition();
            mSumberVideo = mDaftarVideo.get(mPosisi);
            Bundle bundle = new Bundle();
            Intent detilInten = new Intent(mContext, DetilVideoActivity.class);
            bundle.putSerializable("DetilVideo", mSumberVideo);
            detilInten.putExtras(bundle);
            mContext.startActivity(detilInten);
        }
    }
}