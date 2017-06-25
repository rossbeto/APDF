package com.xililab.apdf.data;

import android.graphics.Bitmap;

import rx.Observable;


/**
 * Created by xililab on 24/06/17.
 */

public interface IPDFReaderRepository
{
    Observable<IPDFReaderRepository> openPDFReaderRepository();
    Observable<Bitmap> getBitmap(int position);
    int getPageCount();
    Void closePDFReader();
}
