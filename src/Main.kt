import kotlin.math.PI
import kotlin.math.tan

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    //variables
    val n0 = 4 * PI * 1e-7
    val I: DoubleArray = doubleArrayOf(0.18, 0.22, 0.26, 0.31, 0.38, 0.45, 0.55)
    val N = 20.0
    val R = 0.15
    val angle: DoubleArray = doubleArrayOf(29.0, 34.0, 39.0, 45.0, 50.0, 55.0, 60.0)
    //formula
    for ((i,a) in I.zip(angle)) {
        val B_G = (n0 * i * N) / (2 * R * tan(Math.toRadians(a)))
        println(B_G)
    }
}