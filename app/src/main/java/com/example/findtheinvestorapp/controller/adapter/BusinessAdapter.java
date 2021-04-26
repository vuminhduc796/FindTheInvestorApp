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
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
public class BusinessAdapter extends RecyclerView.Adapter<BusinessAdapter.BusinessViewHolder> {
    private Context mContext;
    private ArrayList <BusinessItem> mBusinessList;
    private OnItemClickListener mListener;
    private ArrayList<BusinessItem> full_items;

    public interface OnItemClickListener{
        void onItemClick(int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener){
        mListener = listener;
    }


    public BusinessAdapter(Context context, ArrayList<BusinessItem> businessList) {
        mContext = context;
        mBusinessList = businessList;
        full_items = new ArrayList<>(mBusinessList);
    }
    @Override
    public BusinessViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.business_item, parent, false);
        return new BusinessViewHolder(v);
    }
    @Override
    public void onBindViewHolder(BusinessViewHolder holder, int position) {
        BusinessItem currentItem = mBusinessList.get(position);
        String imageUrl = currentItem.getMainImage();
        String companyName = currentItem.getCompanyName();
        String companyDesc = currentItem.getProductsAndServices();
        holder.mTextViewCompany.setText(companyName);
        holder.mTextViewCompanyDesc.setText("Description: " + companyDesc);
        Picasso.with ( mContext ).load ( imageUrl ).fit ().centerInside ().into ( holder.mImageView );



    }
    public void setFullItems(ArrayList<BusinessItem> items){
        if(full_items.size() < items.size()) {
            this.full_items = new ArrayList<BusinessItem>(items);
        }
    }

    @Override
    public int getItemCount() {
        return mBusinessList.size();
    }
    public class BusinessViewHolder extends RecyclerView.ViewHolder {
        public ImageView mImageView;
        public TextView mTextViewCompany;
        public TextView mTextViewCompanyDesc;

        public BusinessViewHolder(View itemView) {
            super(itemView);
            mImageView = itemView.findViewById(R.id.image_view);
            mTextViewCompany = itemView.findViewById(R.id.text_view_company);
            mTextViewCompanyDesc = itemView.findViewById(R.id.text_view_desc);

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
