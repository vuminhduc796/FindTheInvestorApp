package com.example.findtheinvestorapp.controller.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.findtheinvestorapp.R;
import com.example.findtheinvestorapp.model.BusinessItem;
import com.example.findtheinvestorapp.model.ProposalItem;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
public class ProposalAdapter extends RecyclerView.Adapter<ProposalAdapter.ProposalViewHolder> {
    private Context mContext;
    private ArrayList <ProposalItem> proposalItems;
    private OnItemClickListener mListener;
    private ArrayList<ProposalItem> full_items;

    public interface OnItemClickListener{
        void onItemClick(int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener){
        mListener = listener;
    }


    public ProposalAdapter(Context context, ArrayList<ProposalItem> list) {
        mContext = context;
        proposalItems = list;
        full_items = new ArrayList<>(proposalItems);
    }
    @Override
    public ProposalViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.proposal_item, parent, false);
        return new ProposalViewHolder(  v);
    }
    @Override
    public void onBindViewHolder(ProposalViewHolder holder, int position) {
        ProposalItem currentItem = proposalItems.get(position);
        String title = currentItem.getProposalTitle();
        String imageUrl = "https://findback.sydneystardigital.com/uploads/businesslogo/221b294e-e433-4f04-be9a-e8c198c68065.png";
        String description = currentItem.getProposalDetailedDescription();
        if(description.length() > 200){
            holder.desc_txt.setText("Description: " + description.substring(0,200) + "...");
        } else {
            holder.desc_txt.setText("Description: " + description);
        }
        holder.title_txt.setText(title);

        Picasso.with ( mContext ).load ( imageUrl ).fit ().centerInside ().into ( holder.img );


    }
    public void setFullItems(ArrayList<ProposalItem> items){
        if(full_items.size() < items.size()) {
            this.full_items = new ArrayList<ProposalItem>(items);
        }
    }

    @Override
    public int getItemCount() {
        return proposalItems.size();
    }
    public class ProposalViewHolder extends RecyclerView.ViewHolder {
        public TextView title_txt;
        public TextView desc_txt;
        public ImageView img;
        public ProposalViewHolder(View itemView) {
            super(itemView);
            title_txt = itemView.findViewById(R.id.header_txt);
            desc_txt = itemView.findViewById(R.id.description_txt);
            img = itemView.findViewById(R.id.img);

            itemView.setOnClickListener ( new View.OnClickListener ( ) {
                @Override
                public void onClick ( View v ) {
                    if(mListener != null){
                        int position = getAdapterPosition ();
                        if ( position != RecyclerView.NO_POSITION ){
                            mListener.onItemClick ( position );
                        }
                    }
                }
            } );
        }
    }
}
