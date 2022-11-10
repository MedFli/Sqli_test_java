package com.sqli.coin.model;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CoinMachine {
    double total;
    int valueOfCoins;
    int numberOfCoins;
    int numberOf50;
    int numberOf20;

    public CoinMachine() {
    }

    public double getTotal() {
        return total;
    }

    public double totalMoney() {
        return total;
    }

    public void putMoneyInside(String s) {
        numberOfCoins = Integer.parseInt(s.substring(0, s.indexOf("x")));
        valueOfCoins = Integer.parseInt(s.substring(s.indexOf("x") + 1, s.length()));

        switch (valueOfCoins) {
            case 50:
                numberOf50 += numberOfCoins;
                break;
            case 20:
                numberOf20 += numberOfCoins;
                break;
        }
        long result = ((long) valueOfCoins * numberOfCoins);

        total += result;
    }

    public double check(int i) {
        return (i == 50) ? numberOf50 : numberOf20;
    }

    public void getMoney(int i) {
        int takeFrom50 = i / 50;
        int takeFrom20 = i % 50;
        if (!(i / 50 == 0)) {
            numberOf50 -= takeFrom50;
            if (!(i / 20 == 0)) {
                numberOf20 -= takeFrom20 / 20;
            }
            log.info("no more 20 coins in the machine ");
        }
        log.info("no 50 coins in the machine");
    }
}
