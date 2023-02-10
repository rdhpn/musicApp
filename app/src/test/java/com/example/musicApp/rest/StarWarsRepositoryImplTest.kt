//package com.example.musicApp.rest
//
//import com.example.musicApp.model.MusicResponse
//import com.example.musicApp.model.domain.Rock
//import com.example.musicApp.utils.UIState
//import com.google.common.truth.Truth.assertThat
//import io.mockk.clearAllMocks
//import io.mockk.coEvery
//import io.mockk.every
//import io.mockk.mockk
//import kotlinx.coroutines.test.runTest
//
//import org.junit.After
//import org.junit.Before
//import org.junit.Test
//
//class MusicRepositoryImplTest {
//
//    private lateinit var testObject: MusicRepository
//
//    private val mockMusicApi: MusicApi = mockk(relaxed = true)
//
//    @Before
//    fun setUp() {
//        testObject = MusicRepositoryImpl(mockMusicApi)
//    }
//
//    @After
//    fun tearDown() {
//        clearAllMocks()
//    }
//
//    @Test
//    fun `get all rock when server provides a list of rock should return a success state`() =
//        runTest {
//            // AAA
//            // ASSIGNMENT
//            coEvery { mockMusicApi.getRocks() } returns mockk {
//                every { isSuccessful } returns true
//                every { body() } returns MusicResponse(results = listOf(mockk(), mockk()))
//            }
//            val states = mutableListOf<UIState>()
//
//            // ACTION
//            testObject.getRocks().collect {
//                states.add(it)
//            }
//
//            // ASSERTION
//            assertThat(states).hasSize(2)
//            assertThat(states.first()).isInstanceOf(UIState.LOADING::class.java)
//            assertThat(states[1]).isInstanceOf(UIState.SUCCESS::class.java)
//            assertThat(
//                (states[1] as UIState.SUCCESS<List<com.example.musicApp.model.Result>>).response
//            ).hasSize(2)
//    }
//}