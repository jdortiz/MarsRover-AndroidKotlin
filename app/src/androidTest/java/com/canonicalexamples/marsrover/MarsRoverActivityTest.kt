package com.canonicalexamples.marsrover

import android.support.test.espresso.Espresso.closeSoftKeyboard
import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.action.ViewActions.click
import android.support.test.espresso.action.ViewActions.typeText
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.ViewMatchers
import android.support.test.espresso.matcher.ViewMatchers.withText
import android.support.test.rule.ActivityTestRule
import org.junit.Rule
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
class MarsRoverActivityTest {
    //<editor-fold desc="Test variables">
    @get:Rule
    var activityTestRule: ActivityTestRule<MarsRoverActivity> = ActivityTestRule<MarsRoverActivity>(MarsRoverActivity::class.java)
    //</editor-fold>

    @Test
    fun userInputRRPrintsPositionOriginSouth() {
        onView(ViewMatchers.withId(R.id.commandsEditText)).perform(typeText("RR"))
        closeSoftKeyboard()
        onView(ViewMatchers.withId(R.id.moveRoverButton)).perform(click())
        onView(ViewMatchers.withId(R.id.positionTextView)).check(matches(withText("(0, 0, S)")))
    }
}