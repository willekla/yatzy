package com.example.diceroller.com.example.diceroller

import android.widget.EditText

class Player : java.io.Serializable {
    private var name = ""
    private var enere = 0
    private var toere = 0
    private var treere = 0
    private var firere = 0
    private var femmere = 0
    private var seksere = 0
    private var bonus = 0
    private var etPar = 0
    private var toPar = 0
    private var treEns = 0
    private var fireEns = 0
    private var lille = 0
    private var stor = 0
    private var hus = 0
    private var chancen = 0
    private var sum = 0
    private var yatsy = 0


    fun getName(): String {
        return name
    }

    fun setName(name: String) {
        this.name = name
    }

    fun getEnere(): Int {
        return enere
    }

    fun setEnere(value: Int) {
        this.enere = value
    }

    fun getToere(): Int {
        return toere
    }

    fun setToere(value: Int) {
        this.toere = value
    }

    fun getTreere(): Int {
        return treere
    }

    fun setTreere(value: Int) {
        this.treere = value
    }

    fun getFirere(): Int {
        return firere
    }

    fun setFirere(value: Int) {
        this.firere = value
    }

    fun getFemmere(): Int {
        return femmere
    }

    fun setFemmere(value: Int) {
        this.femmere = value
    }

    fun getSeksere(): Int {
        return seksere
    }

    fun setSeksere(value: Int) {
        this.seksere = value
    }

    fun getEtPar(): Int {
        return etPar
    }

    fun setToPar(value: Int) {
        this.toPar = value
    }

    fun getTreEns(): Int {
        return treEns
    }

    fun setTreEns(value: Int) {
        this.treEns = value
    }

    fun getFireEns(): Int {
        return fireEns
    }

    fun setFireEns(value: Int) {
        this.fireEns = value
    }

    fun getLille(): Int {
        return lille
    }

    fun setLille(value: Int) {
        this.lille = value
    }

    fun getStor(): Int {
        return stor
    }

    fun setStor(value: Int) {
        this.stor = value
    }

    fun getHus(): Int {
        return hus
    }

    fun setHus(value: Int) {
        this.hus = value
    }

    fun getChancen(): Int {
        return chancen
    }

    fun setChancen(value: Int) {
        this.chancen = value
    }

    fun getYatzy(): Int {
        return yatsy
    }

    fun setYatzy(value: Int) {
        this.yatsy = value
    }

    fun getBonus(): Int {
        return bonus
    }

    fun getSum(): Int {
        return sum
    }

    fun setValgt() {
    }

    fun setChoice(value: CharSequence) {

    }


}