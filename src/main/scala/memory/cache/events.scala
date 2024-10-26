package mem.config

import chisel3._
import chisel3.util._

abstract class EventList {
  val eventArray: Map[String, Int]
  val eventLen: Int = if (eventArray.size == 1) 1 else log2Ceil(eventArray.size)
  val hitEvent: Array[Int] = Array()
}

object EventsLDST extends EventList {
  override val eventArray: Map[String, Int] = Map(
    "LOAD" -> 0x00,
    "STORE" -> 0x01,
    "DATA" -> 0x02,
    "NOP" -> 0x03
  )
}

object EventsGP extends EventList {
  override val eventArray: Map[String, Int] = Map(
    "INIT" -> 0x00,
    "UPDATE" -> 0x01,
    "DATA" -> 0x02
  )
  override val hitEvent: Array[Int] = Array(eventArray("INIT"), eventArray("UPDATE"))
}

object EventsSpArch extends EventList {
  override val eventArray: Map[String, Int] = Map(
    "COLLECT" -> 0x00,
    "PREP" -> 0x01,
    "DATA" -> 0x02
  )
  override val hitEvent: Array[Int] = Array(eventArray("PREP"), eventArray("COLLECT"))
}
