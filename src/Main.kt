import kotlin.math.PI
import kotlin.math.tan

enum class Feature {
    USE_CORRECTION_FACTOR,
    USE_HIGH_PRECISION,
    OUTPUT_IN_MICROTESLA
}

object FeatureFlags {

    private val flags = mutableMapOf(
        Feature.USE_CORRECTION_FACTOR to true,
        Feature.USE_HIGH_PRECISION to true,
        Feature.OUTPUT_IN_MICROTESLA to true
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
        val B_G = (n0 * i * N) / (2 * R * tan(Math.toRadians(a)))
        if (FeatureFlags.isEnabled(Feature.USE_HIGH_PRECISION)) {
            val correction = if (FeatureFlags.isEnabled(Feature.USE_CORRECTION_FACTOR)) 1.02 else 1.0
            val B_G_new = correction * B_G
            println(B_G_new)
        } else if (FeatureFlags.isEnabled(Feature.OUTPUT_IN_MICROTESLA)) {
            println(B_G * 1e6)
        } else {
            println("Ответ без feature flag: ${B_G}")
        }
    }
}