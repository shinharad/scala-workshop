
class Animal(val name: String) {

  this.name

}

class Animal2(val name: String) { self =>

  self.name
  this.name

}


//-----------------------------------------

trait DBAccess { self: DB =>
  def find: Unit = {
    self.open

    self.query

    self.close
  }
}

trait DB {
  def dbName: String
  def open: Unit
  def close: Unit
  def query: Unit
}

trait MySQL extends DB {
  def dbName: String = "MySQL"
  def open: Unit = println(s"connection open [$dbName]")
  def close: Unit = println(s"connection close [$dbName]")
  def query: Unit = println(s"query data [$dbName]")
}


class MySQLDBAccess extends DBAccess with MySQL

val db = new MySQLDBAccess
db.find


val db2 = new DBAccess with MySQL
db2.find


trait PostgreSQL extends DB {
  def dbName: String = "PostgreSQL"
  def open: Unit = println(s"connection open [$dbName]")
  def close: Unit = println(s"connection close [$dbName]")
  def query: Unit = println(s"query data [$dbName]")
}

val db3 = new DBAccess with PostgreSQL

db3.find

