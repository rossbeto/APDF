package com.xililab.apdf.data;

import android.graphics.Bitmap;
import android.graphics.pdf.PdfRenderer;
import android.os.ParcelFileDescriptor;

import java.io.IOException;

/**
 * Created by xililab on 24/06/17.
 */

public class PDFReaderRepository implements IPDFReaderRepository
{
    PdfRenderer pdfRenderer;
    ParcelFileDescriptor parcelFileDescriptor;

    public PDFReaderRepository(ParcelFileDescriptor parcelFileDescriptor)
    {
        this.parcelFileDescriptor = parcelFileDescriptor;
    }

    @Override
    public IPDFReaderRepository openPDFReaderRepository()
    {
        try
        {
            this.pdfRenderer = new PdfRenderer(this.parcelFileDescriptor);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        return this;
    }

    @Override
    public Bitmap getBitmap(int position)
    {
        PdfRenderer.Page page = pdfRenderer.openPage(position);
        Bitmap bitmap = Bitmap.createBitmap(page.getWidth(), page.getHeight(),
                Bitmap.Config.ARGB_8888);
        page.render(bitmap, null, null, PdfRenderer.Page.RENDER_MODE_FOR_DISPLAY);
        page.close();
        return bitmap;
    }

    @Override
    public int getPageCount()
    {
        if(this.pdfRenderer != null)
        {
            return this.pdfRenderer.getPageCount();
        }
        return 0;
    }

    @Override
    public void closePDFReader()
    {
        try
        {
            if(this.pdfRenderer != null) pdfRenderer.close();
            if(parcelFileDescriptor != null) parcelFileDescriptor.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
