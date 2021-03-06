package com.github.albertopeam.infrastructure.exceptions;

import android.support.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alberto Penas Amor on 28/05/2017.
 *
 * Concrete implementation of {@link ExceptionController}
 */

class ExceptionControllerImpl
        implements ExceptionController{


    private List<ExceptionDelegate> delegates;


    ExceptionControllerImpl(@NonNull List<ExceptionDelegate> delegates) {
        this.delegates = delegates;
    }


    @Override
    public HandledException handle(@NonNull Exception exception) {
        List<ExceptionDelegate>targetDelegates = new ArrayList<>();
        for (ExceptionDelegate delegate:delegates){
            if (delegate.canHandle(exception)){
                targetDelegates.add(delegate);
            }
        }
        if (targetDelegates.isEmpty()){
            exception.printStackTrace();
            throw new NotHandledException(exception);
        }else if (targetDelegates.size() == 1){
            ExceptionDelegate delegate = targetDelegates.get(0);
            return delegate.handle(exception);
        }else {
            exception.printStackTrace();
            throw new CollisionException(exception, targetDelegates);
        }
    }

}
