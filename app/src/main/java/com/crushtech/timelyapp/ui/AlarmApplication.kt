package com.crushtech.timelyapp.ui

import android.app.Application
import com.crushtech.timelyapp.data.database.AlarmDatabase
import com.crushtech.timelyapp.data.repository.AlarmRepository
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.androidXModule
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider
import org.kodein.di.generic.singleton

class AlarmApplication():Application(),KodeinAware {
    override val kodein: Kodein= Kodein.lazy {
        import(androidXModule(this@AlarmApplication))
        bind() from this.singleton { AlarmDatabase(this.instance()) }
        bind() from this.singleton { AlarmRepository(this.instance()) }
        bind() from this.provider {
            AlarmViewModelFactory(this.instance())
        }
    }

}