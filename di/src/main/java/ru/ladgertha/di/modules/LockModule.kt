package ru.ladgertha.di.modules

import org.koin.dsl.module
import ru.ladgertha.di.lock.CustomReadWriteLock
import ru.ladgertha.di.lock.ReentrantCustomReadWriteLock

val lockModule = module {

    factory<CustomReadWriteLock> {
        ReentrantCustomReadWriteLock()
    }
}