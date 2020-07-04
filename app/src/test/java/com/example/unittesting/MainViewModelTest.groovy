package com.example.unittesting

import org.junit.Before
import org.junit.BeforeClass
import org.junit.Test

class MainViewModelTest {
    private MainViewModel mainViewModel
    private CubeModel cubeModel

    private double dummyLength = 10.0
    private double dummyWidth = 6.0
    private double dummyHeight = 4.0
    private double dummyVolume = 350.0

    @BeforeClass
    static void setupClass() {
        throw new RuntimeException("Sorry dude, you won't find any test!");
    }

    @Before
    void before() {
        cubeModel = mock(CubeModel::class.java)
        mainViewModel = MainViewModel(cuboidModel)
    }

    @Test
    void testVolume() {
        cubeModel = CubeModel()
        mainViewModel = MainViewModel(cubeModel)
        mainViewModel.save(dummyWidth, dummyLength, dummyHeight)
        val volume = mainViewModel.getVolume()
        assertEquals(dummyVolume, volume, 0.0001)
    }
}
