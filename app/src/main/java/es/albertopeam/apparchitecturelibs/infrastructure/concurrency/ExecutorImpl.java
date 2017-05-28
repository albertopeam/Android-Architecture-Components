package es.albertopeam.apparchitecturelibs.infrastructure.concurrency;

import android.support.annotation.NonNull;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Executor can be used to execute tasks in background threads
 */
class ExecutorImpl implements java.util.concurrent.Executor {


    private int NUM_THREADS = 0;
    private ExecutorService executor;


    /**
     * Returns a new ThreadExecutor with n threads where n is the number of processors availables
     */
    ExecutorImpl() {
        NUM_THREADS = Runtime.getRuntime().availableProcessors();
        executor = Executors.newFixedThreadPool(NUM_THREADS);
    }


    /**
     * Returns a new ThreadExecutor with int threads
     */
    ExecutorImpl(int threads) {
        NUM_THREADS = threads;
        executor = Executors.newFixedThreadPool(NUM_THREADS);
    }


    @Override
    public void execute(@NonNull Runnable runnable) {
        executor.execute(runnable);
    }


    void shutdown(){
        executor.shutdown();
    }
}