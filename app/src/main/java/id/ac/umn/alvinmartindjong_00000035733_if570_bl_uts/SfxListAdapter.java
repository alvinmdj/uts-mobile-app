package id.ac.umn.alvinmartindjong_00000035733_if570_bl_uts;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.LinkedList;

public class SfxListAdapter extends RecyclerView.Adapter<SfxListAdapter.SfxItemViewHolder> {
    private LinkedList<SfxSource> mSfxList;
    private LayoutInflater mInflater;
    private Context mContext;

    public SfxListAdapter(Context context, LinkedList<SfxSource> sfxList) {
        this.mContext = context;
        this.mSfxList = sfxList;
        this.mInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public SfxListAdapter.SfxItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.sfx_item_layout, parent, false); {
            return new SfxItemViewHolder(view, this);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull SfxItemViewHolder holder, int position) {
        SfxSource mSfxSource = mSfxList.get(position);
        holder.sfxTitle.setText(mSfxSource.getTitle());
        holder.sfxDescription.setText(mSfxSource.getDescription());
        holder.sfxThumbnail.setImageResource(R.drawable.ic_speaker);

        holder.btnDelete.setOnClickListener(view -> {
            String title =  mSfxList.get(position).getTitle();
            mSfxList.remove(position);
            Toast.makeText(view.getContext(), "SFX " + title + " baru saja dihapus", Toast.LENGTH_SHORT).show();
            notifyItemRemoved(position);
            notifyItemRangeChanged(position, getItemCount());
        });
    }

    @Override
    public int getItemCount() {
        return mSfxList.size();
    }

    class SfxItemViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private ImageView sfxThumbnail;
        private TextView sfxTitle;
        private TextView sfxDescription;
        private Button btnDelete;
        private SfxListAdapter mAdapter;
        private int mPosition;
        private SfxSource mSfxSource;

        public SfxItemViewHolder(@NonNull View itemView, SfxListAdapter adapter) {
            super(itemView);
            mAdapter = adapter;
            sfxThumbnail = itemView.findViewById(R.id.sfx_thumbnail);
            sfxTitle = itemView.findViewById(R.id.sfx_title);
            sfxDescription = itemView.findViewById(R.id.sfx_description);
            btnDelete = itemView.findViewById(R.id.btn_delete);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            mPosition = getLayoutPosition();
            mSfxSource = mSfxList.get(mPosition);
            Intent playIntent = new Intent(mContext, PlayActivity.class);
            Bundle bundle = new Bundle();
            bundle.putSerializable("PlaySFX", mSfxSource);
            playIntent.putExtras(bundle);
            mContext.startActivity(playIntent);
        }
    }
}
