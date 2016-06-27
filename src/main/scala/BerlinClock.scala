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


/**
 * BerlinClock
 *
 * @author Elliot Wright <elliot@elliotwright.co>
 */
object BerlinClock extends App {
  def convertToBerlinTime(time: String): Seq[String] = {
    time.split(":") match {
      case Array(h, m, s) => Seq(
        seconds(s.toInt),
        topHours(h.toInt),
        bottomHours(h.toInt),
        topMinutes(m.toInt),
        bottomMinutes(m.toInt)
      )
      case _ => Seq()
    }
  }

  def seconds(s: Int): String =
    if (s % 2 == 0) "Y" else "O"

  def topHours(h: Int): String = onOff(topRowOn(h), "R", 4)
  def topMinutes(m: Int): String = onOff(topRowOn(m), "Y", 11).replace("YYY", "YYR")

  def bottomHours(m: Int): String = onOff(bottomRowOn(m), "R", 4)
  def bottomMinutes(m: Int): String = onOff(bottomRowOn(m), "Y", 4)

  private def onOff(on: Int, onChar: String, total: Int): String =
    (onChar * on) + ("O" * (total - on))

  private def topRowOn(n: Int): Int =
    (n - (n % 5)) / 5

  private def bottomRowOn(n: Int): Int =
    n % 5
}
