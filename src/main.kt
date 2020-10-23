package machine
import java.util.Scanner

val scanner = Scanner(System.`in`)
var water = 400
var milk = 540
var beans = 120
var cups = 9
var money = 550
var output = Fill.WATER.output

enum class State {
    EXIT, MAINMENU, BUY, FILL, TAKE, REMAINING;

}

enum class Fill(val output: String) {
    WATER("Write how many ml of water do you want to add: "),
    MILK("Write how many ml of milk do you want to add: "),
    BEANS("Write how many grams of coffee bean do you want to add: "),
    CUPS("Write how many disposable cups of coffee do you want to add: ");
}

class CoffeeMachine {
    companion object {

        fun mainMenu(task: String): State {
            while (task != "exit") {
                return when (task) {
                    "buy" -> State.BUY
                    "fill" -> State.FILL
                    "take" -> State.TAKE
                    "remaining" -> State.REMAINING
                    else -> {
                        println("I do not understand that command")
                        State.MAINMENU
                    }
                }
            }
            return State.EXIT
        }

        fun buy(task: String, w: Int, m: Int, b: Int, c: Int): State {
            if (task != "back")
                when (task) {
                    "1" -> {
                        when {
                            w - 250 < 0 -> {
                                println("Sorry, not enough water!")
                                println()
                            }
                            b - 16 < 0 -> {
                                println("Sorry, not enough coffee beans!")
                                println()
                            }
                            m < 0 -> {
                                println("Sorry, not enough milk!")
                                println()
                            }
                            c - 1 < 0 -> {
                                println("Sorry, not enough coffee cups!")
                                println()
                            }
                            else -> {
                                water -= 250
                                beans -= 16
                                cups -= 1
                                money += 4
                                println("I have enough resources, making you a coffee!")
                                println()
                            }
                        }
                        return State.MAINMENU
                    }
                    "2" -> {
                        when {
                            w - 350 < 0 -> {
                                println("Sorry, not enough water!")
                                println()
                            }
                            b - 20 < 0 -> {
                                println("Sorry, not enough coffee beans!")
                                println()
                            }
                            m - 75 < 0 -> {
                                println("Sorry, not enough milk!")
                                println()
                            }
                            c - 1 < 0 -> {
                                println("Sorry, not enough coffee cups!")
                                println()
                            }
                            else -> {
                                water -= 350
                                milk -= 75
                                beans -= 20
                                cups -= 1
                                money += 7
                                println("I have enough resources, making you a coffee!")
                                println()
                            }
                        }
                        return State.MAINMENU
                    }
                    "3" -> {
                        when {
                            w - 200 < 0 -> {
                                println("Sorry, not enough water!")
                                println()
                            }
                            b - 12 < 0 -> {
                                println("Sorry, not enough coffee beans!")
                                println()
                            }
                            m - 100 < 0 -> {
                                println("Sorry, not enough milk!")
                                println()
                            }
                            c - 1 < 0 -> {
                                println("Sorry, not enough coffee cups!")
                                println()
                            }
                            else -> {
                                water -= 200
                                milk -= 100
                                beans -= 12
                                cups -= 1
                                money += 6
                                println("I have enough resources, making you a coffee!")
                                println()

                            }
                        }
                        return State.MAINMENU
                    }
                    else -> {
                        println("I do not understand that command")
                        println()
                        return State.MAINMENU
                    }
                }
            return State.MAINMENU

        }

        fun take(my: Int): State {
            println("I gave you $$my")
            println()
            money -= my
            return State.MAINMENU
        }

        fun remaining(): State {
            println("The coffee machine has:")
            println("$water of water")
            println("$milk of milk")
            println("$beans of coffee beans")
            println("$cups of disposable cups")
            println("$$money of money")
            println()
            return State.MAINMENU
        }

        fun fill(add: Int, counter: Int): Int {
            while (counter != 0) {
               return when (counter) {
                    1 -> {
                        water += add
                        output = Fill.MILK.output
                        2
                    }
                    2 -> {
                        milk += add
                        output = Fill.BEANS.output
                        3
                    }
                    3 -> {
                        beans += add
                        output = Fill.CUPS.output
                       4
                    }
                    else -> {
                        cups += add
                        output = Fill.WATER.output
                        0
                    }
                }

            }
            return 0
        }
    }
}

fun main() {
    var state = State.MAINMENU
    while (state != State.EXIT) {
        when (state) {
            State.MAINMENU -> {
                print("Write action (buy, fill, take, remaining, exit): ")
                state = CoffeeMachine.mainMenu(scanner.next())
                println()
            }
            State.BUY -> {
                print("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu: ")
                state = CoffeeMachine.buy(scanner.next(), water, milk, beans, cups)
            }
            State.TAKE -> state = CoffeeMachine.take(money)
            State.REMAINING -> state = CoffeeMachine.remaining()
            else -> {
                var count = 1
                while (count != 0) {
                    print(output)
                    count = CoffeeMachine.fill(scanner.nextInt(), count)
                }
                println()
                state = State.MAINMENU
            }
        }
    }
}






