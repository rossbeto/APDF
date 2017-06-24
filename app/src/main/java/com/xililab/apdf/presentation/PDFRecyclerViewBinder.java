package com.xililab.apdf.presentation;

import android.databinding.BindingAdapter;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.xililab.apdf.data.IPDFReaderRepository;

/**
 * Created by xililab on 24/06/17.
 */

public class PDFRecyclerViewBinder
{
    @BindingAdapter({"bind:pdf"})
    public static void bindPDF(RecyclerView recyclerView, IPDFReaderRepository pdfReaderRepository)
    {
        if(pdfReaderRepository != null)
        {
            LinearLayoutManager layoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
            if(layoutManager == null)
            {
                layoutManager = new LinearLayoutManager(recyclerView.getContext());
            }
            if(recyclerView.getAdapter()== null)
            {
                recyclerView.setLayoutManager(layoutManager);
                recyclerView.setAdapter(new PDFRecyclerAdapter(pdfReaderRepository));
            }
            else
            {
                recyclerView.getAdapter().notifyDataSetChanged();
            }
        }
    }
}
