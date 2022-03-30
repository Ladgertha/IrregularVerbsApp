package ru.ladgertha.di.lock

import java.util.concurrent.locks.ReentrantReadWriteLock
import kotlin.concurrent.write

class ReentrantCustomReadWriteLock : CustomReadWriteLock, ReentrantReadWriteLock() {

    override fun readLock(): ReentrantReadWriteLock.ReadLock =
        super.readLock()

    override fun <T> writeWithLock(action: () -> T): T = write(action)
}
