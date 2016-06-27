/**
 * This file is part of the "Katas" project.
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the LICENSE is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
 */

import org.scalatest.FlatSpec

/**
 * BerlinClock Spec
 *
 * @author Elliot Wright <elliot@elliotwright.co>
 */
class BerlinClockSpec extends FlatSpec {

  "Yellow lamp" should "blink on/off every two seconds" in {
    assert(BerlinClock.seconds(0) === "Y")
    assert(BerlinClock.seconds(1) === "O")
    assert(BerlinClock.seconds(59) === "O")
  }

  "Top hours" should "have 4 lamps" in {
    assert(BerlinClock.topHours(7).length === 4)
  }

  it should "light a red lamp for every 5 hours" in {
    assert(BerlinClock.topHours(0) === "OOOO")
    assert(BerlinClock.topHours(13) === "RROO")
    assert(BerlinClock.topHours(23) === "RRRR")
    assert(BerlinClock.topHours(24) === "RRRR")
  }

  "Bottom hours" should "have 4 lamps" in {
    assert(BerlinClock.bottomHours(5).length === 4)
  }

  it should "light a red lamp for every hour left from top hours" in {
    assert(BerlinClock.bottomHours(0) === "OOOO")
    assert(BerlinClock.bottomHours(13) === "RRRO")
    assert(BerlinClock.bottomHours(23) === "RRRO")
    assert(BerlinClock.bottomHours(24) === "RRRR")
  }

  "Top minutes" should "have 11 lamps" in {
    assert(BerlinClock.topMinutes(34).length === 11)
  }

  it should "have 3rd, 6th and 9th lamps in red to indicate first quarter, half and last quarter" in {
    val minutes32 = BerlinClock.topMinutes(32)

    assert(minutes32(2) === 'R')
    assert(minutes32(5) === 'R')
    assert(minutes32(8) === 'O')
  }

  it should "light a yellow lamp for every 5 minutes unless it's first quarter, half or last quarter" in {
    assert(BerlinClock.topMinutes(0) === "OOOOOOOOOOO")
    assert(BerlinClock.topMinutes(17) === "YYROOOOOOOO")
    assert(BerlinClock.topMinutes(59) === "YYRYYRYYRYY")
  }

  "Bottom minutes" should "have 4 lamps" in {
    assert(BerlinClock.bottomMinutes(0).length === 4)
  }

  it should "light a yellow lamp for every minute left from top minutes" in {
    assert(BerlinClock.bottomMinutes(0) === "OOOO")
    assert(BerlinClock.bottomMinutes(17) === "YYOO")
    assert(BerlinClock.bottomMinutes(59) === "YYYY")
  }

  "Berlin Clock" should "result in array with 5 elements" in {
    assert(BerlinClock.convertToBerlinTime("13:17:01").size === 5)
  }

  it should "result in correct seconds, hours and minutes" in {
    val berlinTime = BerlinClock.convertToBerlinTime("16:37:16")
    val expected = Array("Y", "RRRO", "ROOO", "YYRYYRYOOOO", "YYOO")

    assert(berlinTime === expected)
  }
}
