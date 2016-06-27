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
 * FizzBuzz
 *
 * @author Elliot Wright <elliot@elliotwright.co>
 */
object FizzBuzz extends App {
  def fizzbuzz(n: Int): String = (n % 3, n % 5) match {
    case (0, 0) => "fizzbuzz"
    case (_, 0) => "buzz"
    case (0, _) => "fizz"
    case _ => n.toString
  }

  println("# FizzBuzz")
  (1 to 30).foreach((n) => {
    println(s"$n: " + fizzbuzz(n))
  })
}
