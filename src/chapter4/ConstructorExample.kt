package chapter4

open class User1(val nickName: String) // val means init when constructed by parameters

class User2 constructor(_nickName: String) {
    val nickName: String?

    init {
        nickName = _nickName
    }
}

class User3(_nickName: String) {
    val nickName = _nickName
}

class PcUser(nickName: String) : User1(nickName)

class Secretive private constructor()