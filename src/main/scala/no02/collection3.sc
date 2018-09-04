val list = Seq(7, 1, 3, 1, 3, 1, 2, 4, 5, 6)

list.sum

list.product

list.min

list.max

list.foldLeft(0)((acc, x) => acc + x)
list.foldLeft(0)(_ + _)
list.sum
list.reduce(_ + _)

Seq("a", "b", "c", "d").foldLeft("")((acc, x) => acc + x)

Seq("a", "b", "c", "d").foldRight("")((acc, x) => acc + x)







