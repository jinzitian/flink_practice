package com.jinzitian.flink.practice

import org.apache.flink.api.scala._
import org.apache.flink.streaming.api.scala.StreamExecutionEnvironment

import scala.collection.mutable.{ArrayBuffer, HashMap, Map}

/**
  * Created by jinzitian on 2019/03/27.
  */
object FlinkFirst {

    def main(args: Array[String]): Unit = {

        val env = StreamExecutionEnvironment.getExecutionEnvironment

        val inputStream = env.fromElements(Tuple2("a",1),Tuple2("b",1),Tuple2("c",1),Tuple2("a",2),Tuple2("b",3))

        val counts = inputStream.keyBy(_._1).sum(1)

        counts.print()

        env.execute()

    }

}
