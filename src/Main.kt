import kotlin.math.PI
import kotlin.math.tan

enum class Feature {
    USE_CORRECTION_FACTOR,
    USE_HIGH_PRECISION,
    PRINT_DEBUG
}

object FeatureFlags {

    private val flags = mutableMapOf(
        Feature.USE_CORRECTION_FACTOR to true,
        Feature.USE_HIGH_PRECISION to true,
        Feature.PRINT_DEBUG to true
    )

    fun isEnabled(feature: Feature): Boolean {
        return flags[feature] ?: false
    }

    fun set(feature: Feature, enabled: Boolean) {
        flags[feature] = enabled
    }
}

fun main() {
    //variables
    val n0 = 4 * PI * 1e-7
    val I: DoubleArray = doubleArrayOf(0.18, 0.22, 0.26, 0.31, 0.38, 0.45, 0.55)
    val N = 20.0
    val R = 0.15
    val angle: DoubleArray = doubleArrayOf(29.0, 34.0, 39.0, 45.0, 50.0, 55.0, 60.0)
    //formula
    for ((i,a) in I.zip(angle)) {
        if (FeatureFlags.isEnabled(Feature.USE_HIGH_PRECISION)) {
            val B_G = (n0 * i * N) / (2 * R * tan(Math.toRadians(a)))
            println(B_G.toLong())
        } else {
            val B_G = (n0 * i * N) / (2 * R * tan(Math.toRadians(a)))
            println(B_G)
        }
    }
}