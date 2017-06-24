package com.xililab.apdf.presentation;

import android.databinding.ObservableField;

import com.xililab.apdf.data.IPDFReaderRepository;

/**
 * Created by xililab on 24/06/17.
 */

public class PDFDisplayViewModel
{
    public ObservableField<IPDFReaderRepository> getPdfRepository()
    {
        return pdfRepository;
    }

    public void setPdfRepository(IPDFReaderRepository pdfRepository)
    {
        this.pdfRepository.set(pdfRepository);
    }

    private ObservableField<IPDFReaderRepository> pdfRepository = new ObservableField<>();
}
