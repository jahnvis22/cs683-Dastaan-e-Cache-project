package mem.config

import chisel3._
import chisel3.util._

abstract class StateList {
  val StateArray: Map[String, Int]
  final val stateLen: Int = if (StateArray.size <= 1) 1 else log2Ceil(StateArray.size)
  val ValidState: Int = 0
  val InvalidState: Int = 0
}

object StatesLDST extends StateList {
  override val StateArray: Map[String, Int] = Map(
    "I" -> 0x00,//Invalid
    "S" -> 0x01,//Shared
    "M" -> 0x02,//Modified
    "ID" -> 0x03,//Invalid-Dirty
    "IS" -> 0x04,//Invalid-Shared
    "IM" -> 0x05,//Invalid-Modified
    "D" -> 0x06,//Dirty
    "E" -> 0x07//Exclusive
  )
}

object StatesGP extends StateList {
  override val StateArray: Map[String, Int] = Map(
    "I" -> 0x00,
    "IU" -> 0x01,
    "V" -> 0x02
  )
  override val ValidState: Int = StateArray("V")
  override val InvalidState: Int = StateArray("I")
}

object StatesSpArch extends StateList {
  override val StateArray: Map[String, Int] = Map(
    "I" -> 0x00,
    "IC" -> 0x01,
    "V" -> 0x02,
    "IP" -> 0x04
  )
  override val ValidState: Int = StateArray("V")
  override val InvalidState: Int = StateArray("I")
}
