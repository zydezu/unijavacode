package sof2week03softwarelab;

import java.util.Arrays;

public class Vector {
    double[] vector;

    public Vector(double[] input) {
        vector = input.clone(); // avoid referencing HELL
    }

    public String toString() {
        String builder = "";
        for (double v : vector) {
            builder += v + ", ";
        }
        return builder.substring(0, builder.length() - 2); // remove last
    }

    public int size() {
        return vector.length;
    }

    public Double get(int index) {
        return vector[index];
    }

    public Double set(int index, double value) {
        double temp = vector[index];
        vector[index] = value;
        return temp;
    }

    public Vector scalarProduct(double scalar) {
        double[] newVector = new double[this.size()];
        for (int i = 0; i < this.size(); i++) {
            newVector[i] = vector[i] * scalar;
        }
        return new Vector(newVector); // a class INSTANCE (no name!!!!), like C#
    }

    public Vector add(Vector other) {
        if (this.size() != other.size()) {
            return null;
        }
        double newVector[] = new double[this.size()];
        for (int i = 0; i < this.size(); i++) {
            newVector[i] = vector[i] + other.vector[i];
        }
        return new Vector(newVector);
    }

    public boolean equals(Object other) {
        if (!(other instanceof Vector)) {
            return false;
        }
        Vector otherVector = (Vector)other; // use a cast to continue
        if (this.size() != otherVector.size()) {
            return false;
        }
        for (int i = 0; i < this.size(); i++) {
            if (vector[i] != otherVector.vector[i]) {
                return false;
            }
        }
        return true;
    }
}