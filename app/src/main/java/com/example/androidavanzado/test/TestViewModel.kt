package com.example.androidavanzado.test

class TestViewModel {
    val repositorySinInversionOfControl = RepositorySinInversionOfControl()


    val dependencyProduccion = DependencyProduccion()
    val dependencyStaging = DependencyStaging()
    val repositoryInversionOfControl = RepositoryInversionOfControl(dependencyStaging)
}