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
 * FizzBuzz Spec
 *
 * @author Elliot Wright <elliot@elliotwright.co>
 */
class FizzBuzzSpec extends FlatSpec {
  "FizzBuzz" should "return fizz if the number is dividable by 3" in {
    assert(FizzBuzz.fizzbuzz(3) === "fizz")
    assert(FizzBuzz.fizzbuzz(6) === "fizz")
  }

  it should "return buzz if the number is dividable by 5" in {
    assert(FizzBuzz.fizzbuzz(5) === "buzz")
    assert(FizzBuzz.fizzbuzz(10) === "buzz")
  }

  it should "return fizzbuzz if the number is dividable by 15" in {
    assert(FizzBuzz.fizzbuzz(15) === "fizzbuzz")
    assert(FizzBuzz.fizzbuzz(30) === "fizzbuzz")
  }

  it should "return the same number if no other requirement is fulfilled" in {
    assert(FizzBuzz.fizzbuzz(1) === "1")
    assert(FizzBuzz.fizzbuzz(2) === "2")
    assert(FizzBuzz.fizzbuzz(4) === "4")
  }
}
