package com.github.albertopeam.infrastructure.concurrency;

/**
 * This enum represents the state of the {@link android.arch.lifecycle.LifecycleOwner}
 */
enum LifecycleState {
    CREATED, STARTED, RESUMED, PAUSED, STOPPED, DESTROYED, UNKNOW
}