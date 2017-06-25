package com.xililab.apdf.domain;

import com.xililab.apdf.data.IPDFReaderRepository;

import rx.Observable;
import rx.Scheduler;

/**
 * Created by xililab on 25/06/17.
 */

public class ClosePDFTask extends BaseRxTask
{
    private IPDFReaderRepository pdfReaderRepository;
    public ClosePDFTask(Scheduler executionScheduler, Scheduler observerScheduler, IPDFReaderRepository pdfReaderRepository)
    {
        super(executionScheduler, observerScheduler);
        this.pdfReaderRepository = pdfReaderRepository;
    }

    @Override
    public Observable<Void> buildObservable()
    {
        return Observable.fromCallable(() -> pdfReaderRepository.closePDFReader());
    }
}
