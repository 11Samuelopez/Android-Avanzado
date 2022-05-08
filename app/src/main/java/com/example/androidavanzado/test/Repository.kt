package com.example.androidavanzado.test

class RepositorySinInversionOfControl{

    private val dependency1 = DependencyProduccion()

    fun getDatos(): Int {
        return dependency1.getDatos()
    }
}

class RepositoryInversionOfControl(
    private val dependency1: DependencyInterface
) {


    fun getDatos(): Int {
        return dependency1.getDatos()
    }
}

