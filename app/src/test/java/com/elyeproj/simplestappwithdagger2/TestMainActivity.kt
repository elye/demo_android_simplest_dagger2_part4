package com.elyeproj.simplestappwithdagger2

import dagger.Component
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import javax.inject.Inject

class TestMainActivity {

    @Inject @field:Choose(LOVE) lateinit var infoLove: Info
    @Inject @field:Choose(HELLO) lateinit var infoHello: Info

    @Before
    fun setup() {
        DaggerTestMagicBox.builder().bag(TestBag()).build().poke(this)
    }

    @Test
    fun simpleTest() {
        assertEquals("Test Love", infoLove.text)
        assertEquals("Hello Dagger 2", infoHello.text)
    }
}

class TestBag: Bag() {
    override fun sayLoveDagger2(): Info {
        return Info("Test Love")
    }
}

@Component(modules = [Bag::class])
interface TestMagicBox : MagicBox {
    fun poke(app: TestMainActivity)
}
