package team.iwfsg.fsg

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class FsgApplication

fun main(args: Array<String>) {
    runApplication<FsgApplication>(*args)
}
