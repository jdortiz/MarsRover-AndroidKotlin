package com.canonicalexamples.marsrover.model

import org.junit.After
import org.junit.Before

import org.junit.Assert.*
import org.junit.Test

/**
 * 20180314. Initial version created by jorge
 * for a Canonical Examples training.
 *
 *
 * Copyright 2018 Jorge D. Ortiz Fuentes
 *
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
class RoverTest {

    val initialX = 0
    val initialY = 0
    val initialDirection = 'N'

    lateinit var sut: Rover

    @Before
    fun setUp() {
        sut = Rover(x = initialX, y = initialY, direction = initialDirection)
    }

    @Test
    fun sutIsNotNull() {
        assertNotNull(sut)
    }

    @Test
    fun oneRightSetsDirectionToEast() {
        executeAndVerifyDirection(commands = "R", expectedDirection = 'E')
    }

    @Test
    fun twoRightSetsDirectionToSouth() {
        executeAndVerifyDirection(commands = "RR", expectedDirection = 'S')
    }

    @Test
    fun threeRightSetsDirectionToWest() {
        executeAndVerifyDirection(commands = "RRR", expectedDirection = 'W')
    }

    @Test
    fun fourRightSetsDirectionToNorth() {
        executeAndVerifyDirection(commands = "RRRR", expectedDirection = 'N')
    }

    private fun executeAndVerifyDirection(commands: String, expectedDirection: Char) {
        sut.execute(commands = commands)

        assertEquals(expectedDirection, sut.direction)
    }
}