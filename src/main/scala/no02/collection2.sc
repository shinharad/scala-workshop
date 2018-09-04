val list = Seq(7, 1, 3, 0, 3, 1, 2, 4, 5, 6)

list.foreach(x => print(x))
list.foreach(print)

list.map(x => x * 2)
list.map(_ * 2)

def f: Int => Option[Int] = x => if (x > 0) Some(x * 2) else None

list.map(f(_))

list.flatMap(f(_))

//--------------------------------------

val list1 = Seq(1, 2, 3, 4)
val list2 = Seq(5, 6, 7, 8, 9)
val list3 = list1.zip(list2)
list3.map { case (x, y) => x * y }

//--------------------------------------

list.find(_ == 1)

list.count(_ % 2 == 0)

list.filter(_ == 1)
list.filterNot(_ == 1)

list.filter(_ == 1).map(_ * 2)
list.withFilter(_ == 1).map(_ * 2)

list.collect {
  case x if x % 2 == 0 =>
    x * 2
}

Seq(1, 2, 3).forall(_ > 0)
Seq(1, 0, 3).forall(_ > 0)
Seq(0, 0, 0).exists(_ > 0)
Seq(1, 0, 0).exists(_ > 0)

//--------------------------------------

list.groupBy(_ % 2 == 0)

list.partition(_ % 2 == 0)

//--------------------------------------

list.sorted

list.sortWith((x, y) => x > y)
list.sortWith(_ > _)
