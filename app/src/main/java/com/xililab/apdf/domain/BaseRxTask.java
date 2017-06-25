package com.xililab.apdf.domain;

import rx.Observable;
import rx.Scheduler;
import rx.Subscriber;

/**
 * Created by xililab on 25/06/17.
 */

public abstract class BaseRxTask
{
    private final Scheduler executionScheduler;
    private final Scheduler observerScheduler;

    protected BaseRxTask(Scheduler executionScheduler, Scheduler observerScheduler)
    {
        this.executionScheduler = executionScheduler;
        this.observerScheduler = observerScheduler;
    }

    protected abstract Observable buildObservable();

    public void execute(Subscriber subscriber)
    {
        this.buildObservable()
                .subscribeOn(this.executionScheduler)
                .observeOn(this.observerScheduler)
                .subscribe(subscriber);
    }


}
