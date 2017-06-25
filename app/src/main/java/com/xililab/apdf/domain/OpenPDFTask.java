package com.xililab.apdf.domain;

import com.xililab.apdf.data.IPDFReaderRepository;

import rx.Observable;
import rx.Scheduler;

/**
 * Created by xililab on 25/06/17.
 */

public class OpenPDFTask extends BaseRxTask
{
    private IPDFReaderRepository pdfReaderRepository;
    public OpenPDFTask(Scheduler executionScheduler, Scheduler observerScheduler, IPDFReaderRepository pdfReaderRepository)
    {
        super(executionScheduler, observerScheduler);
        this.pdfReaderRepository = pdfReaderRepository;
    }

    @Override
    public Observable<IPDFReaderRepository> buildObservable()
    {
        return pdfReaderRepository.openPDFReaderRepository();
    }
}
