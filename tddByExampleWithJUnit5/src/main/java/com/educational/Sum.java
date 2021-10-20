package com.educational;

public class Sum implements Expression {
    final Expression argument;
    final Expression addment;

    public Sum(Expression argument, Expression addment) {
        this.argument = argument;
        this.addment = addment;
    }

    @Override
    public Money reduce(Bank bank, String to) {
        int amount = argument.reduce(bank, to).amount + addment.reduce(bank, to).amount;
        return new Money(amount, to);
    }

    @Override
    public Expression plus(Expression added) {
        return new Sum(this, added);
    }

    @Override
    public Expression times(int multiplier) {
        return new Sum(argument.times(multiplier), addment.times(multiplier));
    }
}
