package com.github.albertopeam.infrastructure.concurrency;

import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;

import java.util.ArrayList;

import com.github.albertopeam.infrastructure.exceptions.ExceptionController;


/**
 * Created by Alberto Penas Amor on 25/05/2017.
 *
 * This class is a factory to provide an UseCaseExecutor, an object capable of execute async code
 * and handle errors.
 * It provides an {@link UseCaseExecutor} to execute {@link UseCase} intances. Also it contains
 * an {@link ExceptionController} that handles the exceptions raised during the execution of the
 * {@link UseCase} instances.
 */
public class UseCaseExecutorFactory {

    private UseCaseExecutorFactory(){}

    /**
     * Provides the use case executor
     * @param exceptionController to handle exceptions
     * @return UseCaseExecutor
     */
    public static UseCaseExecutor provide(@NonNull ExceptionController exceptionController){
        return new UseCaseExecutorImpl(
                    new ExecutorImpl(),
                    new AndroidMainThreadImpl(new Handler(Looper.getMainLooper())),
                    exceptionController,
                    new Tasks(new ArrayList<Task>())
            );
    }

}
