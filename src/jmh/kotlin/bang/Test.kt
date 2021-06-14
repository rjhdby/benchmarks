package bang

import Cases
import inputWords
import org.openjdk.jmh.annotations.*
import org.openjdk.jmh.infra.Blackhole
import java.util.concurrent.atomic.AtomicLong

@State(Scope.Benchmark)
@Warmup(iterations = 3)
@Measurement(iterations = 3, batchSize = 100)
@Fork(2)
open class Test {
    var pos = AtomicLong()

    fun provider(): String {
        val current = pos.getAndIncrement()
        return inputWords[(current % (inputWords.size - 1)).toInt()]
    }

    @Benchmark
    fun static_list(bh: Blackhole) {
        bh.consume(Cases.static_list(provider()))
    }

    @Benchmark
    fun static_set(bh: Blackhole) {
        bh.consume(Cases.static_set(provider()))
    }

    @Benchmark
    fun list_to_set(bh: Blackhole) {
        bh.consume(Cases.list_to_set(provider()))
    }

    @Benchmark
    fun in_place_list_creation(bh: Blackhole) {
        bh.consume(Cases.in_place_list_creation(provider()))
    }

    @Benchmark
    fun static_interned_list_iterator(bh: Blackhole) {
        bh.consume(Cases.static_interned_list_iterator(provider()))
    }

    @Benchmark
    fun static_list_iterator(bh: Blackhole) {
        bh.consume(Cases.static_list_iterator(provider()))
    }

    @Benchmark
    fun static_interned_list_classic_for(bh: Blackhole) {
        bh.consume(Cases.static_interned_list_classic_for(provider()))
    }

    @Benchmark
    fun static_list_classic_for(bh: Blackhole) {
        bh.consume(Cases.static_list_classic_for(provider()))
    }

    @Benchmark
    fun static_interned_list(bh: Blackhole) {
        bh.consume(Cases.static_interned_list(provider()))
    }
}