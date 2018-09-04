package no03

object Example extends App {

  def foo(accountId: Long, campaignId: Long): Boolean =
    accountId == 123l && campaignId == 456l

  val accountId = 123l
  val campaignId = 456l

  foo(accountId, campaignId)
  foo(campaignId, accountId) // 設定ミス！

}

object Example2 extends App {

  class AccountId(val value: Long) extends AnyVal
  class CampaignId(val value: Long) extends AnyVal
  class Result(val value: Boolean) extends AnyVal

  def foo(accountId: AccountId, campaignId: CampaignId): Boolean =
    accountId == new AccountId(123l) && campaignId == new CampaignId(456l)

  val accountId = new AccountId(123l)
  val campaignId = new CampaignId(456l)

  foo(accountId, campaignId)
//  foo(campaignId, accountId) // コンパイルエラー

}

object Example3 extends App {

  case class AccountId(value: Long) extends AnyVal
  case class CampaignId(value: Long) extends AnyVal
  case class Result(value: Boolean) extends AnyVal

  def foo(accountId: AccountId, campaignId: CampaignId): Boolean =
    accountId == AccountId(123l) && campaignId == CampaignId(456l)

  val accountId = AccountId(123l)
  val campaignId = CampaignId(456l)

  foo(accountId, campaignId)
  //foo(campaignId, accountId) // コンパイルエラー

}

object Example4 extends App {

  case class Value(value: Long) extends AnyVal {
    def addOne = Value(value + 1)
  }

  val amount = Value(1000l)
  println(amount.addOne)

}

// Compile Error!
object Example5 extends App {

  // val や var を定義することはできない
  //  case class Value(value: Long) extends AnyVal {
  //    val a = 1
  //    var b = 1
  //  }

  // コンストラクタの引数は複数持つことができない
//  case class Value(value1: Long, value2: Long) extends AnyVal

//  trait Animal
  trait Animal extends Any
  case class Dog(value: Long) extends AnyVal with Animal

}


