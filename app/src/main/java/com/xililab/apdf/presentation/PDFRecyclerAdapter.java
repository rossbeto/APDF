package com.xililab.apdf.presentation;

import android.databinding.DataBindingUtil;
import android.graphics.Bitmap;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.xililab.apdf.R;
import com.xililab.apdf.data.IPDFReaderRepository;
import com.xililab.apdf.databinding.PdfPageItemBinding;

/**
 * Created by xililab on 24/06/17.
 */

public class PDFRecyclerAdapter extends RecyclerView.Adapter<PDFRecyclerAdapter.ViewHolder>
{
    private IPDFReaderRepository pdfReaderRepository;
    public PDFRecyclerAdapter(IPDFReaderRepository pdfReaderRepository)
    {
        this.pdfReaderRepository = pdfReaderRepository;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.pdf_page_item, parent, false);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position)
    {
        if(this.pdfReaderRepository != null)
        {
            Bitmap pdfPageBitmap = this.pdfReaderRepository.getBitmap(position);
            holder.binder.pdfPage.setImageBitmap(pdfPageBitmap);
            holder.binder.executePendingBindings();
        }
    }

    @Override
    public int getItemCount()
    {
        if(this.pdfReaderRepository != null)
        {
            return pdfReaderRepository.getPageCount();
        }
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {
        public PdfPageItemBinding binder;
        public ViewHolder(View v)
        {
            super(v);
            binder = DataBindingUtil.bind(v);
        }
    }
}
