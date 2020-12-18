package com.example.diceroller

import android.provider.Settings.Global.getString

class Yatzy {
    val dots = IntArray(7)
    var enere = 0
    var toere = 0
    var treere = 0
    var firere = 0
    var femmere = 0
    var seksere = 0
    var bonus = 0
    private var etPar = 0
    private var toPar = 0
    var treEns = 0
    var fireEns = 0
    private var lille = 0
    private var stor = 0
    private var hus = 0
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
    private var isEtPar = false
    private var isToPar = false
    var isTreEns = false
    var isFireEns = false
    private var isLille = false
    private var isStor = false
    private var isHus = false
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
        isHus = false
        hus = 0
        isEtPar = false
        etPar = 0
        isToPar = false
        toPar = 0
        for (dot in 1..6){
            dots[dot] = 0
        }

    }
    fun getResultAsText(): String {
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

        get1Par2par()
        if (isEtPar){
            res = res + "\n" + "Et par: " + etPar
            if (isToPar) {
                res = res + "\n" + "To par: " + toPar
            }
        }

        getHus()
        if (isHus){
            res = res + "\n" + "Hus: " + hus
        }

        return res+chancen
    }

    private fun getHus() {
        for (dot in 1..6){
            if (dots[dot] == 2){
                for (dot1 in 1..6){
                    if (dots[dot1] == 3){
                        isHus = true
                        hus = 2*dot + 3*dot1
                        return
                    }
                }
            }
        }
    }

    private fun get1Par2par() {
        for (dot in 6 downTo 1){
            if (dots[dot] == 2){
                isEtPar = true
                etPar = 2*dot
                for (dot1 in 6 downTo 1){
                    if (dots[dot1] == 2 && dot1 != dot){
                        isToPar = true
                        toPar = 2*dot + 2*dot1
                        return
                    }
                }
            }
        }
    }

    private fun getlilleEllerStor(){
        for (dot in 2..5){
            if (dots[dot] != 1 ){
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

    fun getResultAsArray(): ArrayList<String> {
        var pos = ArrayList<String>()

        for (dot in 1..6){
            var antal = onesToSix(dot)
            if (antal > 0) {
               pos.add("\nAntal " + dot + "'ere: " + antal + " - sum: " + antal * dot)
            }
        }

        if (getTreFireFem() > 0){
            var res = ""
            if (getTreFireFem() > 3) {
                pos.add("3 ens - sum: " + 3 * getSum() / getTreFireFem())

                if (getTreFireFem() > 4) {
                    pos.add("4 ens - sum: " + 4 * getSum() / getTreFireFem())
                    pos.add("Yatzy - sum: " + getSum())
                }else {
                    pos.add("4 ens - sum: " + 4 * getSum() / getTreFireFem())
                }
            }else {
                pos.add("3 ens - sum: " + getSum())
            }
        }

        getlilleEllerStor()
        if (isLille){
            pos.add("Lille - sum: 15")
        }else if (isStor){
            pos.add("Stor - 20")
        }

        get1Par2par()
        if (isEtPar){
            pos.add("Et par: " + etPar)
            if (isToPar) {
                pos.add("To par: " + toPar)
            }
        }

        getHus()
        if (isHus){
           pos.add("Hus: " + hus)
        }

        pos.add("Chancen: " + getChancen().toString())
        return pos
    }

}
