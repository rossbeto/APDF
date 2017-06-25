package com.xililab.apdf.data;

import android.graphics.Bitmap;

/**
 * Created by xililab on 24/06/17.
 */

public interface IPDFReaderRepository
{
    IPDFReaderRepository openPDFReaderRepository();
    Bitmap getBitmap(int position);
    int getPageCount();
    void closePDFReader();
}
