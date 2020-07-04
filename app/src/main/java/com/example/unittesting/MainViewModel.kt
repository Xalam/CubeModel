package com.example.unittesting

class MainViewModel(private val cubeModel: CubeModel) {
    fun getKeliling(): Double = cubeModel.getKeliling()

    fun getVolume(): Double = cubeModel.getVolume()

    fun getLuasPermukaan(): Double = cubeModel.getLuasPermukaan()

    fun save(l: Double, p: Double, t: Double) {
        cubeModel.save(l, p, t)
    }
}