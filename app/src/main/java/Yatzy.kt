package com.example.diceroller

class Yatzy {
    val dots = IntArray(7)
    var enere = 0
    var toere = 0
    var treere = 0
    var firere = 0
    var femmere = 0
    var seksere = 0
    var bonus = 0
    var etPar = 0
    var toPar = 0
    var treEns = 0
    var fireEns = 0
    private var lille = 0
    private var stor = 0
    var hus = 0
    private var chancen = 0
    private var sum = 0
    private var treFireFem =0
    var yatsy = 0

    var isEnere = false
    var isToere = false
    private var isTreere = false
    private var isFirere = false
    private var isFemmere = false
    var isSeksere = false
    var isEtPar = false
    var isToPar = false
    var isTreEns = false
    var isFireEns = false
    var isLille = false
    var isStor = false
    var isHus = false
    var iYatsy = false


    fun calculateResult(t1: Dice, t2: Dice, t3: Dice, t4: Dice, t5: Dice) {
        dots[t1.getDots()]++
        dots[t2.getDots()]++
        dots[t3.getDots()]++
        dots[t4.getDots()]++
        dots[t5.getDots()]++

        chancen = calcChancen()
        treFireFem = treFireFemEns()

    }


    fun getChancen(): Int {
        return chancen
    }

    fun getTreFireFem(): Int {
        return treFireFem
    }

    fun getSum(): Int{
        return sum
    }

    fun reset(){
        chancen = 0
        sum=0
        isLille = false
        isStor = false
        for (dot in 1..6){
            dots[dot] = 0
        }

    }
    fun getResult(): String {
        var res = "Du har følgende muligheder:\n"

        for (dot in 1..6){
            var antal = onesToSix(dot)
            if (antal > 0) {
                res = res + "\nAntal " + dot + "'ere: " + antal + " - sum: " + antal * dot
            }
        }

        var chancen = "\nChancen: " + getChancen().toString()
        if (getTreFireFem() > 0){
            if (getTreFireFem() > 3) {
                res = res + "\n" + "3 ens - sum: " + 3 * getSum() / getTreFireFem()

                if (getTreFireFem() > 4) {
                    res = res + "\n" + "4 ens - sum: " + 4 * getSum() / getTreFireFem()
                    res = res + "\n" + "Yatzy - sum: " + getSum()
                }else {
                    res = res + "\n" + "4 ens - sum: " + 4 * getSum() / getTreFireFem()
                }
            }else {
                res = res + "\n" + "3 ens - sum: " + getSum()
            }
        }

        getlilleEllerStor()
        if (isLille){
            res = res + "\n" + "Lille - sum: 15"
        }else if (isStor){
            res = res + "\n" + "Stor - 20"
        }

        return res+chancen
    }

    private fun getlilleEllerStor(){
        for (dot in 2..5){
            if (dots[dot] > 1){
               return
            }
        }
        if (dots[1] == 1){
            isLille = true
        } else{
            isStor = true
        }
    }

    private fun onesToSix(dot: Int): Int {
       return dots[dot]
    }
    private fun calcChancen(): Int {
        for (dot in 1..6){
            chancen= chancen + (dots[dot])*dot
        }
        return chancen
    }

    private fun treFireFemEns(): Int {
        for (dot in 1..6){
            if (dots[dot] >=3){
                sum = (dots[dot])*dot
                return dots[dot]
            }

        }
        return 0
    }

}
