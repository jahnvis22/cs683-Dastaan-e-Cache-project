package mem.memory.cache

abstract class RoutineRom {
  val routineActions: Array[RoutinePC]
}

object RoutineROMLDST extends RoutineRom {
  override val routineActions: Array[RoutinePC] = Array(
    Routine("LOAD_I"), Actions(Seq("AllocateTBE", "Allocate", "DataRQ", "UpdateTBE", "SetState")), DstState("ID"),
    Routine("STORE_I"), Actions(Seq("Allocate", "WrInt", "SetState")), DstState("E"),
    Routine("LOAD_ID"), Actions(Seq("SetState")), DstState("ID"),
    Routine("LOAD_E"), Actions(Seq("SetState")), DstState("E"),
    Routine("DATA_ID"), Actions(Seq("DeallocateTBE", "WrInt", "RdInt", "SetState")), DstState("E"),
    Routine("STORE_E"), Actions(Seq("WrInt", "SetState")), DstState("E"),
    Routine("NOP_E"), Actions(Seq("SetState")), DstState("E"),
    Routine("NOP_I"), Actions(Seq("SetState")), DstState("I"),
    Routine("NOP_ID"), Actions(Seq("SetState")), DstState("ID"),
    Routine("STORE_IS"), Actions(Seq("WrInt", "SetState")), DstState("S")
  )
}

object RoutineROMSpArch extends RoutineRom {
  val ReqForMultiLines: Seq[String] = Seq("AddGP", "DataRQWalker")

  override val routineActions: Array[RoutinePC] = Array(
    Routine("COLLECT_I"), Actions(Seq("AllocateTBE", "Allocate") ++ ReqForMultiLines ++ Seq("FeedbackSparch", "SetState")), DstState("IC"),
    Routine("PREP_I"), Actions(Seq("BIfDataNotZero", "WAIT", "SetState", "NOP", "AllocateTBE", "Allocate", "FeedbackSparch", "SetState")), DstState("IP"),
    Routine("DATA_IC"), Actions(Seq("DeallocateTBE", "WrInt", "RdInt", "SetState")), DstState("V"),
    Routine("DATA_IP"), Actions(Seq("DeallocateTBE", "WrInt", "SetState")), DstState("V"),
    Routine("COLLECT_V"), Actions(Seq("FeedbackCollect", "SetState")), DstState("V"),
    Routine("DATA_I"), Actions(Seq("Allocate", "WrInt", "RdInt", "SetState")), DstState("V")
  )
}

object RoutineROMGP extends RoutineRom {
  override val routineActions: Array[RoutinePC] = Array(
    Routine("INIT_I"), Actions(Seq("Allocate", "WrInt", "SetState")), DstState("IU"),
    Routine("UPDATE_I"), Actions(Seq("BIfDataNotZero", "WAIT", "SetState", "NOP", "AllocateTBE", "Allocate", "AddGP", "DataRQWalker", "FeedbackGP", "SetState")), DstState("IU"),
    Routine("UPDATE_IU"), Actions(Seq("BIfDataNotZero", "WAIT", "SetState", "NOP", "AllocateTBE", "AddGP", "DataRQWalker", "FeedbackGP", "SetState")), DstState("IU"),
    Routine("DATA_IU"), Actions(Seq("DeallocateTBE", "WrInt", "RdInt", "SetState")), DstState("IU")
  )
}
