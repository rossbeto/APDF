package com.xililab.apdf.domain;

import android.graphics.Bitmap;

import com.xililab.apdf.data.IPDFReaderRepository;

import rx.Observable;
import rx.Scheduler;

/**
 * Created by xililab on 25/06/17.
 */

public class GetBitmapTask extends BaseRxTask
{
    private IPDFReaderRepository pdfReaderRepository;
    private int position;

    public GetBitmapTask(Scheduler executionScheduler, Scheduler observerScheduler, IPDFReaderRepository pdfReaderRepository)
    {
        super(executionScheduler, observerScheduler);
        this.pdfReaderRepository = pdfReaderRepository;
    }

    @Override
    public Observable<Bitmap> buildObservable()
    {
        return pdfReaderRepository.getBitmap(this.position);
    }

    public GetBitmapTask setPosition(int position)
    {
        this.position = position;
        return this;
    }
}
