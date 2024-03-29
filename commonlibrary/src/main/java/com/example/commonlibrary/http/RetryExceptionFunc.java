package com.example.commonlibrary.http;

import org.apache.http.conn.ConnectTimeoutException;
import org.reactivestreams.Publisher;

import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import io.reactivex.Flowable;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Function;

/**
 * <p>描述：网络请求错误重试条件</p>
 */
public class RetryExceptionFunc implements Function<Flowable<? extends Throwable>, Flowable<?>> {
    /* retry次数*/
    private int count = 0;
    /*延迟*/
    private long delay = 500;
    /*叠加延迟*/
    private long increaseDelay = 3000;

    public RetryExceptionFunc() {

    }

    public RetryExceptionFunc(int count, long delay) {
        this.count = count;
        this.delay = delay;
    }

    public RetryExceptionFunc(int count, long delay, long increaseDelay) {
        this.count = count;
        this.delay = delay;
        this.increaseDelay = increaseDelay;
    }

    @Override
    public Flowable<?> apply(Flowable<? extends Throwable> flowable) throws Exception {
        return flowable.zipWith(Flowable.range(1, count + 1), new BiFunction<Throwable, Integer, Wrapper>() {
            @Override
            public Wrapper apply(Throwable throwable, Integer integer) throws Exception {
                return new Wrapper(throwable, integer);
            }
        }).flatMap(new Function<Wrapper, Publisher<?>>() {
            @Override
            public Publisher<?> apply(Wrapper wrapper) throws Exception {
                if ((wrapper.throwable instanceof ConnectException
                        || wrapper.throwable instanceof SocketTimeoutException
                        || wrapper.throwable instanceof ConnectTimeoutException
                        || wrapper.throwable instanceof SocketTimeoutException
                        || wrapper.throwable instanceof TimeoutException)
                        && wrapper.index < count + 1) { //如果超出重试次数也抛出错误，否则默认是会进入onCompleted
                    return Flowable.timer(delay + (wrapper.index - 1) * increaseDelay, TimeUnit.MILLISECONDS);

                }
                return Flowable.error(wrapper.throwable);
            }
        });
    }

    private class Wrapper {
        private int index;
        private Throwable throwable;

        public Wrapper(Throwable throwable, int index) {
            this.index = index;
            this.throwable = throwable;
        }
    }

}
