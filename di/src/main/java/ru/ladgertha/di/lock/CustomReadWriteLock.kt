package ru.ladgertha.di.lock

import java.util.concurrent.locks.Lock

// TODO Move to another module
interface CustomReadWriteLock {
    fun readLock(): Lock

    fun <T> writeWithLock(action: () -> T): T

    fun hasQueuedThreads(): Boolean
}
