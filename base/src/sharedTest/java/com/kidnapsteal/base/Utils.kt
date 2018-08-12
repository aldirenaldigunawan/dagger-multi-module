package com.kidnapsteal.base

import org.mockito.Mockito
import org.mockito.invocation.InvocationOnMock
import org.mockito.stubbing.Answer

class Mocker: Answer<Any> {

    override fun answer(invocation: InvocationOnMock): Any {
        return Mockito.mock(invocation.method.returnType)
    }

    companion object {
        inline fun <reified T> create(): T {
            return Mockito.mock(T::class.java, Mocker())
        }
    }
}