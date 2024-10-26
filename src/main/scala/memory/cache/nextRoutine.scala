package mem.memory.cache

abstract class NextRoutine {
  val routineTriggerList: Array[RoutinePC]
}

object nextRoutineLDST extends NextRoutine {
  override val routineTriggerList: Array[RoutinePC] = Array(
    Routine("LOAD_I"), DstState("ID"), Trigger(Seq("LOAD", "I")),
    Routine("STORE_I"), DstState("M"), Trigger(Seq("STORE", "I")),
    Routine("LOAD_ID"), DstState("ID"), Trigger(Seq("LOAD", "ID")),
    Routine("LOAD_E"), DstState("E"), Trigger(Seq("LOAD", "E")),
    Routine("DATA_ID"), DstState("D"), Trigger(Seq("DATA", "ID")),
    Routine("STORE_E"), DstState("E"), Trigger(Seq("STORE", "E")),
    Routine("NOP_E"), DstState("E"), Trigger(Seq("NOP", "E")),
    Routine("NOP_ID"), DstState("ID"), Trigger(Seq("NOP", "ID")),
    Routine("NOP_I"), DstState("I"), Trigger(Seq("NOP", "I"))
  )
}

object nextRoutineGP extends NextRoutine {
  override val routineTriggerList: Array[RoutinePC] = Array(
    Routine("INIT_I"), DstState("IU"), Trigger(Seq("INIT", "I")),
    Routine("UPDATE_I"), DstState("IU"), Trigger(Seq("UPDATE", "I")),
    Routine("UPDATE_IU"), DstState("IU"), Trigger(Seq("UPDATE", "IU")),
    Routine("DATA_IU"), DstState("IU"), Trigger(Seq("DATA", "IU"))
  )
}

object nextRoutineSpArch extends NextRoutine {
  override val routineTriggerList: Array[RoutinePC] = Array(
    Routine("COLLECT_I"), DstState("IC"), Trigger(Seq("COLLECT", "I")),
    Routine("DATA_IC"), DstState("V"), Trigger(Seq("DATA", "IC")),
    Routine("DATA_I"), DstState("V"), Trigger(Seq("DATA", "I")),
    Routine("DATA_IP"), DstState("V"), Trigger(Seq("DATA", "IP")),
    Routine("COLLECT_V"), DstState("IC"), Trigger(Seq("COLLECT", "V")),
    Routine("PREP_I"), DstState("IP"), Trigger(Seq("PREP", "I"))
  )
}
