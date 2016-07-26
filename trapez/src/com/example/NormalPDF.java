package com.example;

public class NormalPDF implements Function {
    private double mu;
    private double sigma;

    public NormalPDF(double mu, double sigma) {
        this.mu = mu;
        this.sigma = sigma;
    }

    public double eval(double x) {
        double num = Math.exp( -(x - mu) * (x - mu) / (2 * sigma * sigma));
        double den = sigma * Math.sqrt(2 * Math.PI);
        return num / den;
    }

    public void inverse(double x) 
    {
    //   ...
    }

}